package jaethem8.jaethem8backend.service.blog;

import jaethem8.jaethem8backend.dto.ContentDTO;
import jaethem8.jaethem8backend.dto.blog.BlogPostDTO;
import jaethem8.jaethem8backend.model.Post;
import jaethem8.jaethem8backend.model.blog.BlogContent;
import jaethem8.jaethem8backend.model.blog.BlogPost;
import jaethem8.jaethem8backend.repository.blog.BlogContentRepository;
import jaethem8.jaethem8backend.repository.blog.BlogPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {
    private final BlogPostRepository blogPostRepository;
    private final BlogContentRepository blogContentRepository;


    @Override
    @Transactional
    public List<BlogPost> getAllBlogPost() {
        List<BlogPost> posts = blogPostRepository.findAll();
        posts.sort(Comparator.comparing(Post::getDate).reversed());
        return posts;
    }

    @Override
    @Transactional
    public List<BlogContent> getBlogContentByPostName(String postName) {
        return blogContentRepository.findContentByPostName(postName);
    }

    @Override
    @Transactional
    public BlogPost getBlogPostByTitle(String title) {
        return blogPostRepository.findByTitle(title);
    }

    @Override
    @Transactional
    public BlogContent getBlogContentById(long id) {
        return blogContentRepository.findById(id).get();
    }

    @Override
    @Transactional
    public BlogPost addBlogPost(BlogPostDTO blogPostDTO) {
        BlogPost blogPost = new BlogPost();
        blogPost.setDate(new Timestamp(System.currentTimeMillis()));
        blogPost.setTitle(blogPostDTO.getTitle());
        blogPost.setRole(blogPostDTO.getRole());
        blogPost.setFrontend(blogPostDTO.getFrontend());
        blogPost.setBackend(blogPostDTO.getBackend());
        blogPost.setGeneral(blogPostDTO.getGeneral());
        for (ContentDTO contentDTO : blogPostDTO.getContents()) {
            BlogContent blogContent = addBlogContent(contentDTO);
            blogContent.setPostName(blogPost.getTitle());
            blogContent.setBlogPost(blogPost);
            blogPost.getBlogContents().add(blogContent);
        }
        return blogPostRepository.save(blogPost);
    }

    @Override
    @Transactional
    public BlogContent addBlogContent(ContentDTO blogContentDTO) {
        BlogContent blogContent = new BlogContent();
        BlogPost blogPost = blogPostRepository.findByTitle(blogContentDTO.getTitle());
        blogContent.setPostName(blogContentDTO.getTitle());
        blogContent.setLocation(blogContentDTO.getLocation());
        blogContent.setContent(blogContentDTO.getContent());
        blogContent.setCode(blogContentDTO.getCode());
        blogContent.setImage(blogContentDTO.getImage());
        blogContent.setLink(blogContentDTO.getLink());
        blogContent.setHeader(blogContentDTO.getHeader());
        blogContent.setBlogPost(blogPost);
        return blogContentRepository.save(blogContent);
    }

    @Override
    @Transactional
    public BlogPost editBlogPost(BlogPostDTO blogPostDTO) {
        BlogPost blogPost = blogPostRepository.findByTitle(blogPostDTO.getTitle());
        blogPost.setRole(blogPostDTO.getRole());
        blogPost.setFrontend(blogPostDTO.getFrontend());
        blogPost.setBackend(blogPostDTO.getBackend());
        blogPost.setGeneral(blogPostDTO.getGeneral());
        blogContentRepository.deleteByPostName(blogPostDTO.getTitle());
        List<BlogContent> blogContents = new ArrayList<>();
        for (ContentDTO contentDTO : blogPostDTO.getContents()) {
            BlogContent blogContent = addBlogContent(contentDTO);
            blogContent.setPostName(blogPost.getTitle());
            blogContent.setBlogPost(blogPost);
            blogContents.add(blogContent);
        }
        blogPost.setBlogContents(blogContents);
        return blogPostRepository.save(blogPost);
    }

    @Override
    @Transactional
    public void deleteBlogPost(BlogPostDTO blogPostDTO) {
        blogPostRepository.deleteByTitle(blogPostDTO.getTitle());
    }
}
