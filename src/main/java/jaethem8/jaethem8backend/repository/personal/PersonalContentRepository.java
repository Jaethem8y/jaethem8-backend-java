package jaethem8.jaethem8backend.repository.personal;

import jaethem8.jaethem8backend.model.personal.PersonalContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalContentRepository extends JpaRepository<PersonalContent, Long> {
    public List<PersonalContent> findByPostName(String postName);

    public void deleteByPostName(String postName);

}
