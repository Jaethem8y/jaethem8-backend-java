package jaethem8.jaethem8backend.model.blog;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jaethem8.jaethem8backend.model.Content;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    @JsonManagedReference
    @OneToMany(mappedBy = "blogContent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BlogImage> blogImages = new ArrayList<>();
    @JsonManagedReference
    @OneToMany(mappedBy = "blogContent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BlogLink> blogLinks = new ArrayList<>();
}
