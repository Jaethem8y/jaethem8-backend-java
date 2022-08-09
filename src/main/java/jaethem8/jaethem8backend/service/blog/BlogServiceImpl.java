package jaethem8.jaethem8backend.service.blog;

import jaethem8.jaethem8backend.dto.blog.BlogPostDTO;
import jaethem8.jaethem8backend.model.blog.BlogContent;
import jaethem8.jaethem8backend.model.blog.BlogImage;
import jaethem8.jaethem8backend.model.blog.BlogLink;
import jaethem8.jaethem8backend.model.blog.BlogPost;
import jaethem8.jaethem8backend.repository.blog.BlogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BlogServiceImpl implements BlogService {
    private final BlogRepository blogRepository;
    private static Logger logger = LoggerFactory.getLogger(BlogServiceImpl.class);

    @Override
    @Transactional
    public List<BlogPostDTO> getAllBlogPost() {
        List<BlogPost> blogPosts = blogRepository.getAllBlogPost();
        List<BlogPostDTO> blogPostDTOs = new ArrayList<>();

        blogPosts.forEach(blogPost -> {
            BlogPostDTO blogPostDTO = new BlogPostDTO();
            blogPostDTO.setTitle(blogPost.getTitle());
            blogPostDTO.setRole(blogPost.getRole());
            blogPostDTO.setDescription(blogPost.getDescription());
            blogPostDTO.setFrontend(blogPost.getFrontend());
            blogPostDTO.setBackend(blogPost.getBackend());
            blogPostDTO.setGeneral(blogPost.getGeneral());
            blogPostDTOs.add(blogPostDTO);
        });
        return blogPostDTOs;
    }

    @Override
    @Transactional
    public BlogPost getBlogPostByTitle(String title) throws Exception {
        return blogRepository.getBlogPostByTitle(title);
    }

    @Override
    @Transactional
    public BlogPost saveBlogPost(BlogPostDTO blogPostDTO) {

        BlogPost blogPost = new BlogPost();
        blogPost.setTitle(blogPostDTO.getTitle());
        blogPost.setDate(new Timestamp(System.currentTimeMillis()));
        blogPost.setRole(blogPostDTO.getRole());
        blogPost.setFrontend(blogPostDTO.getFrontend());
        blogPost.setBackend(blogPostDTO.getBackend());
        blogPost.setGeneral(blogPostDTO.getGeneral());

        List<BlogContent> blogContents = new ArrayList<>();
        blogPostDTO.getContents().forEach(blogContentDTO -> {
            BlogContent blogContent = new BlogContent();
            blogContent.setLocation(blogContentDTO.getLocation());
            blogContent.setHeader(blogContentDTO.getHeader());
            blogContent.setContent(blogContentDTO.getContent());
            blogContent.setCode(blogContentDTO.getCode());

            List<BlogImage> blogImages = new ArrayList<>();
            blogContentDTO.getImages().forEach(blogImageDTO -> {
                BlogImage blogImage = new BlogImage();
                blogImage.setImage(blogImageDTO.getImage());
                blogImage.setBlogContent(blogContent);
                blogImages.add(blogImage);
            });

            List<BlogLink> blogLinks = new ArrayList<>();
            blogContentDTO.getLinks().forEach(blogLinkDTO -> {
                BlogLink blogLink = new BlogLink();
                blogLink.setTag(blogLinkDTO.getTag());
                blogLink.setLink(blogLinkDTO.getLink());
                blogLink.setBlogContent(blogContent);
                blogLinks.add(blogLink);
            });

            blogContent.setBlogPost(blogPost);
            blogContent.setBlogImages(blogImages);
            blogContent.setBlogLinks(blogLinks);
            blogContents.add(blogContent);
        });
        blogPost.setBlogContents(blogContents);

        return blogRepository.saveBlogPost(blogPost);
    }
}
