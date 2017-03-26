package software.lawyer.data.dao;

import software.lawyer.data.dataobject.Role;

public interface RoleDao extends BaseDao<Role> {

	//删除该角色对于的所有权限
	public void deleteRolePrivilegeByRoleId(String roleId);

}
