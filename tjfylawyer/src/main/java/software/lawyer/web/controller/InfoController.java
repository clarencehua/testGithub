package software.lawyer.web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import software.lawyer.data.dataobject.Info;
import software.lawyer.data.dataobject.PageResult;
import software.lawyer.service.InfoService;
import software.lawyer.service.model.InfoCustom;
import software.lawyer.util.DateUtil;
import software.lawyer.util.QueryHelper;
import software.lawyer.util.ResponseBuilder;
import software.lawyer.util.StringUtil;

@Controller
@RequestMapping("/nsfw")
public class InfoController {
	@Resource
	private InfoService infoService;
	//private String strTitle;

	// 列表页面
	@RequestMapping(value = "info_listUI.do", method = {RequestMethod.POST,RequestMethod.GET})
	public String listUI(HttpServletRequest request,
			HttpServletResponse response,InfoCustom infoCustom) {
		PageResult pageResult=new PageResult();
		String pageNo=request.getParameter("pageNo");
		pageNo= (String) ((pageNo==null)?"1":pageNo);
		pageResult.setPageNo(Integer.parseInt(pageNo));
		
		Info info=infoCustom.getInfo();
		//strTitle = info==null?" ":info.getTitle();
		QueryHelper queryHelper=new QueryHelper(Info.class, "i");
		if (info!=null) {
			if (!StringUtil.isBlank(info.getTitle())) {
				queryHelper.addCondition("i.title like ?", "%"+info.getTitle()+"%");
			}
		}
		//根据创建时间排序
		queryHelper.addOrderByProperty("i.createTime", QueryHelper.ORDER_BY_DESC);
		
		PageResult pageResult2 = infoService.getPageResult(queryHelper,pageResult.getPageNo(),3);
		request.setAttribute("pageResult", pageResult2);
		//request.setAttribute("info", info==null?" ":info.getTitle());
		return "info/listUI";
	}

	// 跳转到新增页面
	@RequestMapping(value = "info_addUI.do", method = RequestMethod.POST)
	public String addUI(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		model.addAttribute("date",
				DateUtil.format(new Date(), DateUtil.secondFormat));
		request.setAttribute("xxfl", new Info().INFO_TYPE_MAP);
		return "info/addUI";
	}

	@RequestMapping(value = "info_add.do", method = RequestMethod.POST)
	public String add(HttpServletRequest request, HttpServletResponse response,
			InfoCustom infoCustom) {
		Info info = infoCustom.getInfo();
		infoService.save(info);
		return "redirect:info_listUI.do";
	}

	// info_editUI.do
	@RequestMapping(value = "info_editUI.do", method = RequestMethod.POST)
	public String editUI(HttpServletRequest request,
			HttpServletResponse response, InfoCustom infoCustom) {
		request.setAttribute("xxfl", new Info().INFO_TYPE_MAP);
		Info info = infoCustom.getInfo();
		if (info != null && info.getInfoId() != null) {
			info = infoService.findObjectById(info.getInfoId());
		}
		request.setAttribute("info", info);
		return "info/editUI";
	}

	// bao
	@RequestMapping(value = "info_edit.do", method = RequestMethod.POST)
	public String edit(HttpServletRequest request,
			HttpServletResponse response, InfoCustom infoCustom) {
		Info info = infoCustom.getInfo();
		if (info != null && info.getInfoId() != null) {
			infoService.update(info);
		}
		return "redirect:info_listUI.do";
		//return "redirect:info_listUI.do?strTitle="+strTitle;
	}

	//
	@RequestMapping(value = "info_delete.do", method = RequestMethod.POST)
	public String delete(HttpServletRequest request,
			HttpServletResponse response, InfoCustom infoCustom) {
		Info info = infoCustom.getInfo();
		if (info != null && info.getInfoId() != null) {
			infoService.delete(info.getInfoId());
		}
		return "redirect:info_listUI.do";
	//	return "redirect:info_listUI.do?strTitle="+strTitle;
	}

	// 批量删除user_deleteSelected.do
	@RequestMapping(value = "info_deleteSelected.do", method = RequestMethod.POST)
	public String deleteSelected(HttpServletRequest request,
			HttpServletResponse response, InfoCustom infoCustom, Model model) {
		String str[] = request.getParameter("id").split(",");
		for (String string : str) {
			infoService.delete(string);
		}
		return "redirect:info_listUI.do";
		//return "redirect:info_listUI.do?strTitle="+strTitle;
	}
	//info_publicInfo.do
	@RequestMapping(value = "info_publicInfo.do", method = RequestMethod.POST)
	public void publicInfo(HttpServletRequest request,
			HttpServletResponse response, InfoCustom infoCustom, Model model) throws IOException {
		Info info = infoCustom.getInfo();
		// 1、更新信息状态
		Info tem = infoService.findObjectById(info.getInfoId());
		tem.setState(info.getState());
		infoService.update(tem);
		Map map=new HashMap();
		map.put("key", "更新状态成功");
		new ResponseBuilder().writeJsonResponse(response, map);
		/*response.setContentType("text/html");
		ServletOutputStream outputStream = response.getOutputStream();
		outputStream.write("更新状态成功".getBytes("utf-8"));
		outputStream.close();
		*/
	}
}
