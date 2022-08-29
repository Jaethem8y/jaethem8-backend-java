package jaethem8.jaethem8backend.controller.admin;

import jaethem8.jaethem8backend.dto.blog.BlogPostDTO;
import jaethem8.jaethem8backend.model.blog.BlogPost;
import jaethem8.jaethem8backend.service.blog.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @CrossOrigin
    @PostMapping("/add/blogPost")
    public BlogPost saveBlogPost(@RequestBody BlogPostDTO blogPostDTO) {
        return blogService.saveBlogPost(blogPostDTO);
    }

    @CrossOrigin
    @PostMapping("/edit/blogPost")
    public BlogPost updateBlogPost(@RequestBody BlogPostDTO blogPostDTO) throws Exception {
        return blogService.updateBlogPost(blogPostDTO);
    }

    @CrossOrigin
    @PostMapping("/delete/blogPost")
    public boolean deleteBlogPost(@RequestBody BlogPostDTO blogPostDTO) throws Exception {
        try {
            blogService.removeBlogPost(blogPostDTO);
            return true;
        } catch (Exception e) {
            throw e;
        }
    }
}
