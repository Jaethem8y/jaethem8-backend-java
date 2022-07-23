package jaethem8.jaethem8backend.controller.admin;

import jaethem8.jaethem8backend.dto.blog.BlogPostDTO;
import jaethem8.jaethem8backend.model.blog.BlogPost;
import jaethem8.jaethem8backend.service.blog.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @CrossOrigin
    @PostMapping("/add/blogPost")
    public ResponseEntity<BlogPost> addBlogPost(@RequestBody BlogPostDTO blogPostDTO) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/add/blogPost").toUriString());
        return ResponseEntity.created(uri).body(blogService.addBlogPost(blogPostDTO));
    }
    @CrossOrigin

    @PostMapping("/edit/blogPost")
    public BlogPost editBlogPost(@RequestBody BlogPostDTO blogPostDTO) {
        return blogService.editBlogPost(blogPostDTO);
    }
    @CrossOrigin

    @PostMapping("/delete/blogPost")
    public void deleteBlogPost(@RequestBody BlogPostDTO blogPostDTO) {
        blogService.deleteBlogPost(blogPostDTO);
    }
}
