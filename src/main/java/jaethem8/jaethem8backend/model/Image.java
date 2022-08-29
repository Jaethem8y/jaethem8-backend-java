package jaethem8.jaethem8backend.model;

import javax.persistence.*;
import java.util.Objects;

@MappedSuperclass
public abstract class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Lob
    @Column(name = "image", length = 16777215, columnDefinition = "mediumtext")
    private String image;

    public Image() {
    }

    public Image(long id, String image) {
        this.id = id;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Image)) return false;
        Image image1 = (Image) o;
        return id == image1.id && Objects.equals(image, image1.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, image);
    }
}
