package jaethem8.jaethem8backend.model.blog;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jaethem8.jaethem8backend.model.Image;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "blog_image")
public class BlogImage extends Image {
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonBackReference
    @JoinColumn(name = "blog_content_id")
    private BlogContent blogContent;

    public BlogImage() {
    }

    public BlogImage(long id, String image, BlogContent blogContent) {
        super(id, image);
        this.blogContent = blogContent;
    }

    public BlogContent getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(BlogContent blogContent) {
        this.blogContent = blogContent;
    }

}
