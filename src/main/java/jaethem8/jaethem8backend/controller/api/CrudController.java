package jaethem8.jaethem8backend.controller.api;

import jaethem8.jaethem8backend.model.blog.BlogPost;
import jaethem8.jaethem8backend.model.personal.PersonalPost;
import jaethem8.jaethem8backend.model.study.StudyPost;
import jaethem8.jaethem8backend.service.blog.BlogService;
import jaethem8.jaethem8backend.service.personal.PersonalService;
import jaethem8.jaethem8backend.service.study.StudyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/API")
public class CrudController {
    private final BlogService blogService;
    private final PersonalService personalService;
    private final StudyService studyService;

    public CrudController(BlogService blogService, PersonalService personalService, StudyService studyService){
        this.blogService = blogService;
        this.personalService = personalService;
        this.studyService = studyService;
    }

    @GetMapping("/blogPost")
    public List<BlogPost> getBlogPosts(){
        return blogService.getAllBlogPost();
    }

    @GetMapping("/blogPost/{title}")
    public BlogPost getBlogPostByTitle(@PathVariable String title){
        return blogService.getBlogPostByTitle(title);
    }

    @GetMapping("/personalPost")
    public List<PersonalPost> getPersonalPosts(){
        return personalService.getAllPersonalPost();
    }

    @GetMapping("/personalPost/{title}")
    public PersonalPost getPersonalPostByTitle(@PathVariable String title){
        return personalService.getPersonalPostByTitle(title);
    }

    @GetMapping("/studyPost")
    public List<StudyPost> getStudyPosts(){
        return studyService.getAllStudyPost();
    }

    @GetMapping("/studyPost/{title}")
    public StudyPost getStudyPostByTitle(@PathVariable String title){
        return studyService.getStudyPostByTitle(title);
    }

}
