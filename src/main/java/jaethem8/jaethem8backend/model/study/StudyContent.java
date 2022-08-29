package jaethem8.jaethem8backend.model.study;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jaethem8.jaethem8backend.model.Content;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "study_content")
public class StudyContent extends Content {
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonBackReference
    @JoinColumn(name = "study_post_id")
    private StudyPost studyPost;
    @JsonManagedReference
    @OneToMany(mappedBy = "studyContent", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<StudyImage> studyImages = new ArrayList<>();
    @JsonManagedReference
    @OneToMany(mappedBy = "studyContent", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<StudyLink> studyLinks = new HashSet<>();

    public StudyContent() {
    }

    public StudyContent(long id, int location, String header, String content, String code, StudyPost studyPost, List<StudyImage> studyImages, Set<StudyLink> studyLinks) {
        super(id, location, header, content, code);
        this.studyPost = studyPost;
        this.studyImages = studyImages;
        this.studyLinks = studyLinks;
    }

    public StudyPost getStudyPost() {
        return studyPost;
    }

    public void setStudyPost(StudyPost studyPost) {
        this.studyPost = studyPost;
    }

    public List<StudyImage> getStudyImages() {
        return studyImages;
    }

    public void setStudyImages(List<StudyImage> studyImages) {
        this.studyImages = studyImages;
    }

    public Set<StudyLink> getStudyLinks() {
        return studyLinks;
    }

    public void setStudyLinks(Set<StudyLink> studyLinks) {
        this.studyLinks = studyLinks;
    }
}
