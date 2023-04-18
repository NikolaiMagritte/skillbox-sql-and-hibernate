import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class SelectStudents {
    public List<StudentEntity> getStudentsList() {
        SessionFactory sessionFactory = CreateSessionFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<StudentEntity> queryStudent = builder.createQuery(StudentEntity.class);
        Root<StudentEntity> rootStudent = queryStudent.from(StudentEntity.class);
        queryStudent.select(rootStudent);
        List<StudentEntity> studentsList = session.createQuery(queryStudent).getResultList();

        transaction.commit();
        sessionFactory.close();

        return studentsList;
    }
}
