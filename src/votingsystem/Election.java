package votingsystem;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Election {
    private final Integer electionId;
    private final String electionName;
    private final String electionDescription;
    private final List<Candidate> registeredCandidates;
    private final List<Voter> registeredVoters;
    private Map<Candidate, AtomicInteger> votes;
    private boolean isActive = false;

    public Election(Integer electionId, String electionName, String electionDescription) {
        this.electionId = electionId;
        this.electionName = electionName;
        this.electionDescription = electionDescription;
        registeredCandidates = new ArrayList<>();
        registeredVoters = new ArrayList<>();
    }

    public Integer getElectionId() {
        return electionId;
    }

    public String getElectionName() {
        return electionName;
    }

    public String getElectionDescription() {
        return electionDescription;
    }
    public List<Candidate> getRegisteredCandidates() {
        return registeredCandidates;
    }

    public List<Voter> getRegisteredVoters() {
        return registeredVoters;
    }

    public void startElection() {
        if (!isActive) {
            isActive = true;
        } else {
            throw new IllegalStateException("Election is already active.");
        }
    }
    public void endElection() {
        if (isActive) {
            isActive = false;
        } else {
            throw new IllegalStateException("Election is not active.");
        }
    }
    public boolean isActive() {
        return isActive;
    }

    public void vote(Voter voter, Candidate candidate){
        if (!isActive) {
            throw new IllegalStateException("Election is not active.");
        }
        if (!registeredVoters.contains(voter)) {
            throw new IllegalArgumentException("Voter is not registered for this election.");
        }
        if (!registeredCandidates.contains(candidate)) {
            throw new IllegalArgumentException("Candidate is not registered for this election.");
        }
        if (votes.containsKey(candidate)) {
            votes.get(candidate).incrementAndGet();
        } else {
            votes.put(candidate, new AtomicInteger(1));
        }
    }

    public Map.Entry<Candidate, Integer> getWinnerVotes() {
        if (isActive) {
            throw new IllegalStateException("Election is not over.");
        }
        AtomicReference<AtomicInteger> maxVotes = new AtomicReference<>(new AtomicInteger(0));
        AtomicReference<Candidate> winner = new AtomicReference<>(null);

        votes.forEach((key, value) -> {
            if (value.get() > maxVotes.get().get()) {
                maxVotes.set(value);
                winner.set(key);
            }
        });

        return Map.entry(winner.get(), maxVotes.get().get());
    }

}
