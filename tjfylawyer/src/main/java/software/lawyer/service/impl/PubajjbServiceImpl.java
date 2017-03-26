package software.lawyer.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import software.lawyer.data.dao.PubajjbDao;
import software.lawyer.data.dataobject.PubAjJb;
import software.lawyer.service.PubAjjbService;
@Service("pubajjbService")
public class PubajjbServiceImpl implements PubAjjbService {
	@Resource
	private PubajjbDao pubajjbDao; 

	public void setPubajjbDao(PubajjbDao pubajjbDao) {
		this.pubajjbDao = pubajjbDao;
	}

	public List<PubAjJb> findObjects() {
		// TODO Auto-generated method stub
		return pubajjbDao.findObjects();
	}

	public PubAjJb getAjJbDObyAjxh(long ajxh) {
		// TODO Auto-generated method stub
		return pubajjbDao.getAjJbDObyAjxh(ajxh);
	}

	public List<PubAjJb> getLawyerIiformation(String sfzh) {
		// TODO Auto-generated method stub
		return pubajjbDao.find(sfzh);
	}
	
	
}
