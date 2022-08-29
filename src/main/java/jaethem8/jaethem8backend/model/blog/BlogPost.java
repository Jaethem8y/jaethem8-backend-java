package jaethem8.jaethem8backend.model.blog;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jaethem8.jaethem8backend.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
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
    @OneToMany(mappedBy = "blogPost", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BlogContent> blogContents = new ArrayList<>();

    public BlogPost() {
    }

    public BlogPost(long id, String title, Timestamp date, String description, String role, String frontend, String backend, String general, List<BlogContent> blogContents) {
        super(id, title, date, description);
        this.role = role;
        this.frontend = frontend;
        this.backend = backend;
        this.general = general;
        this.blogContents = blogContents;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFrontend() {
        return frontend;
    }

    public void setFrontend(String frontend) {
        this.frontend = frontend;
    }

    public String getBackend() {
        return backend;
    }

    public void setBackend(String backend) {
        this.backend = backend;
    }

    public String getGeneral() {
        return general;
    }

    public void setGeneral(String general) {
        this.general = general;
    }

    public List<BlogContent> getBlogContents() {
        return blogContents;
    }

    public void setBlogContents(List<BlogContent> blogContents) {
        this.blogContents = blogContents;
    }

}
