package edu.unimagdalena.covid.jwt.model;

public enum UserRole {

  ROLE_USER("ROLE_USER"), ROLE_ADMIN("ROLE_ADMIN"),ROLE_SUPERADMIN("ROLE_SUPERADMIN");
	
	private String roleAssigned;
    private UserRole(String roleAssigned) {
        this.roleAssigned = roleAssigned;
    }
   
    @Override
    public String toString(){
        return roleAssigned;
    }
}
