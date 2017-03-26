package software.lawyer.data.dao.impl;

import org.hibernate.Query;

import software.lawyer.data.dao.QtsscyrDao;
import software.lawyer.data.dataobject.QtsscyrDO;

public class QtsscyrDaoImpl extends BaseDaoImpl<QtsscyrDO> implements QtsscyrDao {

	public QtsscyrDO findBySfzh(String sfzh) {
		String hql="select * from QtsscyrDO where spzh=?";
		
		Query query=getSession().createQuery(hql);
		query.setParameter(0, sfzh);
		return (QtsscyrDO) query.list().get(0);
	}

}
