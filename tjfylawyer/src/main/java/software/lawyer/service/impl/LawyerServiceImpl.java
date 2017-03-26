package software.lawyer.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import software.lawyer.data.dao.LawyerDao;
import software.lawyer.data.dataobject.Lawyer;
import software.lawyer.service.LawyerService;
@Service("lawyerService")
public class LawyerServiceImpl implements LawyerService{
	@Resource
	private LawyerDao lawyerDao;

	public void save(Lawyer lawyer) {
		// TODO Auto-generated method stub
		
	}

	public List<Lawyer> find() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
