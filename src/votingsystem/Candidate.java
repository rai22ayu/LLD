package votingsystem;

public class Candidate {
    private Integer candidateId;
    private String name;

    public Candidate(Integer candidateId, String name) {
        this.candidateId = candidateId;
        this.name = name;
    }

    public Integer getCandidateId() {
        return candidateId;
    }

    public String getName() {
        return name;
    }
}
