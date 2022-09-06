package jaethem8.jaethem8backend.service.Study;

import jaethem8.jaethem8backend.dto.PostDTO;
import jaethem8.jaethem8backend.model.study.StudyPost;

import java.util.List;

public interface StudyService {
    public List<PostDTO> getAllStudyPost();

    public StudyPost getStudyPostByTitle(String title) throws Exception;

    public StudyPost saveStudyPost(PostDTO postDTO);

    public StudyPost updateStudyPost(PostDTO postDTO) throws Exception;

    public StudyPost mapStudyPost(PostDTO postDTO, StudyPost studyPost);

    public void removeStudyPost(PostDTO postDTO) throws Exception;


}
