package jaethem8.jaethem8backend.model.study;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jaethem8.jaethem8backend.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "study_post")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudyPost extends Post {
    @JsonManagedReference
    @OneToMany(mappedBy = "studyPost", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<StudyContent> studyContents = new ArrayList<>();

}
