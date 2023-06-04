package domain;

import javax.persistence.*;

@Entity
@Table(name = "education_details")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "edu_id")
    private int eduID;
    @Column(name = "_10th")
    private double _10;
    @Column(name = "_12th")
    private double _12;
    @Column(name = "degree")
    private double degree;

    public int getEduID() {
        return eduID;
    }

    public void setEduID(int eduID) {
        this.eduID = eduID;
    }

    public double get_10() {
        return _10;
    }

    public void set_10(double _10) {
        this._10 = _10;
    }

    public double get_12() {
        return _12;
    }

    public void set_12(double _12) {
        this._12 = _12;
    }

    public double getDegree() {
        return degree;
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }
}
