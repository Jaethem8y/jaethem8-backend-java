package jaethem8.jaethem8backend.model;


import javax.persistence.*;
import java.util.Objects;

@MappedSuperclass
public abstract class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "tag")
    private String tag;
    @Column(name = "link")
    private String link;

    public Link() {
    }

    public Link(long id, String tag, String link) {
        this.id = id;
        this.tag = tag;
        this.link = link;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Link)) return false;
        Link link1 = (Link) o;
        return id == link1.id && Objects.equals(tag, link1.tag) && Objects.equals(link, link1.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tag, link);
    }
}
