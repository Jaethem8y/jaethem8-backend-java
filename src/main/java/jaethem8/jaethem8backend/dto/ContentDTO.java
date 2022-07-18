package jaethem8.jaethem8backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContentDTO {
    private String title;
    private int location;
    private String content;
    private String link;
    private String image;
    private String code;
}
