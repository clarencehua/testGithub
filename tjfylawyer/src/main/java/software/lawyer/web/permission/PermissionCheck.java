package software.lawyer.web.permission;

import software.lawyer.service.model.UserModel;

public interface PermissionCheck {
	/**
	 * 判断用户是否有 code 对应的权限
	 * @param user 用户
	 * @param code 子系统的权限标识符
	 * @return true or false
	 */
	public boolean isAccessible(UserModel user, String code);
}
