package votingsystem;

import java.util.List;

public class ElectionVotingSystemMain {

    public static void Main(String... args){

        ElectionManager electionManager = new ElectionManager();
        VotingSystem voterManager = new VotingSystem(electionManager);
        for(int i = 0; i < 5; i++){
            electionManager.registerElection(new Election((i + 1), "ElectionName " + i+1, "Description for Election " + (i + 1)));
        }
        electionManager.registerVoter(1, new Voter(1, "Voter1"));
        electionManager.registerVoter(2, new Voter(2, "Voter2"));
        electionManager.registerVoter(3, new Voter(3, "Voter3"));
        electionManager.registerCandidate(1, new Candidate(1, "Candidate1"));
        electionManager.registerCandidate(2, new Candidate(2, "Candidate2"));
        electionManager.registerCandidate(3, new Candidate(3, "Candidate3"));
        electionManager.registerCandidate(3, new Candidate(4, "Candidate4"));

        voterManager.castVote(1, 1, 1);

        voterManager.getWinnerForElection(1);
        List<WinnerResult> winnerResultList = voterManager.getWinners();

        winnerResultList.forEach(w -> {;
            System.out.println("Election ID: " + w.getElection().getElectionId() +
                               ", Winner Candidate ID: " + w.getCandidate().getCandidateId() +
                               ", Votes Received: " + w.getVotes());
        });


    }
}
