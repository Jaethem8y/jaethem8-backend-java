package jaethem8.jaethem8backend.repository.Study;

import jaethem8.jaethem8backend.model.study.StudyPost;

import java.util.List;

public interface StudyRepository {
    public List<StudyPost> getAllStudyPost();
    public StudyPost getStudyPostByTitle(String title) throws Exception;
    public StudyPost saveStudyPost(StudyPost studyPost);
    public void removeStudyPost(StudyPost studyPost);
}
