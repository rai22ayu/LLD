package votingsystem;

public class WinnerResult {
    private final Election election;
    private final Candidate candidate;
    private final Integer votes;

    public WinnerResult(Election election, Candidate candidate, Integer votes) {
        this.election = election;
        this.candidate = candidate;
        this.votes = votes;
    }

    public Election getElection() {
        return election;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public Integer getVotes() {
        return votes;
    }
}
