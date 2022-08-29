package jaethem8.jaethem8backend.repository.blog;

import jaethem8.jaethem8backend.model.blog.BlogPost;

import java.util.List;

public interface BlogRepository {
    public List<BlogPost> getAllBlogPost();
    public BlogPost getBlogPostByTitle(String title) throws Exception;
    public BlogPost saveBlogPost(BlogPost blogPost);
    public void removeBlogPost(BlogPost blogPost);
}
