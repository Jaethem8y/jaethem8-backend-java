package jaethem8.jaethem8backend.model.personal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jaethem8.jaethem8backend.model.Content;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "personal_content")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalContent extends Content {
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonBackReference
    @JoinColumn(name = "personal_post_id")
    private PersonalPost personalPost;
}
