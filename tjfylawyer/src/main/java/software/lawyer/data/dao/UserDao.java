package software.lawyer.data.dao;

import java.util.List;

import software.lawyer.data.dataobject.User;
import software.lawyer.data.dataobject.UserRole;

public interface UserDao extends BaseDao<User> {
	public void updateEdite(User user);

	/**
	 * 根据帐号和用户id查询用户
	 * 
	 * @param id
	 *            用户ID
	 * @param account
	 *            用户帐号
	 * @return 用户列表
	 */
	public List<User> findUserByAccountAndId(String id, String account);

	// 保存用户角色
	public void saveUserRole(UserRole userRole);

	// 根据用户id删除该用户的所有用户角色
	public void deleteUserRoleByUserId(String id);

	// 根据用户id获取该用户对应的所有用户角色
	public List<UserRole> getUserRolesByUserId(String id);

	// 根据用户的帐号和密码查询用户列表
	public List<User> findUsersByAcccountAndPass(String account, String password);
}
