
package evoting.dao;

import evoting.dbutil.DBConnection;
import evoting.dto.CandidateInfo;
import evoting.dto.voteDto;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Base64;
import oracle.sql.BLOB;


public class VoteDao {
     private static PreparedStatement ps1,ps2,ps3;
     static{
     try{
     ps1=DBConnection.getConnection().prepareStatement("select candidate_id from voting where voter_id=?"); 
     ps2=DBConnection.getConnection().prepareStatement("select candidate_id,username,party,symbol from candidate,user_details where candidate.user_id=user_details.adhar_no and candidate_id=?");
     ps3=DBConnection.getConnection().prepareStatement("insert into voting values(?,?)");
    }
     catch(SQLException ex){
     ex.printStackTrace();
        
    }
    }
     public static String getCandidateId(String userId)throws SQLException{
         ps1.setString(1, userId);
         ResultSet rs=ps1.executeQuery();
         if(rs.next()){
          return rs.getString(1);
         }
         else{
             return null;
         }
         
     }
     public static CandidateInfo getVote(String candidateid)throws Exception{
        CandidateInfo candidate=new CandidateInfo();
BLOB blob;
InputStream stream;
ByteArrayOutputStream outputstream;
byte[] buffer;
int byteread;
byte[] imagebytes;
String base64image;
ps2.setString(1,candidateid);
ResultSet rs=ps2.executeQuery();
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
    candidate.setCandidateId(rs.getString(1));
    candidate.setCname(rs.getString(2));
    candidate.setParty(rs.getString(3));
    candidate.setSymbol(base64image);
}
return candidate;
     }
     public static boolean addsVote(voteDto vote)throws SQLException{
         ps3.setString(1,vote.getCandidateId());
         ps3.setString(2,vote.getVoterId());
         return (ps3.executeUpdate()!=0);
        
     }
     
   
}
