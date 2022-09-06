package jaethem8.jaethem8backend.service.blog;

import jaethem8.jaethem8backend.dto.blog.BlogPostDTO;
import jaethem8.jaethem8backend.model.blog.BlogPost;

import java.util.List;

public interface BlogService {
    public List<BlogPostDTO> getAllBlogPost();
    public BlogPostDTO getBlogPostByTitle(String title) throws Exception;
    public BlogPostDTO saveBlogPost(BlogPostDTO blogPostDTO);
    public BlogPostDTO updateBlogPost(BlogPostDTO blogPostDTO) throws Exception;
    public BlogPost mapBlogPost(BlogPostDTO blogPostDTO, BlogPost blogPost);
    public BlogPostDTO blogPostToDTO(BlogPost blogPost);
    public void removeBlogPost(BlogPostDTO blogPostDTO) throws Exception;

}
