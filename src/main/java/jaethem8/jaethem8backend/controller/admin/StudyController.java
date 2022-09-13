package jaethem8.jaethem8backend.controller.admin;

import jaethem8.jaethem8backend.dto.PostDTO;
import jaethem8.jaethem8backend.model.Post;
import jaethem8.jaethem8backend.model.study.StudyPost;
import jaethem8.jaethem8backend.service.Study.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StudyController {
    private final StudyService studyService;

    @CrossOrigin
    @PostMapping("/add/studyPost")
    public PostDTO saveStudyPost(@RequestBody PostDTO postDTO) {
        return studyService.saveStudyPost(postDTO);
    }

    @CrossOrigin
    @PostMapping("/edit/studyPost")
    public PostDTO updateStudyPost(@RequestBody PostDTO postDTO) throws Exception {
        return studyService.updateStudyPost(postDTO);
    }

    @CrossOrigin
    @PostMapping("/delete/studyPost")
    public boolean deleteStudyPost(@RequestBody PostDTO postDTO) throws Exception {
        try {
            studyService.removeStudyPost(postDTO);
            return true;
        } catch (Exception e) {
            throw e;
        }
    }
}
