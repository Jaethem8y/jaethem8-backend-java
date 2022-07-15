package jaethem8.jaethem8backend.repository.blog;

import jaethem8.jaethem8backend.model.blog.BlogContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogContentRepository extends JpaRepository<BlogContent, Long> {
    public List<BlogContent> findContentByPostName(String postName);

    public void deleteByPostName(String postName);
}
