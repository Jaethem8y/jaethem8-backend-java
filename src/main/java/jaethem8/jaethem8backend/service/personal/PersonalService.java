package jaethem8.jaethem8backend.service.personal;

import jaethem8.jaethem8backend.dto.ContentDTO;
import jaethem8.jaethem8backend.dto.PostDTO;
import jaethem8.jaethem8backend.model.personal.PersonalContent;
import jaethem8.jaethem8backend.model.personal.PersonalPost;

import java.util.List;

public interface PersonalService {
    public List<PersonalPost> getAllPersonalPost();

    public List<PersonalContent> getPersonalContentByPostName(String postName);

    public PersonalPost getPersonalPostByTitle(String title);

    public PersonalContent getPersonalContentById(long id);

    public PersonalPost addPersonalPost(PostDTO personalPostDTO);
    public PersonalContent addPersonalContent(ContentDTO personalContentDTO);
    public PersonalPost editPersonalPost(PostDTO personalPostDTO);
    public void deletePersonalPost(PostDTO postDTO);
}
