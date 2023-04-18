import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = CreateSessionFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        SelectPurchasesList selectPurchasesList = new SelectPurchasesList();
        List<PurchaseListEntity> purchasesList = selectPurchasesList.getPurchasesList();

        SelectStudents selectStudents = new SelectStudents();
        List<StudentEntity> studentsList = selectStudents.getStudentsList();
        HashMap<String, Integer> studentsMap = new HashMap<>();
        for (StudentEntity student : studentsList) {
            studentsMap.put(student.getName(), student.getId());
        }

        SelectCourses selectCourses = new SelectCourses();
        List<CourseEntity> coursesList = selectCourses.getCoursesList();
        HashMap<String, Integer> coursesMap = new HashMap<>();
        for (CourseEntity course : coursesList) {
            coursesMap.put(course.getName(), course.getId());
        }

        for (PurchaseListEntity purchaseList : purchasesList) {
            String studentName = purchaseList.getStudentName();
            String courseName = purchaseList.getCourseName();
            LinkedPurchaseListKey key = new LinkedPurchaseListKey();
            key.setStudentId(studentsMap.get(studentName));
            key.setCourseId(coursesMap.get(courseName));

            LinkedPurchaseListEntity linkedPurchaseList = new LinkedPurchaseListEntity();
            linkedPurchaseList.setId(key);
            session.persist(linkedPurchaseList);
        }

        transaction.commit();
        sessionFactory.close();
    }
}
