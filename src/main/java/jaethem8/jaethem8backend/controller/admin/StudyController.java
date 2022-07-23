package jaethem8.jaethem8backend.controller.admin;

import jaethem8.jaethem8backend.dto.PostDTO;
import jaethem8.jaethem8backend.model.study.StudyPost;
import jaethem8.jaethem8backend.service.study.StudyService;
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
public class StudyController {
    private final StudyService studyService;
    @CrossOrigin

    @PostMapping("/add/studyPost")
    public ResponseEntity<StudyPost> addStudyPost(@RequestBody PostDTO postDTO) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/add/studyPost").toUriString());
        return ResponseEntity.created(uri).body(studyService.addStudyPost(postDTO));
    }
    @CrossOrigin

    @PostMapping("/edit/studyPost")
    public StudyPost editStudyPost(@RequestBody PostDTO postDTO) {
        return studyService.editStudyPost(postDTO);
    }
    @CrossOrigin

    @PostMapping("/delete/studyPost")
    public void deleteStudyPost(@RequestBody PostDTO postDTO) {
        studyService.deleteStudyPost(postDTO);
    }
}
