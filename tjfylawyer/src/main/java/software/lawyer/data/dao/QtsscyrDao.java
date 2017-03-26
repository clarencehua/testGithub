package software.lawyer.data.dao;

import software.lawyer.data.dataobject.QtsscyrDO;

public interface QtsscyrDao extends BaseDao<QtsscyrDO>{
	public QtsscyrDO findBySfzh(String sfzh);
}
