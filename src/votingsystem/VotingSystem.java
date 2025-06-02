package votingsystem;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class VotingSystem {

    private final ElectionManager electionManager;

    public VotingSystem(ElectionManager electionManager) {
        this.electionManager = electionManager;
    }

    public void castVote(Integer electionId, Integer voterId, Integer candidateId) {
        Optional<Election> election = electionManager.getElections().stream().filter(e ->
                        e.getElectionId().equals(electionId) && e.isActive())
                .findFirst();
        if(election.isPresent()){
            Voter voter = election.get().getRegisteredVoters().stream()
                    .filter(v -> v.getVoterId().equals(voterId))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Voter not found"));
            Candidate candidate = election.get().getRegisteredCandidates().stream().filter(c ->
                        c.getCandidateId().equals(candidateId))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Candidate not found"));

            election.get().vote(voter, candidate);
        }
        else {
            throw new IllegalArgumentException("Election not found or not active");
        }
    }

    public List<WinnerResult> getWinners() {
        List<Election> elections = electionManager.getElections();
        return elections.stream().map(e -> {
            Map.Entry<Candidate, Integer> winner = e.getWinnerVotes();
            return new WinnerResult(e, winner.getKey(), winner.getValue());
        }).toList();
    }

    public Map.Entry<Candidate, Integer> getWinnerForElection(Integer electionId) {
        Optional<Election> election = electionManager.getElections().stream()
                .filter(e -> e.getElectionId().equals(electionId) && e.isActive())
                .findFirst();
        if (election.isPresent()) {
            return election.get().getWinnerVotes();
        } else {
            throw new IllegalArgumentException("Election not found or not active");
        }
    }
}
