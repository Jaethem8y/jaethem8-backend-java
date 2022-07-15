package jaethem8.jaethem8backend.controller.admin;


import jaethem8.jaethem8backend.dto.PostDTO;
import jaethem8.jaethem8backend.model.personal.PersonalPost;
import jaethem8.jaethem8backend.service.personal.PersonalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class PersonalController {
    private final PersonalService personalService;

    @PostMapping("/add/personalPost")
    public ResponseEntity<PersonalPost> addpersonalPost(@RequestBody PostDTO postDTO) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/add/personalPost").toUriString());
        return ResponseEntity.created(uri).body(personalService.addPersonalPost(postDTO));
    }
    @PostMapping("/edit/personalPost")
    public PersonalPost editPersonalPost(@RequestBody PostDTO postDTO){
        return personalService.editPersonalPost(postDTO);
    }
    @PostMapping("/delete/personalPost")
    public void deletePersonalPost(@RequestBody PostDTO postDTO){
        personalService.deletePersonalPost(postDTO);
    }
}
