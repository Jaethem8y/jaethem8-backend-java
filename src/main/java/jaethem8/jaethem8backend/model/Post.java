package jaethem8.jaethem8backend.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@MappedSuperclass
public abstract class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "title", unique = true)
    private String title;
    @Column(name = "pub_date")
    private Timestamp date;
    @Lob
    @Column(name = "description", columnDefinition = "BLOB")
    private String description;
}
