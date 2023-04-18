import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class SelectCourses {
    public List<CourseEntity> getCoursesList() {
        SessionFactory sessionFactory = CreateSessionFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<CourseEntity> queryCourse = builder.createQuery(CourseEntity.class);
        Root<CourseEntity> rootCourse = queryCourse.from(CourseEntity.class);
        queryCourse.select(rootCourse);
        List<CourseEntity> coursesList = session.createQuery(queryCourse).getResultList();

        transaction.commit();
        sessionFactory.close();

        return coursesList;
    }
}
