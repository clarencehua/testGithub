package software.lawyer.web.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import software.lawyer.data.dataobject.Complain;
import software.lawyer.data.dataobject.ComplainReply;
import software.lawyer.data.dataobject.PageResult;
import software.lawyer.service.ComplainService;
import software.lawyer.service.model.ComplainCustom;
import software.lawyer.service.model.ComplainReplyCustom;
import software.lawyer.util.DateUtil;
import software.lawyer.util.QueryHelper;
import software.lawyer.util.StringUtil;

@Controller
@RequestMapping("/nsfw")
public class ComplainController {
	@Resource
	private ComplainService complainService;
	

	public ComplainService getComplainService() {
		return complainService;
	}

	public void setComplainService(ComplainService complainService) {
		this.complainService = complainService;
	}

	// complain_listUI.do
	// 列表页面
	@RequestMapping(value = "complain_listUI.do", method = {
			RequestMethod.POST, RequestMethod.GET })
	public String listUI(HttpServletRequest request,
			HttpServletResponse response, ComplainCustom complainCustom) {
		PageResult pageResult = new PageResult();
		String pageNo = request.getParameter("pageNo");
		pageNo = (String) ((pageNo == null) ? "1" : pageNo);
		pageResult.setPageNo(Integer.parseInt(pageNo));
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		Complain complain = complainCustom.getComplain();
		QueryHelper queryHelper = new QueryHelper(Complain.class, "c");
		if (!StringUtil.isBlank(startTime)) {
			queryHelper.addCondition("c.compTime >= ?", startTime + ":00");
		}
		if (!StringUtil.isBlank(endTime)) {
			queryHelper.addCondition("c.compTime <= ?", endTime + ":59");
		}
		if (complain != null) {
			if (!StringUtil.isBlank(complain.getState())
					&& !complain.getState().equals("全部")) {
				queryHelper.addCondition("c.state=?", complain.getState());
			}
			if (!StringUtil.isBlank(complain.getCompTitle())) {
				queryHelper.addCondition("c.compTitle like ?",
						"%" + complain.getCompTitle() + "%");
			}
		}
		// 安装状态升序排序
		queryHelper.addOrderByProperty("c.state", QueryHelper.ORDER_BY_ASC);
		// 按照投诉时间升序排序
		queryHelper.addOrderByProperty("c.compTime", QueryHelper.ORDER_BY_ASC);

		pageResult = complainService.getPageResult(queryHelper,
				pageResult.getPageNo(), 3);

		request.setAttribute("pageResult", pageResult);
		request.setAttribute("complainStateMap", Complain.COMPLAIN_STATE_MAP);
		return "complain/listUI";
	}

	// complain_dealUI.do
	@RequestMapping(value = "complain_dealUI.do", method = RequestMethod.POST)
	public String dealUI(HttpServletRequest request,
			HttpServletResponse response, ComplainCustom complainCustom) {
		request.setAttribute("complainStateMap", Complain.COMPLAIN_STATE_MAP);
		Complain complain = complainCustom.getComplain();
		if (complain != null) {
			complain = complainService.findObjectById(complain.getCompId());
		}
		request.setAttribute("complain", complain);
		return "complain/dealUI";
	}

	// complain_deal.do
	@RequestMapping(value = "complain_deal.do", method = RequestMethod.POST)
	public String deal(HttpServletRequest request,
			HttpServletResponse response, ComplainCustom complainCustom,ComplainReplyCustom complainReplyCustom) {
		Complain complain = complainCustom.getComplain();
		ComplainReply reply=complainReplyCustom.getComplainReply();
		if (complain != null) {
			Complain tem = complainService.findObjectById(complain.getCompId());
			// 1、更新投诉的状态为 已受理
			if (!Complain.COMPLAIN_STATE_DONE.equals(tem.getState())) {// 更新状态为
																		// 已受理
				tem.setState(Complain.COMPLAIN_STATE_DONE);
			}
			// 2、保存回复信息
			if (reply != null) {
				reply.setComplain(tem);
				reply.setReplyTime(DateUtil.format(new Date(),
						DateUtil.secondFormat));
				tem.getComplainReplies().add(reply);
			}
			complainService.update(tem);
		}
		return "redirect:complain_listUI.do";
	}

}
