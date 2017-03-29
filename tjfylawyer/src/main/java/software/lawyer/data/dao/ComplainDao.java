package software.lawyer.data.dao;

import java.util.List;

import software.lawyer.data.dataobject.Complain;

public interface ComplainDao extends BaseDao<Complain>{
	public Complain findComplainById(String id);
	/**
	 * 根据年份获取统计年度的每个月的投诉数
	 * @param year 要统计的年份
	 * @return 统计数据
	 */
	public List<Object[]> getAnnualStatisticDataByYear(int year);
}
