/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grade12pat;

/**
 *
 * @author yaseen
 */
public class User {
    enum Role {DOCTOR, RECEPTIONIST};

    private Role role;
    private String userName;

    public User(String userName, Role role){
        this.userName = userName;
        this.role = role;
    }
    public User(String userName, String role) throws InvalidRoleException {
        this.userName = userName;
        this.role = User.roleFromString(role);
    }
    private static Role roleFromString(String role) throws InvalidRoleException {
        if (role.equalsIgnoreCase("doctor")) {
            return Role.DOCTOR;
        } else if (role.equalsIgnoreCase("receptionist")) {
            return Role.RECEPTIONIST;
        }
        throw new InvalidRoleException();
    }
}

class InvalidRoleException extends Exception{
    
}