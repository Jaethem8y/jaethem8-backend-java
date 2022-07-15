package jaethem8.jaethem8backend.repository.personal;

import jaethem8.jaethem8backend.model.personal.PersonalPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalPostRepository extends JpaRepository<PersonalPost, Long> {
    public PersonalPost findByTitle(String title);
    public void deleteByTitle(String title);
}
