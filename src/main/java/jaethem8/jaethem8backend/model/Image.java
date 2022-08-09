package jaethem8.jaethem8backend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Lob
    @Column(name = "image", length = 16777215, columnDefinition = "mediumtext")
    private String image;
}
