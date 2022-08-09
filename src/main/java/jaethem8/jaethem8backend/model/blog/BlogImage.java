package jaethem8.jaethem8backend.model.blog;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jaethem8.jaethem8backend.model.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "blog_image")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogImage extends Image {
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonBackReference
    @JoinColumn(name = "blog_content_id")
    private BlogContent blogContent;
}
