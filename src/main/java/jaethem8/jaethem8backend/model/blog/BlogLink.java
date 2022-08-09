package jaethem8.jaethem8backend.model.blog;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jaethem8.jaethem8backend.model.Link;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "blog_link")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogLink extends Link {
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonBackReference
    @JoinColumn(name = "blog_content_id")
    private BlogContent blogContent;
}
