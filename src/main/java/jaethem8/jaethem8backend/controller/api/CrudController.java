package jaethem8.jaethem8backend.controller.api;

import jaethem8.jaethem8backend.dto.blog.BlogPostDTO;
import jaethem8.jaethem8backend.model.blog.BlogPost;
import jaethem8.jaethem8backend.service.blog.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/API")
public class CrudController {
    private final BlogService blogService;

    @GetMapping("/blogPost")
    public List<BlogPostDTO> getBlogPosts() {
        return blogService.getAllBlogPost();
    }
    @GetMapping("/blogPost/{title}")
    public BlogPost getBlogPostByTitle(@PathVariable String title) throws Exception {
        return blogService.getBlogPostByTitle(title);
    }
    @PostMapping("/blogPost/add")
    public BlogPost saveBlogPost(@RequestBody BlogPostDTO blogPostDTO){
        return blogService.saveBlogPost(blogPostDTO);
    }
}
