package up.voteme.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PROPOSAL")
public class Proposal {

    private int id;

    private User author;
    private String title;
    private String content;

    private Date publicationDate;
    private Date dueDate;

    private Set<Attachment> attachments = new HashSet<>();
    private Set<Category> categories = new HashSet<>();
    private Set<Comment> comments = new HashSet<>();
    private Set<Tag> tags = new HashSet<>();
    private Set<Vote> votes = new HashSet<>();

    public Proposal() {
    }

    @Id
    @Column(name = "proposal_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "author")
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Column(name = "title", nullable = false, length = 32)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "content", nullable = false)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "pulication_date")
    @Temporal(value = TemporalType.DATE)
    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Column(name = "due_date")
    @Temporal(value = TemporalType.DATE)
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @OneToMany(mappedBy = "proposal", cascade = CascadeType.REMOVE) // if we want to delete proposal all it's attachments should be deleted
    public Set<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(Set<Attachment> attachments) {
        this.attachments = attachments;
    }

    @ManyToMany
    @JoinTable(name = "PROPOSAL_CATEGORY",
            joinColumns = {
                    @JoinColumn(name = "proposal_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "category_id")
            }
    )
    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @ManyToMany
    @JoinTable(name = "PROPOSAL_TAG",
            joinColumns = {
                    @JoinColumn(name = "proposal_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "tag_id")
            }
    )
    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @OneToMany(mappedBy = "proposal")
    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @OneToMany(mappedBy = "proposal", cascade = CascadeType.REMOVE)  // if we want to delete proposal all it's votes should be deleted
    public Set<Vote> getVotes() {
        return votes;
    }

    public void setVotes(Set<Vote> votes) {
        this.votes = votes;
    }
}
