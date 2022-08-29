package jaethem8.jaethem8backend.model.study;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jaethem8.jaethem8backend.model.Link;

import javax.persistence.*;

@Entity
@Table(name = "study_link")
public class StudyLink extends Link {
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonBackReference
    @JoinColumn(name = "study_content_id")
    private StudyContent studyContent;

    public StudyLink() {
    }

    public StudyLink(long id, String tag, String link, StudyContent studyContent) {
        super(id, tag, link);
        this.studyContent = studyContent;
    }

    public StudyContent getStudyContent() {
        return studyContent;
    }

    public void setStudyContent(StudyContent studyContent) {
        this.studyContent = studyContent;
    }
}
