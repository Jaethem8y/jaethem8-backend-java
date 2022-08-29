package jaethem8.jaethem8backend.model;

import javax.persistence.*;
import java.util.Objects;

@MappedSuperclass
public abstract class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "location")
    private int location;
    @Column(name = "header")
    private String header;
    @Lob
    @Column(name = "content", columnDefinition = "BLOB")
    private String content;
    @Lob
    @Column(name = "code", columnDefinition = "BLOB")
    private String code;

    public Content() {
    }

    public Content(long id, int location, String header, String content, String code) {
        this.id = id;
        this.location = location;
        this.header = header;
        this.content = content;
        this.code = code;
    }

    public long getId() {
        return id;
    }

    public int getLocation() {
        return location;
    }

    public String getHeader() {
        return header;
    }

    public String getContent() {
        return content;
    }

    public String getCode() {
        return code;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Content)) return false;
        Content content1 = (Content) o;
        return id == content1.id && location == content1.location && Objects.equals(header, content1.header) && Objects.equals(content, content1.content) && Objects.equals(code, content1.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, location, header, content, code);
    }
}
