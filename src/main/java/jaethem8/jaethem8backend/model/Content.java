package jaethem8.jaethem8backend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "post_name")
    private String postName;
    @Column(name = "location")
    private int location;
    @Column(name="header")
    private String header;
    @Column(name = "content", length = 16777215, columnDefinition = "mediumtext")
    private String content;
    @Lob
    @Column(name = "image", length = 16777215, columnDefinition = "mediumtext")
    private String image;
    @Column(name = "code", length = 16777215, columnDefinition = "mediumtext")
    private String code;
}
