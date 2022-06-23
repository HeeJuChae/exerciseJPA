package jpabook.jpashop;

import jpabook.jpashop.domain.Orders;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        // 엔티티 매니저에서 트랜젝션 얻어오기
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        // 객체 생성
        try{
            Orders orders = new Orders();

            tx.commit();
        }catch (Exception e){
            // 롤백
            tx.rollback();
        }finally {
            // 엔티티 매니저 종료
            em.close();
        }
        // 엔티티 매니저 팩토리 종료
        emf.close();
    }
}
