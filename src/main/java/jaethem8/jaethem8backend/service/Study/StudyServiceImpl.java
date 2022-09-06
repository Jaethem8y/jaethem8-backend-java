package jaethem8.jaethem8backend.service.Study;

import jaethem8.jaethem8backend.dto.PostDTO;
import jaethem8.jaethem8backend.model.study.StudyContent;
import jaethem8.jaethem8backend.model.study.StudyImage;
import jaethem8.jaethem8backend.model.study.StudyLink;
import jaethem8.jaethem8backend.model.study.StudyPost;
import jaethem8.jaethem8backend.repository.Study.StudyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudyServiceImpl implements StudyService {
    private final StudyRepository studyRepository;
    private static Logger logger = LoggerFactory.getLogger(StudyServiceImpl.class);

    @Override
    @Transactional
    public List<PostDTO> getAllStudyPost() {
        List<StudyPost> studyPosts = studyRepository.getAllStudyPost();
        List<PostDTO> postDTOS = new ArrayList<>();

        studyPosts.forEach(studyPost -> {
            PostDTO postDTO = new PostDTO();
            postDTO.setTitle(studyPost.getTitle());
            postDTO.setDescription(studyPost.getDescription());
            postDTOS.add(postDTO);
        });
        return postDTOS;
    }

    @Override
    @Transactional
    public StudyPost getStudyPostByTitle(String title) throws Exception {
        return studyRepository.getStudyPostByTitle(title);
    }

    @Override
    public StudyPost saveStudyPost(PostDTO postDTO) {
        StudyPost studyPost = new StudyPost();
        mapStudyPost(postDTO, studyPost);
        return studyRepository.saveStudyPost(studyPost);
    }

    @Override
    public StudyPost updateStudyPost(PostDTO postDTO) throws Exception {
        StudyPost studyPost = studyRepository.getStudyPostByTitle(postDTO.getTitle());
        mapStudyPost(postDTO, studyPost);
        return studyRepository.saveStudyPost(studyPost);
    }

    @Override
    public StudyPost mapStudyPost(PostDTO postDTO, StudyPost studyPost) {
        studyPost.setTitle(postDTO.getTitle());
        studyPost.setDate(new Timestamp(System.currentTimeMillis()));

        List<StudyContent> studyContents = new ArrayList<>();
        postDTO.getContents().forEach(contentDTO -> {
            StudyContent studyContent = new StudyContent();
            studyContent.setLocation(contentDTO.getLocation());
            studyContent.setHeader(contentDTO.getHeader());
            studyContent.setContent(contentDTO.getContent());
            studyContent.setCode(contentDTO.getCode());

            List<StudyImage> studyImages = new ArrayList<>();
            contentDTO.getImages().forEach(imageDTO -> {
                StudyImage studyImage = new StudyImage();
                studyImage.setImage(imageDTO.getImage());
                studyImage.setStudyContent(studyContent);
                studyImages.add(studyImage);
            });

            Set<StudyLink> studyLinks = new HashSet<>();
            contentDTO.getLinks().forEach(linkDTO -> {
                StudyLink studyLink = new StudyLink();
                studyLink.setTag(linkDTO.getTag());
                studyLink.setStudyContent(studyContent);
                studyLinks.add(studyLink);
            });

            studyContent.setStudyPost(studyPost);
            studyContent.setStudyImages(studyImages);
            studyContent.setStudyLinks(studyLinks);
            studyContents.add(studyContent);
        });
        studyPost.setStudyContents(studyContents);
        return studyPost;
    }

    @Override
    public void removeStudyPost(PostDTO postDTO) throws Exception {
        String title = postDTO.getTitle();
        StudyPost studyPost = studyRepository.getStudyPostByTitle(title);
        studyRepository.removeStudyPost(studyPost);
    }
}