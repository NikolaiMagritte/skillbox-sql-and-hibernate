import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
@Getter
@Setter
public class LinkedPurchaseListKey {
    @Column(name = "student_id")
    private int studentId;
    @Column (name = "course_id")
    private int courseId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedPurchaseListKey that = (LinkedPurchaseListKey) o;
        return studentId == that.studentId && courseId == that.courseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, courseId);
    }
}
