package jaethem8.jaethem8backend.model.personal;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jaethem8.jaethem8backend.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "personal_post")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalPost extends Post {
    @JsonManagedReference
    @OneToMany(mappedBy = "personalPost", cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    private List<PersonalContent> personalContents = new ArrayList<>();
}
