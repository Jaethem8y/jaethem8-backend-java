package jaethem8.jaethem8backend.service.study;

import jaethem8.jaethem8backend.dto.ContentDTO;
import jaethem8.jaethem8backend.dto.PostDTO;
import jaethem8.jaethem8backend.model.Post;
import jaethem8.jaethem8backend.model.study.StudyContent;
import jaethem8.jaethem8backend.model.study.StudyPost;
import jaethem8.jaethem8backend.repository.study.StudyContentRepository;
import jaethem8.jaethem8backend.repository.study.StudyPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudyServiceImpl implements StudyService {

    private final StudyPostRepository studyPostRepository;
    private final StudyContentRepository studyContentRepository;


    @Override
    @Transactional
    public List<StudyPost> getAllStudyPost() {
        List<StudyPost> posts = studyPostRepository.findAll();
        posts.sort(Comparator.comparing(Post::getDate).reversed());
        return posts;
    }

    @Override
    @Transactional
    public List<StudyContent> getStudyContentByPostName(String postName) {
        return studyContentRepository.findByPostName(postName);
    }

    @Override
    @Transactional
    public StudyPost getStudyPostByTitle(String title) {
        return studyPostRepository.findByTitle(title);
    }

    @Override
    @Transactional
    public StudyContent getStudyContentById(long id) {
        return studyContentRepository.findById(id).get();
    }

    @Override
    @Transactional
    public StudyPost addStudyPost(PostDTO studyPostDTO) {
        StudyPost studyPost = new StudyPost();
        studyPost.setDate(new Timestamp(System.currentTimeMillis()));
        studyPost.setTitle(studyPostDTO.getTitle());
        for (ContentDTO contentDTO : studyPostDTO.getContents()) {
            StudyContent studyContent = addStudyContent(contentDTO);
            studyContent.setPostName(studyPost.getTitle());
            studyContent.setStudyPost(studyPost);
            studyPost.getStudyContents().add(studyContent);
        }
        return studyPostRepository.save(studyPost);
    }

    @Override
    @Transactional
    public StudyContent addStudyContent(ContentDTO studyContentDTO) {
        StudyContent studyContent = new StudyContent();
        StudyPost studyPost = studyPostRepository.findByTitle(studyContentDTO.getTitle());
        studyContent.setPostName(studyContentDTO.getTitle());
        studyContent.setImage(studyContentDTO.getImage());
        studyContent.setContent(studyContentDTO.getContent());
        studyContent.setLocation(studyContent.getLocation());
        studyContent.setCode(studyContentDTO.getCode());
        studyContent.setLink(studyContent.getLink());
        studyContent.setStudyPost(studyPost);
        return studyContentRepository.save(studyContent);
    }

    @Override
    @Transactional
    public StudyPost editStudyPost(PostDTO studyPostDTO) {
        StudyPost studyPost = studyPostRepository.findByTitle(studyPostDTO.getTitle());
        studyContentRepository.deleteByPostName(studyPostDTO.getTitle());
        List<StudyContent> studyContents = new ArrayList<>();
        for (ContentDTO contentDTO : studyPostDTO.getContents()) {
            StudyContent studyContent = addStudyContent(contentDTO);
            studyContent.setPostName(studyPost.getTitle());
            studyContent.setStudyPost(studyPost);
            studyContents.add(studyContent);
        }
        studyPost.setStudyContents(studyContents);
        return studyPostRepository.save(studyPost);
    }

    @Override
    @Transactional
    public void deleteStudyPost(PostDTO postDTO) {
        studyPostRepository.deleteByTitle(postDTO.getTitle());
    }
}
