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

/**
 * RolePrivilege entity. @author MyEclipse Persistence Tools
 */
@IdClass(RolePrivilegeId.class)
@Entity
@Table(name = "role_privilege", catalog = "itcasttax")
public class RolePrivilege implements java.io.Serializable {

	// Fields

	private Role role;
	private String roleId;
	private String code;

	// Constructors

	/** default constructor */
	public RolePrivilege() {
	}
    // Property accessors
	@Id
    @Column(name="role_id", nullable=false, length=32)

    public String getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    @Id
    @Column(name="code", nullable=false, length=20)

    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
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