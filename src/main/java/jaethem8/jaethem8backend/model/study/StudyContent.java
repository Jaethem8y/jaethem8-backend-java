package jaethem8.jaethem8backend.model.study;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jaethem8.jaethem8backend.model.Content;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "study_content")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudyContent extends Content {
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonBackReference
    @JoinColumn(name = "study_post_id")
    private StudyPost studyPost;

}
