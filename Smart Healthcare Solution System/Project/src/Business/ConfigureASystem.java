package Business;

import Business.Employee.Employee;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author ashish
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        

        EcoSystem sys = EcoSystem.getInstance();

        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        
        

        Employee employee = sys.getEmployeeDirectory().createEmployee("AA");
        
        UserAccount ua = sys.getUserAccountDirectory().createUserAccount("admin", "admin", employee, new SystemAdminRole());
        
        return sys;

    }
    
}
