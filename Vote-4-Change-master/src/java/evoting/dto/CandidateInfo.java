
package evoting.dto;


public class CandidateInfo {
    private String candidateId;
    private String cname;
    private String party;
    private String symbol;

    @Override
    public String toString() {
        return "CandidateInfo{" + "candidateId=" + candidateId + ", cname=" + cname + ", party=" + party + ", symbol=" + symbol + '}';
    }

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public CandidateInfo() {
    }

    public CandidateInfo(String candidateId, String cname, String party, String symbol) {
        this.candidateId = candidateId;
        this.cname = cname;
        this.party = party;
        this.symbol = symbol;
    }
    
}
