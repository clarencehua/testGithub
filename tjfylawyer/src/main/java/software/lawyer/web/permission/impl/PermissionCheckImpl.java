package software.lawyer.web.permission.impl;

import java.util.List;

import javax.annotation.Resource;

import software.lawyer.data.dataobject.Role;
import software.lawyer.data.dataobject.RolePrivilege;
import software.lawyer.data.dataobject.UserRole;
import software.lawyer.service.UserService;
import software.lawyer.service.model.UserModel;
import software.lawyer.web.permission.PermissionCheck;

public class PermissionCheckImpl implements PermissionCheck {
	@Resource
	private UserService userService;

	public boolean isAccessible(UserModel user, String code) {
		// 1、获取用户的所有角色
		List<UserRole> list = user.getUserRoles();
		if (list == null) {
			list = userService.getUserRolesByUserId(user.getId() + "");
		}
		// 2.根据每个角色对应的权限进行比较
		if (list != null && list.size() > 0) {
			for (UserRole ur : list) {
				Role role = ur.getRole();
				for (RolePrivilege rp : role.getRolePrivileges()) {
					// 对比是否有code对应的权限
					if (code.equals(rp.getCode())) {
						// 说明有权限，返回true
						return true;
					}
				}
			}
		}
		return false;
	}

}
