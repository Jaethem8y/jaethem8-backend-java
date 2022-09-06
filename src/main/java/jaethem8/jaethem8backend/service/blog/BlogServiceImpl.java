package jaethem8.jaethem8backend.service.blog;

import jaethem8.jaethem8backend.dto.ContentDTO;
import jaethem8.jaethem8backend.dto.ImageDTO;
import jaethem8.jaethem8backend.dto.LinkDTO;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public BlogPostDTO getBlogPostByTitle(String title) throws Exception {
        blogRepository.getBlogPostByTitle(title);

        return null;
    }

    @Override
    @Transactional
    public BlogPostDTO saveBlogPost(BlogPostDTO blogPostDTO) {
        BlogPost blogPost = new BlogPost();
        mapBlogPost(blogPostDTO, blogPost);
        return blogPostToDTO(blogRepository.saveBlogPost(blogPost));
    }

    @Override
    @Transactional
    public BlogPostDTO updateBlogPost(BlogPostDTO blogPostDTO) throws Exception {
        BlogPost blogPost = blogRepository.getBlogPostByTitle(blogPostDTO.getTitle());
        mapBlogPost(blogPostDTO, blogPost);
        return blogPostToDTO(blogRepository.saveBlogPost(blogPost));
    }

    @Override
    public BlogPost mapBlogPost(BlogPostDTO blogPostDTO, BlogPost blogPost) {
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

            Set<BlogLink> blogLinks = new HashSet<>();
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
        return blogPost;
    }

    @Override
    public BlogPostDTO blogPostToDTO(BlogPost blogPost) {
        BlogPostDTO blogPostDTO = new BlogPostDTO();
        blogPostDTO.setTitle(blogPost.getTitle());
        blogPostDTO.setRole(blogPost.getRole());
        blogPostDTO.setFrontend(blogPost.getFrontend());
        blogPostDTO.setBackend(blogPost.getBackend());
        blogPostDTO.setDescription(blogPost.getDescription());
        blogPostDTO.setGeneral(blogPost.getGeneral());
        blogPostDTO.setPubDate(blogPost.getDate());

        List<ContentDTO> contents = new ArrayList<>();

        blogPost.getBlogContents().forEach(blogContent -> {
            ContentDTO content = new ContentDTO();
            content.setLocation(blogContent.getLocation());
            content.setHeader(blogContent.getHeader());
            content.setCode(blogContent.getCode());

            List<LinkDTO> links = new ArrayList<>();

            blogContent.getBlogLinks().forEach(blogLink -> {
                LinkDTO linkDTO = new LinkDTO();
                linkDTO.setLink(blogLink.getLink());
                linkDTO.setTag(blogLink.getTag());
                links.add(linkDTO);
            });

            content.setLinks(links);

            List<ImageDTO> images = new ArrayList<>();

            blogContent.getBlogImages().forEach(blogImage -> {
                ImageDTO imageDTO = new ImageDTO();
                imageDTO.setImage(blogImage.getImage());
                images.add(imageDTO);
            });

            content.setImages(images);
        });

        blogPostDTO.setContents(contents);
        return blogPostDTO;
    }

    @Override
    @Transactional
    public void removeBlogPost(BlogPostDTO blogPostDTO) throws Exception {
        String title = blogPostDTO.getTitle();
        BlogPost blogPost = blogRepository.getBlogPostByTitle(title);
        blogRepository.removeBlogPost(blogPost);
    }
}
