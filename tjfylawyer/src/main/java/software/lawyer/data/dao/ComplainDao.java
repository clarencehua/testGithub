package software.lawyer.data.dao;

import software.lawyer.data.dataobject.Complain;

public interface ComplainDao extends BaseDao<Complain>{
	public Complain findComplainById(String id);
}
