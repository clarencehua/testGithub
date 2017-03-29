package software.lawyer.data.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;

import software.lawyer.data.dao.ComplainDao;
import software.lawyer.data.dataobject.Complain;

public class ComplainDaoImpl extends BaseDaoImpl<Complain> implements ComplainDao {

	public Complain findComplainById(String id) {
		String hql = "from Complain where compId =" + id+"desc by";
		return null;
		
	}

	public List<Object[]> getAnnualStatisticDataByYear(int year) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT imonth, COUNT(comp_id)")
		.append(" FROM tmonth LEFT JOIN complain ON imonth=MONTH(comp_time)")
		.append(" AND YEAR(comp_time)=?")
		.append(" GROUP BY imonth ")
		.append(" ORDER BY imonth");
		SQLQuery sqlQuery = getSession().createSQLQuery(sb.toString());
		sqlQuery.setParameter(0, year);
		return sqlQuery.list();
	}


}
