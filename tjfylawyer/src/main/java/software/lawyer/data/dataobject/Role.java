package software.lawyer.data.dataobject;
// default package

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "role", catalog = "itcasttax")
public class Role implements java.io.Serializable {

	// Fields

	private String roleId;
	private String name;
	private String state;
	private Set<RolePrivilege> rolePrivileges;
	private Set<UserRole> userRoles;
	// 角色状态
	public static String ROLE_STATE_VALID = "1";// 有效
	public static String ROLE_STATE_INVALID = "0";// 无效

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** minimal constructor */
	public Role(String roleId, String name) {
		this.roleId = roleId;
		this.name = name;
	}

	/** full constructor */
	public Role(String roleId, String name, String state,
			Set<RolePrivilege> rolePrivileges) {
		this.roleId = roleId;
		this.name = name;
		this.state = state;
		this.rolePrivileges = rolePrivileges;
	}

	// Property accessors
	@Id
	@Column(name = "role_id", unique = true, nullable = false, length = 32)
	/*@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")*/
	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "state", length = 1)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "role")
	public Set<RolePrivilege> getRolePrivileges() {
		return this.rolePrivileges;
	}

	public void setRolePrivileges(Set<RolePrivilege> rolePrivileges) {
		this.rolePrivileges = rolePrivileges;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "role")
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	
	
}