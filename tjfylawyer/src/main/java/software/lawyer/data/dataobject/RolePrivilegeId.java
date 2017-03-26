package software.lawyer.data.dataobject;
// default package

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * RolePrivilegeId entity. @author MyEclipse Persistence Tools
 */


public class RolePrivilegeId  implements java.io.Serializable {


    // Fields    

     private String roleId;
     private String code;


    // Constructors

    /** default constructor */
    public RolePrivilegeId() {
    }

    
    /** full constructor */
    public RolePrivilegeId(String roleId, String code) {
        this.roleId = roleId;
        this.code = code;
    }

   
    // Property accessors

    @Column(name="role_id", nullable=false, length=32)

    public String getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Column(name="code", nullable=false, length=20)

    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof RolePrivilegeId) ) return false;
		 RolePrivilegeId castOther = ( RolePrivilegeId ) other; 
         
		 return ( (this.getRoleId()==castOther.getRoleId()) || ( this.getRoleId()!=null && castOther.getRoleId()!=null && this.getRoleId().equals(castOther.getRoleId()) ) )
 && ( (this.getCode()==castOther.getCode()) || ( this.getCode()!=null && castOther.getCode()!=null && this.getCode().equals(castOther.getCode()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getRoleId() == null ? 0 : this.getRoleId().hashCode() );
         result = 37 * result + ( getCode() == null ? 0 : this.getCode().hashCode() );
         return result;
   }   





}