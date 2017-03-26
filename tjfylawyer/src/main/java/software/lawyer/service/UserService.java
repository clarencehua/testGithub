package software.lawyer.service;

import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import javax.servlet.ServletOutputStream;

import software.lawyer.data.dataobject.Info;
import software.lawyer.data.dataobject.PageResult;
import software.lawyer.data.dataobject.User;
import software.lawyer.data.dataobject.UserRole;
import software.lawyer.util.QueryHelper;

/**
 * �û�Service
 * 
 * @author wzq 2015-7-5
 */
public interface UserService {
	// 新增
	public void save(User user);

	// 更新
	public void update(User user);

	// 根据id删除O
	public void delete(Serializable id);

	// 根据id查找
	public User findObjectById(Serializable id);

	// 查找列表
	public List<User> findObjects();

	// 导出用户列表
	public void exportExcel(List<User> userList,
			ServletOutputStream outputStream);

	// 导入用户列表
	public void importExcel(InputStream fileInputStream,
			String userExcelFileName);

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

	// 保存用户及其对应的角色
	public void saveUserAndRole(User user, String... roleIds);

	// 更新用户及其对应的角色
	public void updateUserAndRole(User user, String... roleIds);

	// 根据用户id获取该用户对应的所有用户角色
	public List<UserRole> getUserRolesByUserId(String id);

	// 根据用户的帐号和密码查询用户列表
	public List<User> findUserByAccountAndPass(String account, String password);

	// 条件查询实体列表--查询助手queryHelper
	public List<User> findObjects(QueryHelper queryHelper);

	// 分页条件查询实体列表--查询助手queryHelper
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo,
			int pageSize);
}
