package software.lawyer.data.dataobject;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import software.lawyer.data.dataobject.Role;

/**
 * UserRole entity. @author MyEclipse Persistence Tools
 */
@IdClass(UserRoleId.class)
@Entity
@Table(name = "user_role", catalog = "itcasttax")
public class UserRole implements java.io.Serializable {

	// Fields

	private String roleId;
	private String userId;
	private Role role;

	// Constructors

	/** default constructor */
	public UserRole() {
	}
	public UserRole(String roleId, String userId) {
		super();
		this.roleId = roleId;
		this.userId = userId;
	}
	@Id
	@Column(name = "role_id", nullable = false, length = 32)
	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	@Id
	@Column(name = "user_id", nullable = false, length = 32)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	

	

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = false, insertable = false, updatable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}