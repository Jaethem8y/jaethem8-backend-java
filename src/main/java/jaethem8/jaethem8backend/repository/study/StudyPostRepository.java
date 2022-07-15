package jaethem8.jaethem8backend.repository.study;

import jaethem8.jaethem8backend.model.study.StudyPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyPostRepository extends JpaRepository<StudyPost, Long> {
    public StudyPost findByTitle(String title);
    public void deleteByTitle(String title);
}
