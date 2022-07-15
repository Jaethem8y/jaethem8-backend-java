package jaethem8.jaethem8backend.repository.blog;

import jaethem8.jaethem8backend.model.blog.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
    public BlogPost findByTitle(String title);

    public void deleteByTitle(String title);
}
