package votingsystem;

import java.util.ArrayList;
import java.util.List;

public class ElectionManager {
    private final List<Election> elections;

    public ElectionManager() {
        this.elections = new ArrayList<>();
    }

    public void registerElection(Election election) {
        elections.add(election);
    }

    public void unregisterElection(Integer electionId) {
        elections.stream().filter(e -> e.getElectionId().equals(electionId)).findFirst()
                .ifPresent(elections::remove);
    }

    public void startElection(Integer electionId) {
        elections.stream().filter(e -> e.getElectionId().equals(electionId)).findFirst()
                .ifPresent(Election::startElection);
    }

    public void endElection(Integer electionId) {
        elections.stream().filter(e -> e.getElectionId().equals(electionId)).findFirst()
                .ifPresent(Election::endElection);
    }

    public void registerCandidate(Integer electionId, Candidate candidate) {
        elections.stream().filter(e -> e.getElectionId().equals(electionId)).findFirst()
                .ifPresent(election -> election.getRegisteredCandidates().add(candidate));
    }

    public void unregisterCandidate(Integer electionId, Candidate candidate) {
        elections.stream().filter(e -> e.getElectionId().equals(electionId)).findFirst()
                .ifPresent(election -> election.getRegisteredCandidates().remove(candidate));
    }

    public void registerVoter(Integer electionId, Voter voter) {
        elections.stream().filter(e -> e.getElectionId().equals(electionId)).findFirst()
                .ifPresent(election -> election.getRegisteredVoters().add(voter));
    }

    public void unregisterVoter(Integer electionId, Voter voter) {
        elections.stream().filter(e -> e.getElectionId().equals(electionId)).findFirst()
                .ifPresent(election -> election.getRegisteredVoters().remove(voter));
    }

    public List<Election> getElections() {
        return elections;
    }

}
