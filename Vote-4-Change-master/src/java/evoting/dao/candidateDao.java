
package evoting.dao;
import evoting.dbutil.DBConnection;
import evoting.dto.AddCandidateDTO;
import evoting.dto.AddCandidateDetails;
import evoting.dto.CandidateInfo;
import java.awt.BorderLayout;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;
import oracle.sql.BLOB;

public class candidateDao {
    private static Statement st;
    private static PreparedStatement ps,ps1,ps2,ps3,ps4,ps5;
    static{
        try{
           st=DBConnection.getConnection().createStatement();
        ps=DBConnection.getConnection().prepareStatement("select max(candidate_id) from candidate");
      ps1=DBConnection.getConnection().prepareStatement("select username from user_details where adhar_no=?");
       ps2=DBConnection.getConnection().prepareStatement("select distinct city from user_details");
        ps3=DBConnection.getConnection().prepareStatement("insert into candidate values(?,?,?,?,?)");
        ps4=DBConnection.getConnection().prepareStatement("select * from candidate where candidate_id=?");
        ps5=DBConnection.getConnection().prepareStatement("select candidate_id,username,party,symbol from candidate,user_details where candidate.user_id=user_details.adhar_no and candidate.city=(select city from user_details where adhar_no=?)");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static String getNewId()throws SQLException{
      ResultSet rs= ps.executeQuery();
      rs.next();
      String cid=rs.getString(1);
       if(cid==null){
           return "C101";
       }
       else{
           int id=Integer.parseInt(cid.substring(1));
           return "C"+(id+1);
       }
        
    }
    public static String getUserNameById(String uid)throws SQLException{
        ps1.setString(1,uid);
         ResultSet rs= ps1.executeQuery();
         if(rs.next()){
        return rs.getString(1);
    }
    else{
     return null;
         }
    }
    public static ArrayList<String> getCity()throws SQLException{
          ResultSet rs= ps2.executeQuery();
          ArrayList<String> cityList=new ArrayList<>();
          while(rs.next()){
              String city=rs.getString(1);
              cityList.add(city);
          }
          return cityList;
        
    }
    public static boolean addCandidate(AddCandidateDTO candidate)throws SQLException{
        ps3.setString(1, candidate.getCandidateiId());
        ps3.setString(2,candidate.getParty());
        ps3.setString(3,candidate.getUserId());
        ps3.setBinaryStream(4,candidate.getSymbol());
        ps3.setString(5,candidate.getCity());
        return(ps3.executeUpdate()!=0);
    }
    public static ArrayList<String> getAllCandidateid()throws SQLException{
        ResultSet rs=st.executeQuery("select candidate_id from candidate");
        ArrayList<String> id=new ArrayList<>();
        while(rs.next()){
          id.add(rs.getString(1));
        }
        return id;
    }
public static AddCandidateDetails getDetailsbyId(String cid) throws Exception{
 ps4.setString(1, cid);
ResultSet rs=ps4.executeQuery();
AddCandidateDetails cd=new AddCandidateDetails();
;
BLOB blob;
InputStream stream;
ByteArrayOutputStream outputstream;
byte[] buffer;
int byteread;
byte[] imagebytes;
String base64image;
  
if(rs.next()){
    blob=(BLOB)rs.getBlob(4);
    stream=blob.getBinaryStream();
    outputstream=new ByteArrayOutputStream();
    buffer=new byte[4096];
    byteread=-1;
    while((byteread=stream.read(buffer))!=-1){
    outputstream.write(buffer,0, byteread);
    }
   
    imagebytes=outputstream.toByteArray();
    Base64.Encoder en=Base64.getEncoder();
    base64image=en.encodeToString(imagebytes);
     
    cd.setSymbol(base64image);

    cd.setCid(cid);
    cd.setCname(getUserNameById(rs.getString(3)));
    cd.setParty(rs.getString(2));
    cd.setCity(rs.getString(5));
    cd.setUserid(rs.getString(3));

    System.out.println(cd.getCity());
}
    return cd;
}
public static ArrayList<CandidateInfo> viewCandidate(String userid)throws Exception{
 
 ArrayList<CandidateInfo> list=new ArrayList<>();
    System.out.println("be th array");
 ps5.setString(1, userid);
    System.out.println("status");
 ResultSet rs=ps5.executeQuery();
 BLOB blob;
InputStream stream;
ByteArrayOutputStream outputstream;
byte[] buffer;
int byteread;
byte[] imagebytes;
String base64image;
    System.out.println("inside view");
    if(rs.next()==false){
        System.out.println("false");
    }
while(rs.next()){
    System.out.println("krishna");
      blob=(BLOB)rs.getBlob(4);
    stream=blob.getBinaryStream();
    outputstream=new ByteArrayOutputStream();
    buffer=new byte[4096];
    byteread=-1;
    while((byteread=stream.read(buffer))!=-1){
    outputstream.write(buffer,0,byteread);
    }
   
    imagebytes=outputstream.toByteArray();
    
    Base64.Encoder en=Base64.getEncoder();
    base64image=en.encodeToString(imagebytes);
    CandidateInfo candidate=new CandidateInfo();
    System.out.println(rs.getString(1));
    System.out.println(rs.getString(2));
     System.out.println(rs.getString(3));
     candidate.setCandidateId(rs.getString(1));
    candidate.setCname(rs.getString(2));
    candidate.setParty(rs.getString(3));
    candidate.setSymbol(base64image);
    list.add(candidate);
   
    
}
return list;
}
}
