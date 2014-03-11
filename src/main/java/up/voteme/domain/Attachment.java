package up.voteme.domain;

import javax.persistence.*;

@Entity  // flags the class as persistent (makes it an entity bean)
@Table(name = "ATTACHMENT")
public class Attachment {

    private int id;

    private String url;
    private String path;

    public Attachment() {
    }

    @Id
    @Column(name = "attachment_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "path")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    @Override
    public String toString() {
        return "Attachment{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
