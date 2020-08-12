package CollectionsType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain3 {

    public static void main(String[] args) {

        EntityManagerFactory EMF = Persistence.createEntityManagerFactory("hello");
        EntityManager EM = EMF.createEntityManager();
        EntityTransaction ET = EM.getTransaction();

        ET.begin();
        Member3 member = new Member3();
        member.setName("Junseok");
        member.setAddress(new Address3("city", "street", "zipcode"));

        member.setPeriod(new Period3());

        member.getFavoriteFoods().add("라면");
        member.getFavoriteFoods().add("고기");
        member.getFavoriteFoods().add("피자");

        member.getAddressHistory().add(new Address3("city", "street", "zipcode"));
        member.getAddressHistory().add(new Address3("city2", "street2", "zipcode2"));

        EM.persist(member);

        EM.flush();
        EM.clear();

        System.out.println("=============콜렉션타입은 자동으로 지연로딩이된다.================");

        Member3 findMember = EM.find(Member3.class, member.getId());
        System.out.println(findMember);

        System.out.println("이처럼 콜렉션타입을 굳이 안가져온다면 콜렉션타입이 select 되지않은것을 확인할 수 있다.");

        List<Address3> addressHistory = findMember.getAddressHistory();
        for(Address3 i : addressHistory)
            System.out.println(i.getCity());

        ET.commit();
        EM.close();
        EMF.close();
    }
}
