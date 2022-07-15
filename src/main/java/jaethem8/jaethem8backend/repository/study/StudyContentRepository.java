package jaethem8.jaethem8backend.repository.study;

import jaethem8.jaethem8backend.model.study.StudyContent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyContentRepository extends JpaRepository<StudyContent, Long> {
    public List<StudyContent> findByPostName(String postName);
    public void deleteByPostName(String postName);
}
