package software.lawyer.service;

import java.io.Serializable;
import java.util.List;

import software.lawyer.data.dataobject.PageResult;
import software.lawyer.data.dataobject.Role;
import software.lawyer.data.dataobject.User;
import software.lawyer.util.QueryHelper;

public interface RoleService {
	// 新增
	public void save(Role role);

	// 更新
	public void update(Role role);

	// 根据id删除
	public void delete(Serializable id);

	// 根据id查找
	public Role findObjectById(Serializable id);

	// 查找列表
	public List<Role> findObjects();

	// 条件查询实体列表--查询助手queryHelper
	public List<Role> findObjects(QueryHelper queryHelper);

	// 分页条件查询实体列表--查询助手queryHelper
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo,
			int pageSize);
}
