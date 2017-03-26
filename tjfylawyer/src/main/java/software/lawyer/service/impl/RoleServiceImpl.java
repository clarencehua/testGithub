package software.lawyer.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import software.lawyer.data.dao.RoleDao;
import software.lawyer.data.dataobject.PageResult;
import software.lawyer.data.dataobject.Role;
import software.lawyer.data.dataobject.User;
import software.lawyer.service.RoleService;
import software.lawyer.util.QueryHelper;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleDao roleDao;
	
	public void save(Role role) {
		roleDao.save(role);
	}

	public void update(Role role) {
		//1、删除该角色对于的所有权限
		roleDao.deleteRolePrivilegeByRoleId(role.getRoleId());
		//2、更新角色及其权限
		roleDao.update(role);
	}

	public void delete(Serializable id) {
		roleDao.delete(id);
	}

	public Role findObjectById(Serializable id) {
		return roleDao.findObjectById(id);
	}

	public List<Role> findObjects() {
		return roleDao.findObjects();
	}
	
	public List<Role> findObjects(QueryHelper queryHelper) {
		return roleDao.findObjects(queryHelper);
	}

	public PageResult getPageResult(QueryHelper queryHelper, int pageNo,
			int pageSize) {
		return roleDao.getPageResult(queryHelper, pageNo, pageSize);
	}
}
