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
//        EM.clear();

        System.out.println("=============콜렉션타입은 자동으로 지연로딩이된다.================");

        Member3 findMember = EM.find(Member3.class, member.getId());
        System.out.println(findMember);

        System.out.println("이처럼 콜렉션타입을 굳이 안가져온다면 콜렉션타입이 select 되지않은것을 확인할 수 있다.");

        List<Address3> addressHistory = findMember.getAddressHistory();
        for(Address3 i : addressHistory)
            System.out.println(i.getCity());

        //값타입을 수정할때는 사이드이펙트 예방을위해 일부만수정하는것이아니라,
        // 전체를 새로 생성해서 만들어줘야한다  member.getAddress().setCity(); >> X
        member.setAddress(new Address3("city3", "street", "zipcode"));

        member.getFavoriteFoods().remove("피자");
        member.getFavoriteFoods().add("닭발");

        //remove는 equals를 사용한다. 그러므로 equals랑 hashcode를 오버라이딩 해줘야함.
        //값타입 컬렉션은 변경하면 추적이 어렵기때문에 그냥 테이블을 delete해버리고 전부 새로 insert함.
        member.getAddressHistory().remove(new Address3("city3", "street", "zipcode"));

        EM.persist(member);

        ET.commit();
        EM.close();
        EMF.close();
    }
}
