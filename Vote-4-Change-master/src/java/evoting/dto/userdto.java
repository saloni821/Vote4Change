/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evoting.dto;

public class userdto {
    public String Userid;
    public String password;

    public userdto(String Userid, String password) {
        this.Userid = Userid;
        this.password = password;
    }

    @Override
    public String toString() {
        return "userdto{" + "Userid=" + Userid + ", password=" + password + '}';
    }

    public String getUserid() {
        return Userid;
    }

    public void setUserid(String Userid) {
        this.Userid = Userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
