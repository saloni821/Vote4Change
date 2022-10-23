
package evoting.dto;
import java.io.InputStream;

public class AddCandidateDTO {

    public AddCandidateDTO() {
    }

    public AddCandidateDTO(String candidateiId, String party, String city, String userId, InputStream symbol) {
        this.candidateiId = candidateiId;
        this.party = party;
        this.city = city;
        this.userId = userId;
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "AddCandidateDTO{" + "candidateiId=" + candidateiId + ", party=" + party + ", city=" + city + ", userId=" + userId + ", symbol=" + symbol + '}';
    }

    public String getCandidateiId() {
        return candidateiId;
    }

    public void setCandidateiId(String candidateiId) {
        this.candidateiId = candidateiId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public InputStream getSymbol() {
        return symbol;
    }

    public void setSymbol(InputStream symbol) {
        this.symbol = symbol;
    }
    private String candidateiId;
    private String party;
    private String city;
    private String userId;
    private InputStream symbol;
}
