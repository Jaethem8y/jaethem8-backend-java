package jaethem8.jaethem8backend.model.study;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jaethem8.jaethem8backend.model.Post;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "study_post")
public class StudyPost extends Post {
    @JsonManagedReference
    @OneToMany(mappedBy = "studyPost", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StudyContent> studyContents = new ArrayList<>();

    public StudyPost() {
    }

    public StudyPost(long id, String title, Timestamp date, String description, List<StudyContent> studyContents) {
        super(id, title, date, description);
        this.studyContents = studyContents;
    }

    public List<StudyContent> getStudyContents() {
        return studyContents;
    }

    public void setStudyContents(List<StudyContent> studyContents) {
        this.studyContents = studyContents;
    }
}
