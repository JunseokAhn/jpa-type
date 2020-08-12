package ImutableObject;

import javax.persistence.Embeddable;

@Embeddable
public class Address2 {

    private String city;
    private String street;
    private String zipcode;

    public Address2(){}

    public Address2(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getZipcode() {
        return zipcode;
    }

}
