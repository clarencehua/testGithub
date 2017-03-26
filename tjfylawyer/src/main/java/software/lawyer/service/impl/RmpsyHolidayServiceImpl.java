package software.lawyer.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import software.lawyer.data.dao.RmpsyHolidayDao;
import software.lawyer.data.dataobject.RmpsyHolidayDO;
import software.lawyer.service.RmpsyHolidayService;
@Service("rmpsyHolidayService")
public class RmpsyHolidayServiceImpl implements RmpsyHolidayService{
	@Resource
	private RmpsyHolidayDao rmpsyHolidayDao;
	public List<RmpsyHolidayDO> findObjects() {
		// TODO Auto-generated method stub
		return rmpsyHolidayDao.findObjects();
	}

}
