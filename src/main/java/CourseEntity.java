import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Courses")
@Getter
@Setter
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int duration;
    @Enumerated (EnumType.STRING)
    @Column(columnDefinition = "enum('DESIGN', 'PROGRAMMING', 'MARKETING', 'MANAGEMENT', 'BUSINESS')")
    private CourseType type;
    private String description;
    @ManyToOne (cascade = CascadeType.ALL)
    private TeacherEntity teacher;
    @Column(name = "students_count", nullable = true)
    private Integer studentsCount;
    private int price;
    @Column(name = "price_per_hour")
    private float pricePerHour;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable (name = "Subscriptions",
            joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")}
    )
    private List<StudentEntity> students;
}
