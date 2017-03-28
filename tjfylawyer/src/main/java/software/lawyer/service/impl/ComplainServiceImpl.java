package software.lawyer.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import software.lawyer.data.dao.ComplainDao;
import software.lawyer.data.dataobject.Complain;
import software.lawyer.data.dataobject.PageResult;
import software.lawyer.service.ComplainService;
import software.lawyer.util.QueryHelper;
@Service("complainService")
public class ComplainServiceImpl implements ComplainService {
	@Resource
	private ComplainDao complainDao;
	
	public ComplainDao getComplainDao() {
		return complainDao;
	}

	public void setComplainDao(ComplainDao complainDao) {
		this.complainDao = complainDao;
	}

	public void save(Complain complain) {
		complainDao.save(complain);
	}

	public void update(Complain complain) {
		complainDao.update(complain);
	}

	public void delete(Serializable id) {
		complainDao.delete(id);
	}

	public Complain findObjectById(Serializable id) {
		return complainDao.findObjectById(id);
	}

	public List<Complain> findObjects() {
		return complainDao.findObjects();
	}

	public List<Complain> findObjects(QueryHelper queryHelper) {
		return complainDao.findObjects(queryHelper);
	}

	public PageResult getPageResult(QueryHelper queryHelper, int pageNo,
			int pageSize) {
		return complainDao.getPageResult(queryHelper, pageNo, pageSize);
	}

}
