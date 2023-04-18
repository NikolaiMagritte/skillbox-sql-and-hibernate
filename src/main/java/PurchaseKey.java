import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;
@Getter
@Setter
public class PurchaseKey implements Serializable {

    @Column(name = "student_name")
    private String studentName;
    @Column(name = "course_name")
    private String courseName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseKey that = (PurchaseKey) o;
        return Objects.equals(studentName, that.studentName) && Objects.equals(courseName, that.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentName, courseName);
    }
}
