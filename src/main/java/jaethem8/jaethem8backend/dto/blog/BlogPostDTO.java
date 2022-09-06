package jaethem8.jaethem8backend.dto.blog;

import jaethem8.jaethem8backend.dto.ContentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogPostDTO {
    private String title;
    private String role;
    private String frontend;
    private String backend;
    private String description;
    private String general;
    private Timestamp pubDate;
    private List<ContentDTO> contents = new ArrayList<>();
}
