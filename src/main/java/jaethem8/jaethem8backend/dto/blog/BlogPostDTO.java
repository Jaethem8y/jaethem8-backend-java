package jaethem8.jaethem8backend.dto.blog;

import jaethem8.jaethem8backend.dto.ContentDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class BlogPostDTO {
    private final String title;
    private final String role;
    private final String frontend;
    private final String backend;
    private final String general;
    private final List<ContentDTO> contents = new ArrayList<>();
}
