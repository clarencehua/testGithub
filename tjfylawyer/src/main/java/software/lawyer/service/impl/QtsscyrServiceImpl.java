package software.lawyer.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import software.lawyer.data.dao.QtsscyrDao;
import software.lawyer.data.dataobject.QtsscyrDO;
import software.lawyer.service.QtsscyrService;
@Service("qtsscyrService")
public class QtsscyrServiceImpl implements QtsscyrService{
	@Resource
	private QtsscyrDao qtsscyrDao;
	public List<QtsscyrDO> findObjects() {
		// TODO Auto-generated method stub
		return qtsscyrDao.findObjects();
	}

}
