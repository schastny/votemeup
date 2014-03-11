package up.voteme.domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TAG")
public class Tag {
    private int id;
    private String title;
    private Set<Proposal> proposals = new HashSet<>();

    public Tag() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    @ManyToMany(mappedBy = "tags")
    public Set<Proposal> getProposals() {
        return proposals;
    }

    public void setProposals(Set<Proposal> proposals) {
        this.proposals = proposals;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
