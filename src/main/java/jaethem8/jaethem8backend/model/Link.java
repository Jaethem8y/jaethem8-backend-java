package jaethem8.jaethem8backend.model;

import lombok.Data;

import javax.persistence.*;

@Data
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
}
