package domain;

import javax.persistence.*;

@Entity
@Table(name = "passport_info")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passport_id")
    private int passportId;
    @Column(name = "passport_no")
    private  String passNo;
    @Column(name = "country")
    private String passCountry;

    public int getPassportId() {
        return passportId;
    }

    public void setPassportId(int passportId) {
        this.passportId = passportId;
    }

    public String getPassNo() {
        return passNo;
    }

    public void setPassNo(String passNo) {
        this.passNo = passNo;
    }

    public String getPassCountry() {
        return passCountry;
    }

    public void setPassCountry(String passCountry) {
        this.passCountry = passCountry;
    }

    @Override
    public String toString() {
        return passNo+"\t"+passCountry;

    }
}
