
package evoting.dto;


public class voteDto {
    private String candidateId;
    private String voterId;

    @Override
    public String toString() {
        return "voteDto{" + "candidateId=" + candidateId + ", voterId=" + voterId + '}';
    }

   

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public voteDto(String candidateId, String voterId) {
        this.candidateId = candidateId;
        this.voterId = voterId;
    }
    
            
}
