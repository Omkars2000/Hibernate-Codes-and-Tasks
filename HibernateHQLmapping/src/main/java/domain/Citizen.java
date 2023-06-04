package domain;

import javax.persistence.*;


@Entity
@Table(name = "citizen_info")
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "citizen_id")
    private int citizenId;
    @Column(name = "citizen_name")
    private String citizenName;
    @Column(name = "citizen_age")
    private int citizenAge;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_ref")
    private Passport passportRef;

    public Passport getPassportRef() {
        return passportRef;
    }

    public void setPassportRef(Passport passportRef) {
        this.passportRef = passportRef;
    }

    public int getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(int citizenId) {
        this.citizenId = citizenId;
    }

    public String getCitizenName() {
        return citizenName;
    }

    public void setCitizenName(String citizenName) {
        this.citizenName = citizenName;
    }

    public int getCitizenAge() {
        return citizenAge;
    }

    public void setCitizenAge(int citizenAge) {
        this.citizenAge = citizenAge;
    }

    @Override
    public String toString() {
        return citizenId+"\t"+citizenName+"\t"+citizenAge+"\t"+passportRef;
    }
}
