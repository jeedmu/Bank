package dk.eamv.bank.javafx.viewModels;

import dk.eamv.bank.javafx.domain.Role;
import dk.eamv.bank.javafx.domain.Role.Builder;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RoleProperty {
	private StringProperty roleID = new SimpleStringProperty();
	public final String getRoleID() {return roleID.get();}
	public final void setRoleID(String value){roleID.set(value);}
	public StringProperty roleID(){return roleID;}
	
	private StringProperty roleName = new SimpleStringProperty();
	public final String getRoleName() {return roleName.get();}
	public final void setRoleName(String value){roleName.set(value);}
	public StringProperty roleName(){return roleName;}
	
	public static RoleProperty domainToModel(Role role)
	{
		RoleProperty roleProperty =new RoleProperty();
		
		roleProperty.setRoleID(""+role.getRoleID());
		roleProperty.setRoleName(""+role.getRoleName());
			
		return roleProperty;
	}
	
	public Role toDomain()
	{
		Role.Builder builder = new Builder(Integer.parseInt(getRoleID()), getRoleName());
		Role role = builder.build();
		
		return role;
	}
}
