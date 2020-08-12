package ImutableObject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain2 {

    public static void main(String[] args) {

        EntityManagerFactory EMF = Persistence.createEntityManagerFactory("hello");
        EntityManager EM = EMF.createEntityManager();
        EntityTransaction ET = EM.getTransaction();

        ET.begin();
        Member2 member = new Member2();
        member.setName("Junseok");
        member.setAddress(new Address2("city", "street", "zipcode"));

        member.setPeriod(new Period2());

        //값타입의 세터를 지움으로써 참조에의한 사이드이펙트를 예방할수있다.
        //대신, 값 변경이 안되니 변경할떄는 통으로 새로 만들어야함.

        member.setAddress(new Address2("city2", "street2", "zipcode2"));

        EM.persist(member);

        ET.commit();
        EM.close();
        EMF.close();
    }
}
