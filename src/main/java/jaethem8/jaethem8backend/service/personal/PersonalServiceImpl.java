package jaethem8.jaethem8backend.service.personal;

import jaethem8.jaethem8backend.dto.ContentDTO;
import jaethem8.jaethem8backend.dto.PostDTO;
import jaethem8.jaethem8backend.model.personal.PersonalContent;
import jaethem8.jaethem8backend.model.personal.PersonalPost;
import jaethem8.jaethem8backend.repository.personal.PersonalContentRepository;
import jaethem8.jaethem8backend.repository.personal.PersonalPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonalServiceImpl implements PersonalService {

    private final PersonalPostRepository personalPostRepository;
    private final PersonalContentRepository personalContentRepository;


    @Override
    @Transactional
    public List<PersonalPost> getAllPersonalPost() {
        return personalPostRepository.findAll();
    }

    @Override
    @Transactional
    public List<PersonalContent> getPersonalContentByPostName(String postName) {
        return personalContentRepository.findByPostName(postName);
    }

    @Override
    @Transactional
    public PersonalPost getPersonalPostByTitle(String title) {
        return personalPostRepository.findByTitle(title);
    }

    @Override
    @Transactional
    public PersonalContent getPersonalContentById(long id) {
        return personalContentRepository.findById(id).get();
    }

    @Override
    @Transactional
    public PersonalPost addPersonalPost(PostDTO personalPostDTO) {
        PersonalPost personalPost = new PersonalPost();
        personalPost.setDate(new Timestamp(System.currentTimeMillis()));
        personalPost.setTitle(personalPostDTO.getTitle());
        for (ContentDTO contentDTO : personalPostDTO.getContents()) {
            PersonalContent personalContent = addPersonalContent(contentDTO);
            personalContent.setPostName(personalPost.getTitle());
            personalContent.setPersonalPost(personalPost);
            personalPost.getPersonalContents().add(personalContent);
        }
        return personalPostRepository.save(personalPost);
    }

    @Override
    @Transactional
    public PersonalContent addPersonalContent(ContentDTO personalContentDTO) {
        PersonalContent personalContent = new PersonalContent();
        PersonalPost personalPost = personalPostRepository.findByTitle(personalContentDTO.getTitle());
        personalContent.setPostName(personalContentDTO.getTitle());
        personalContent.setImage(personalContentDTO.getImage());
        personalContent.setContent(personalContentDTO.getContent());
        personalContent.setLocation(personalContent.getLocation());
        personalContent.setCode(personalContentDTO.getCode());
        personalContent.setPersonalPost(personalPost);
        return personalContentRepository.save(personalContent);
    }

    @Override
    @Transactional
    public PersonalPost editPersonalPost(PostDTO personalPostDTO) {
        PersonalPost personalPost = personalPostRepository.findByTitle(personalPostDTO.getTitle());
        personalContentRepository.deleteByPostName(personalPostDTO.getTitle());
        List<PersonalContent> personalContents = new ArrayList<>();
        for (ContentDTO contentDTO : personalPostDTO.getContents()) {
            PersonalContent personalContent = addPersonalContent(contentDTO);
            personalContent.setPostName(personalPost.getTitle());
            personalContent.setPersonalPost(personalPost);
            personalContents.add(personalContent);
        }
        personalPost.setPersonalContents(personalContents);
        return personalPostRepository.save(personalPost);
    }

    @Override
    @Transactional
    public void deletePersonalPost(PostDTO postDTO) {
        personalPostRepository.deleteByTitle(postDTO.getTitle());
    }
}
