package jaethem8.jaethem8backend.model.blog;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jaethem8.jaethem8backend.model.Content;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "blog_content")
public class BlogContent extends Content {
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonBackReference
    @JoinColumn(name = "blog_post_id")
    private BlogPost blogPost;
    @JsonManagedReference
    @OneToMany(mappedBy = "blogContent", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BlogImage> blogImages = new ArrayList<>();
    @JsonManagedReference
    @OneToMany(mappedBy = "blogContent", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<BlogLink> blogLinks = new HashSet<>();

    public BlogContent() {
    }

    public BlogContent(long id, int location, String header, String content, String code, BlogPost blogPost, List<BlogImage> blogImages, Set<BlogLink> blogLinks) {
        super(id, location, header, content, code);
        this.blogPost = blogPost;
        this.blogImages = blogImages;
        this.blogLinks = blogLinks;
    }

    public BlogPost getBlogPost() {
        return blogPost;
    }

    public void setBlogPost(BlogPost blogPost) {
        this.blogPost = blogPost;
    }

    public List<BlogImage> getBlogImages() {
        return blogImages;
    }

    public void setBlogImages(List<BlogImage> blogImages) {
        this.blogImages = blogImages;
    }

    public Set<BlogLink> getBlogLinks() {
        return blogLinks;
    }

    public void setBlogLinks(Set<BlogLink> blogLinks) {
        this.blogLinks = blogLinks;
    }

}
