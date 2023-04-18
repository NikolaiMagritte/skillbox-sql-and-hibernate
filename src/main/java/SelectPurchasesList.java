import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class SelectPurchasesList {
    public List<PurchaseListEntity> getPurchasesList() {
        SessionFactory sessionFactory = CreateSessionFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<PurchaseListEntity> queryPurchaseList = builder.createQuery(PurchaseListEntity.class);
        Root<PurchaseListEntity> rootPurchaseList = queryPurchaseList.from(PurchaseListEntity.class);
        queryPurchaseList.select(rootPurchaseList);
        List<PurchaseListEntity> purchasesList = session.createQuery(queryPurchaseList).getResultList();

        transaction.commit();
        sessionFactory.close();

        return purchasesList;
    }
}
