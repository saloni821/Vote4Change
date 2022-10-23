
package evoting.dao;

import evoting.dbutil.DBConnection;
import evoting.dto.userdto;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
public class userDao {
    private static PreparedStatement ps;
   static
   {
       try {
           ps=DBConnection.getConnection().prepareStatement("select user_type from user_details where adhar_no=? and password=?");
          
       } catch (SQLException ex) {
           ex.printStackTrace();
           System.out.println("something went wrong in DB");
       }}
    public static String validateUser(userdto user)throws SQLException{
        ps.setString(1, user.getUserid());
        ps.setString(2, user.getPassword());
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
             System.out.println("laluyadav");
            return rs.getString(1);
           
    }
        else
        {
            return null;
        }
        
    }
}
