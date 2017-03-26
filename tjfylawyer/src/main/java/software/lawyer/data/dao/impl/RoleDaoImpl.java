package software.lawyer.data.dao.impl;

import org.hibernate.Query;

import software.lawyer.data.dao.RoleDao;
import software.lawyer.data.dataobject.Role;

public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

	public void deleteRolePrivilegeByRoleId(String roleId) {
		Query query = getSession().createQuery("DELETE FROM RolePrivilege WHERE roleId=?");
		query.setParameter(0, roleId);
		query.executeUpdate();
	}

}
