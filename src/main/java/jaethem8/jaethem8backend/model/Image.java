package jaethem8.jaethem8backend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "image")
    private String image;
}
