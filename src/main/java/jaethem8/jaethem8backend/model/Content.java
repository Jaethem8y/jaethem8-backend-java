package jaethem8.jaethem8backend.model;

import lombok.Data;

import javax.persistence.*;

@Data
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
}
