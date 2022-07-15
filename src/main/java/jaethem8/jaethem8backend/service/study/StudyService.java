package jaethem8.jaethem8backend.service.study;

import jaethem8.jaethem8backend.dto.ContentDTO;
import jaethem8.jaethem8backend.dto.PostDTO;
import jaethem8.jaethem8backend.model.Content;
import jaethem8.jaethem8backend.model.study.StudyContent;
import jaethem8.jaethem8backend.model.study.StudyPost;

import java.util.List;

public interface StudyService {
    public List<StudyPost> getAllStudyPost();

    public List<StudyContent> getStudyContentByPostName(String postName);

    public StudyPost getStudyPostByTitle(String title);

    public StudyContent getStudyContentById(long id);

    public StudyPost addStudyPost(PostDTO studyPostDTO);

    public StudyContent addStudyContent(ContentDTO StudyContentDTO);

    public StudyPost editStudyPost(PostDTO studyPostDTO);

    public void deleteStudyPost(PostDTO postDTO);
}
