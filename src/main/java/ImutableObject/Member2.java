package ImutableObject;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Member2 {

    @Id @GeneratedValue
    private Long id;
    private String name;

    @Embedded
    private Address2 address;
    
    @Embedded
    private Period2 period;

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

    public Address2 getAddress() {
        return address;
    }

    public void setAddress(Address2 address) {
        this.address = address;
    }

    public Period2 getPeriod() {
        return period;
    }

    public void setPeriod(Period2 period) {
        this.period = period;
    }
}
