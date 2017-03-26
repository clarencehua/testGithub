package software.lawyer.service.model;

import java.util.Set;

public class RoleModel {
	private String roleId;
	private String name;
	private String state;
	private Set<RolePrivilegeModel> rolePrivilegeModels;
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Set<RolePrivilegeModel> getRolePrivilegeModels() {
		return rolePrivilegeModels;
	}
	public void setRolePrivilegeModels(Set<RolePrivilegeModel> rolePrivilegeModels) {
		this.rolePrivilegeModels = rolePrivilegeModels;
	}
	
}
