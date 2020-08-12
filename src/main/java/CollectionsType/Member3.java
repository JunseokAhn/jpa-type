package CollectionsType;

import EmbeddedType.Address;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Member3 {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String name;

    @Embedded
    private Address3 address;
    
    @Embedded
    private Period3 period;

    //DB는 컬렉션을 같은 테이블에 저장할수없다. 컬렉션을 저장하기위한 별도의 테이블이 필요함
    //의문. 이럴게아니라 OneToMany로 엮으면 되는거아닌가?? 좀더 class를 줄여주는측면에서 이득인거같기도 함.
    //Member가 수정이 되었을때(아마 MEMBER_ID??) 값타입컬렉션도 같이 수정이되고,
    //persist(member)한번만 하면 되기떄문에 훨씬 편리한듯 하다.

    //+ 이경우, 컬렉션타입은 자동적으로 지연로딩이 된다.
    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD", joinColumns = @JoinColumn(name = "MEMBER_ID"))
    @Column(name = "FOOD") //값이 2개뿐인 Set타입이라서 예외적으로 컬럼네임 지정가능
    private Set<String> favoriteFoods = new HashSet<>();

    @ElementCollection //List타입은 안된다.
    @CollectionTable(name = "ADDRESS_HISTORY", joinColumns = @JoinColumn(name = "MEMBER_ID"))
    private List<Address3> addressHistory = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address3 getAddress() {
        return address;
    }

    public void setAddress(Address3 address) {
        this.address = address;
    }

    public Period3 getPeriod() {
        return period;
    }

    public void setPeriod(Period3 period) {
        this.period = period;
    }

    public Set<String> getFavoriteFoods() {
        return favoriteFoods;
    }

    public void setFavoriteFoods(Set<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }

    public List<Address3> getAddressHistory() {
        return addressHistory;
    }

    public void setAddressHistory(List<Address3> addressHistory) {
        this.addressHistory = addressHistory;
    }
}
