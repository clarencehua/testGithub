package software.lawyer.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.record.formula.functions.T;
import org.springframework.stereotype.Service;

import software.lawyer.data.dao.InfoDao;
import software.lawyer.data.dataobject.Info;
import software.lawyer.data.dataobject.PageResult;
import software.lawyer.service.InfoService;
import software.lawyer.util.QueryHelper;

@Service("infoService")
public class InfoServiceImpl implements InfoService {

	@Resource
	private InfoDao infoDao;

	public void save(Info info) {
		infoDao.save(info);
	}

	public void update(Info info) {
		infoDao.update(info);
	}

	public void delete(Serializable id) {
		infoDao.delete(id);
	}

	public Info findObjectById(Serializable id) {
		return infoDao.findObjectById(id);
	}

	public List<Info> findObjects() {
		return infoDao.findObjects();
	}

	public List<Info> findObjects(QueryHelper queryHelper) {
		return infoDao.findObjects(queryHelper);
	}

	public PageResult getPageResult(QueryHelper queryHelper, int pageNo,
			int pageSize) {
		return infoDao.getPageResult(queryHelper, pageNo, pageSize);
	}
}
