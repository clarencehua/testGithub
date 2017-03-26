package software.lawyer.service.convertor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import software.lawyer.data.dataobject.Role;
import software.lawyer.data.dataobject.RolePrivilege;
import software.lawyer.dynamicds.Constant;
import software.lawyer.service.model.RoleModel;
import software.lawyer.service.model.RolePrivilegeModel;

public class RoleConvertor {
	public List<RoleModel> roleDescribe(List<Role> roleList){
		List<RoleModel> list=new ArrayList<RoleModel>();
		List<Role> roles=roleList;
		for (Role role : roles) {
			Set<RolePrivilegeModel> set1=new HashSet<RolePrivilegeModel>();
			Set<RolePrivilege> set=role.getRolePrivileges();
			for (RolePrivilege rolePrivilege : set) {
				//rolePrivilege.getCode()
				RolePrivilegeModel rolePrivilegeModel=new RolePrivilegeModel();
				rolePrivilegeModel.setCode(rolePrivilege.getCode());
				rolePrivilegeModel.setRole(rolePrivilege.getRole());
				rolePrivilegeModel.setRoleId(rolePrivilege.getRoleId());
				Map<String, String> map=Constant.PRIVILEGE_MAP;
				Set<Map.Entry<String,String>> set2 = map.entrySet();
				for (Map.Entry<String, String> me : set2) {
					if (me.getKey().equals(rolePrivilege.getCode())) {
						rolePrivilegeModel.setMc(me.getValue());
					}
				}
				set1.add(rolePrivilegeModel);
			}
			RoleModel roleModel=new RoleModel();
			roleModel.setName(role.getName());
			roleModel.setRoleId(role.getRoleId());
			roleModel.setRolePrivilegeModels(set1);
			roleModel.setState(role.getState());
			list.add(roleModel);
		}
		return list;
		
	}
}
