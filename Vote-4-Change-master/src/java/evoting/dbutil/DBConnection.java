    package evoting.dbutil;
    import java.sql.Connection;
    import java.sql.DriverManager;
public class DBConnection {
    private static Connection conn;
    static{
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("driver successfully loaded");
           conn=DriverManager.getConnection("jdbc:oracle:thin:@//Krishna:1521/XE","evoting","krishna");
           System.out.println("Connected successfully to the DB");
           }
           catch(ClassNotFoundException e)
           {
              System.out.println("driver not loaded successfully:"+e);
              e.printStackTrace();
           }
        catch(Exception ex){
            System.out.println("something went wrong in db:"); 
            ex.printStackTrace();
                    
        }
    }
    public static Connection getConnection(){
        return conn;
    } 
}
