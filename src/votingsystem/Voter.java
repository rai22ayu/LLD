package votingsystem;

public class Voter {
    private Integer voterId;
    private String name;

    public Voter(Integer voterId, String name) {
        this.voterId = voterId;
        this.name = name;
    }

    public Integer getVoterId() {
        return voterId;
    }

    public String getName() {
        return name;
    }
}
