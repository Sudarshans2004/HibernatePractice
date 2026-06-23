import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table (name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addreess_id")
    private  int addressId;
    @Column(name = "city", length = 100)
    private String city ;
    @Column(name = "street_name")
    private String street;
    @Column(name = "is_open")

    private boolean isOpen;
    @Transient

    private double x;
    @Column(name = "added_date")

    @Temporal(TemporalType.DATE)
    private Date addDate;
    @Lob
    @Column(name = "image", columnDefinition = "LONGBLOB")
    private byte[] image;

    public Address() {
    }

    public Address(int addressId, String city, String street, boolean isOpen, double x, Date addDate, byte[] image) {
        this.addressId = addressId;
        this.city = city;
        this.street = street;
        this.isOpen = isOpen;
        this.x = x;
        this.addDate = addDate;
        this.image = image;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
