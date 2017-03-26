package software.lawyer.data.dao.impl;

import java.util.List;

import org.hibernate.Query;

import software.lawyer.data.dao.UserDao;
import software.lawyer.data.dataobject.User;
import software.lawyer.data.dataobject.UserRole;
import software.lawyer.util.StringUtil;
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	public void updateEdite(User user) {
		String sql="update user set name=?,dept=?,account=?,gender=?,email=?,mobile=?,birthday=?,state=?,memo=? where id=?";
		Query query=this.getSession().createSQLQuery(sql);
		query.setString(0, user.getName());
		query.setString(1, user.getDept());
		query.setString(2, user.getAccount());
		query.setBoolean(3, user.isGender());
		query.setString(4, user.getEmail());
		query.setString(5, user.getMobile());
		query.setString(6, user.getBirthday());
		query.setString(7, user.getState());
		query.setString(8, user.getMemo());
		query.setInteger(9, user.getId());
		query.executeUpdate();
	}

	public List<User> findUserByAccountAndId(String id, String account) {
		String hql = "FROM User WHERE account = ?";
		if(StringUtil.isNotBlank(id)){
			hql += " AND id!=?";
		}
		Query query = getSession().createQuery(hql);
		query.setString(0, account);
		if(StringUtil.isNotBlank(id)){
			query.setString(1, id);
		}
		
		return query.list();
	}

	public void saveUserRole(UserRole userRole) {
		getHibernateTemplate().save(userRole);
	}

	public void deleteUserRoleByUserId(String id) {
		Query query = getSession().createQuery("DELETE FROM UserRole WHERE userId=?");
		query.setParameter(0, id);
		query.executeUpdate();
	}

	public List<UserRole> getUserRolesByUserId(String id) {
		Query query = getSession().createQuery("FROM UserRole WHERE userId=?");
		query.setParameter(0, id);
		return query.list();
	}

	public List<User> findUsersByAcccountAndPass(String account, String password) {
		Query query = getSession().createQuery("FROM User WHERE account=? AND password=?");
		query.setParameter(0, account);
		query.setParameter(1, password);
		return query.list();
	}
}
