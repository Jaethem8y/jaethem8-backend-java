package jaethem8.jaethem8backend.service.blog;

import jaethem8.jaethem8backend.dto.blog.BlogPostDTO;
import jaethem8.jaethem8backend.model.blog.BlogPost;

import java.util.List;

public interface BlogService {
    public List<BlogPostDTO> getAllBlogPost();
    public BlogPost getBlogPostByTitle(String title) throws Exception;
    public BlogPost saveBlogPost(BlogPostDTO blogPostDTO);
}
