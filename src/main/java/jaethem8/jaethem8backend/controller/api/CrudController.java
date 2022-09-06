package jaethem8.jaethem8backend.controller.api;

import jaethem8.jaethem8backend.dto.PostDTO;
import jaethem8.jaethem8backend.dto.blog.BlogPostDTO;
import jaethem8.jaethem8backend.model.blog.BlogPost;
import jaethem8.jaethem8backend.model.study.StudyPost;
import jaethem8.jaethem8backend.service.Study.StudyService;
import jaethem8.jaethem8backend.service.blog.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/API")
public class CrudController {
    private final BlogService blogService;
    private final StudyService studyService;

    @GetMapping("/blogPost")
    public List<BlogPostDTO> getBlogPosts() {
        return blogService.getAllBlogPost();
    }

    @GetMapping("/blogPost/{title}")
    public BlogPostDTO getBlogPostByTitle(@PathVariable String title) throws Exception {
        return blogService.getBlogPostByTitle(title);
    }

    @GetMapping("/studyPost")
    public List<PostDTO> getStudyPosts() {
        return studyService.getAllStudyPost();
    }

    @GetMapping("/studyPost/{title}")
    public PostDTO getStudyPostByTitle(@PathVariable String title) throws Exception {
        return studyService.getStudyPostByTitle(title);
    }

    @PostMapping("/blogPost/add")
    public BlogPostDTO saveBlogPost(@RequestBody BlogPostDTO blogPostDTO) {
        return blogService.saveBlogPost(blogPostDTO);
    }
}
