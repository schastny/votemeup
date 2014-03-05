package up.voteme.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LEVEL")
public class Level {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "Level")
    private String level;

    @Column(name = "MinVoteYes")
    private int minVoteYes;
    
    // не знаю как сделать ENUM для этого поля :(
    @Column(name = "MinVotePeriod")
    private String minVotePeriod;
        
    
    @OneToMany(mappedBy = "level")
    private List<Proposal> proposals;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<Proposal> getProposals() {
        return proposals;
    }

    public void setProposals(List<Proposal> proposals) {
        this.proposals = proposals;
    }

}