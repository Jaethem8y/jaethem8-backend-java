package jaethem8.jaethem8backend.service.blog;

import jaethem8.jaethem8backend.dto.ContentDTO;
import jaethem8.jaethem8backend.dto.blog.BlogPostDTO;
import jaethem8.jaethem8backend.model.blog.BlogContent;
import jaethem8.jaethem8backend.model.blog.BlogPost;

import java.util.List;

public interface BlogService {
    public List<BlogPost> getAllBlogPost();

    public List<BlogContent> getBlogContentByPostName(String postName);

    public BlogPost getBlogPostByTitle(String title);

    public BlogContent getBlogContentById(long id);

    public BlogPost addBlogPost(BlogPostDTO blogPostDTO);

    public BlogContent addBlogContent(ContentDTO blogContentDTO);
    public BlogPost editBlogPost(BlogPostDTO blogPostDTO);
    public void deleteBlogPost(BlogPostDTO blogPostDTO);
}
