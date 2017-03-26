package software.lawyer.service;

import java.io.Serializable;
import java.util.List;

import org.apache.poi.hssf.record.formula.functions.T;

import software.lawyer.data.dataobject.Info;
import software.lawyer.data.dataobject.PageResult;
import software.lawyer.util.QueryHelper;

public interface InfoService {
	// 新增
	public void save(Info info);

	// 更新
	public void update(Info info);

	// 根据id删除
	public void delete(Serializable id);

	// 根据id查找
	public Info findObjectById(Serializable id);

	// 查找列表
	public List<Info> findObjects();

	// 条件查询实体列表--查询助手queryHelper
	public List<Info> findObjects(QueryHelper queryHelper);

	// 分页条件查询实体列表--查询助手queryHelper
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo,
			int pageSize);

}
