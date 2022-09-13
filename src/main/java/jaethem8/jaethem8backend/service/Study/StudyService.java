package jaethem8.jaethem8backend.service.Study;

import jaethem8.jaethem8backend.dto.PostDTO;
import jaethem8.jaethem8backend.model.study.StudyPost;

import java.util.List;

public interface StudyService {
    public List<PostDTO> getAllStudyPost();
    public PostDTO getStudyPostByTitle(String title) throws Exception;
    public PostDTO saveStudyPost(PostDTO postDTO);
    public PostDTO updateStudyPost(PostDTO postDTO) throws Exception;
    public StudyPost mapStudyPost(PostDTO postDTO, StudyPost studyPost);
    public PostDTO studyPostToDTO(StudyPost studyPost);
    public void removeStudyPost(PostDTO postDTO) throws Exception;


}
