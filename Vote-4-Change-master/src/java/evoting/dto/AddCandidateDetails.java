
package evoting.dto;


public class AddCandidateDetails {

    public AddCandidateDetails() {
    }

    @Override
    public String toString() {
        return "AddCandidateDetails{" + "cid=" + cid + ", userid=" + userid + ", cname=" + cname + ", symbol=" + symbol + ", party=" + party + ", city=" + city + '}';
    }
    private String cid;
    private String userid;
    private String cname;
    private String symbol;
    private String party;
    private String city;

    public AddCandidateDetails(String cid, String userid, String cname, String symbol, String party, String city) {
        this.cid = cid;
        this.userid = userid;
        this.cname = cname;
        this.symbol = symbol;
        this.party = party;
        this.city = city;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    
}
