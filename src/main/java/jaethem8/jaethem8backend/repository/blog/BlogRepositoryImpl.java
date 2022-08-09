package jaethem8.jaethem8backend.repository.blog;

import jaethem8.jaethem8backend.model.blog.BlogPost;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Slf4j
@Repository
public class BlogRepositoryImpl implements BlogRepository {
    private final EntityManager em;
    private final Session session;
    private static Logger logger = LoggerFactory.getLogger(BlogRepositoryImpl.class);

    public BlogRepositoryImpl(EntityManager em){
        this.em = em;
        this.session = em.unwrap(Session.class);
    }

    @Override
    public List<BlogPost> getAllBlogPost() {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<BlogPost> cq = cb.createQuery(BlogPost.class);

        Root<BlogPost> root = cq.from(BlogPost.class);

        cq.select(root);

        TypedQuery<BlogPost> query = session.createQuery(cq);
        List<BlogPost> resultList = query.getResultList();

        return resultList;
    }

    @Override
    public BlogPost getBlogPostByTitle(String title) throws Exception {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<BlogPost> cq = cb.createQuery(BlogPost.class);

        Root<BlogPost> root = cq.from(BlogPost.class);

        Predicate titleEquals = cb.equal(root.get("title"), title);

        cq.select(root)
                .where(titleEquals);

        List<BlogPost> blogPost = session.createQuery(cq).getResultList();

        if (blogPost.size() == 0) {
            throw new Exception("BlogPost with given title does not exist");
        }
        return blogPost.get(0);
    }

    @Override
    public BlogPost saveBlogPost(BlogPost blogPost) {
        try{
            session.saveOrUpdate(blogPost);
            return blogPost;
        } catch (Exception e){
            throw e;
        }

    }
}
