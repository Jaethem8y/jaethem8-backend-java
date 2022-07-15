package jaethem8.jaethem8backend.model.blog;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jaethem8.jaethem8backend.model.Content;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "blog_content")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogContent extends Content {
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonBackReference
    @JoinColumn(name = "blog_post_id")
    private BlogPost blogPost;
}
