package software.lawyer.data.dao.impl;

import java.io.Serializable;
import java.util.List;

import software.lawyer.data.dao.ComplainDao;
import software.lawyer.data.dataobject.Complain;
import software.lawyer.data.dataobject.PageResult;
import software.lawyer.util.QueryHelper;

public class ComplainDaoImpl extends BaseDaoImpl<Complain> implements ComplainDao {

	public Complain findComplainById(String id) {
		String hql = "from Complain where compId =" + id+"desc by";
		return null;
		
	}


}
