package EmbeddedType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory EMF = Persistence.createEntityManagerFactory("hello");
        EntityManager EM = EMF.createEntityManager();
        EntityTransaction ET = EM.getTransaction();

        ET.begin();
        Member member = new Member();
        member.setName("Junseok");
        member.setAddress(new Address("city", "street", "zipcode"));

        member.setPeriod(new Period());

        EM.persist(member);

        ET.commit();
        EM.close();
        EMF.close();
    }
}
