package software.lawyer.data.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;

import software.lawyer.data.dao.PubajjbDao;
import software.lawyer.data.dataobject.PubAjJb;
import software.lawyer.service.model.AjjbQss;

public class PubajjbDaoImpl extends BaseDaoImpl<PubAjJb> implements PubajjbDao{
	private static final Logger log = Logger.getLogger(PubajjbDaoImpl.class);
	public PubAjJb getAjJbDObyAjxh(long ajxh) {
		String hql = "from PubAjJb where ajxh =" + ajxh;
		@SuppressWarnings("unchecked")
		List<PubAjJb> res = this.getHibernateTemplate().find(hql);
		if (log.isInfoEnabled()) {
			log.info("getAjJbDO By Hql : " + hql);
		}
		return (res == null || res.size() == 0) ? null : res.get(0);
	}
	
	public List<PubAjJb> find(String sfzh){
		String sql="select * from PUB_AJ_JB where AJXH in (select AJXH from PUB_QTSSCYR where ZC='1' and ZJLB='A' and SFZHM="+"'"+sfzh+"'"+")";
		//String sql="select * from PUB_AJ_JB where AJXH in (select AJXH from PUB_QTSSCYR where ZC='1' and ZW="+"'"+sfzh+"'"+")";
		System.out.println(sql);
		Query query=getSession().createSQLQuery(sql).addEntity(PubAjJb.class);
		
		//this.getSession().close();
		//System.out.println(query.list());
		return query.list();
		
	}
}
