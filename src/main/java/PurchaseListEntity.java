import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "PurchaseList")
@Getter
@Setter
public class PurchaseListEntity {
    @EmbeddedId
    private PurchaseKey id;
    @Column(name = "student_name", insertable = false, updatable = false)
    private String studentName;
    @Column(name = "course_name", insertable = false, updatable = false)
    private String courseName;
    private int price;
    @Column(name = "subscription_date")
    private Date subscriptionDate;
}
