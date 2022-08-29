package jaethem8.jaethem8backend.model.study;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jaethem8.jaethem8backend.model.Image;

import javax.persistence.*;

@Entity
@Table(name = "study_image")
public class StudyImage extends Image {
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonBackReference
    @JoinColumn(name = "study_content_id")
    private StudyContent studyContent;

    public StudyImage() {
    }

    public StudyImage(long id, String image, StudyContent studyContent) {
        super(id, image);
        this.studyContent = studyContent;
    }

    public StudyContent getStudyContent() {
        return studyContent;
    }

    public void setStudyContent(StudyContent studyContent) {
        this.studyContent = studyContent;
    }
}
