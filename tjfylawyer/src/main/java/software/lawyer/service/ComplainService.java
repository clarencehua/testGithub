package software.lawyer.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import software.lawyer.data.dataobject.Complain;
import software.lawyer.data.dataobject.PageResult;
import software.lawyer.util.QueryHelper;

public interface ComplainService {
	// 新增
	public void save(Complain complain);

	// 更新
	public void update(Complain complain);

	// 根据id删除
	public void delete(Serializable id);

	// 根据id查找
	public Complain findObjectById(Serializable id);

	// 查找列表
	public List<Complain> findObjects();

	// 条件查询实体列表--查询助手queryHelper
	public List<Complain> findObjects(QueryHelper queryHelper);

	// 分页条件查询实体列表--查询助手queryHelper
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo,
			int pageSize);

	// 自动受理投诉
	public void autoDeal();
	/**
	 * 根据年份获取统计年度的每个月的投诉数
	 * @param year 要统计的年份
	 * @return 统计数据
	 */
	public List<Map> getAnnualStatisticDataByYear(int year);
}
