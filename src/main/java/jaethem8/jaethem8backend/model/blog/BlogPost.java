package jaethem8.jaethem8backend.model.blog;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jaethem8.jaethem8backend.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "blog_post")
public class BlogPost extends Post {
    @Column(name = "role")
    private String role;
    @Column(name = "frontend")
    private String frontend;
    @Column(name = "backend")
    private String backend;
    @Column(name = "general")
    private String general;
    @JsonManagedReference
    @OneToMany(mappedBy = "blogPost", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BlogContent> blogContents = new ArrayList<>();

}
