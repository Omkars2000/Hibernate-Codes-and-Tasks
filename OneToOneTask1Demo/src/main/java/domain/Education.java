package domain;

import javax.persistence.*;

@Entity
@Table(name = "education_details")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "edu_id")
    private int EductionId;
    @Column(name = "_10th")
    private double _10;
    @Column(name = "_12th")
    private  double _12;
    @Column(name = "degree")
    private double _degree;

    public int getEductionId() {
        return EductionId;
    }

    public void setEductionId(int eductionId) {
        EductionId = eductionId;
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

    public double get_degree() {
        return _degree;
    }

    public void set_degree(double _degree) {
        this._degree = _degree;
    }

    @Override
    public String toString() {
        return get_10()+"\t"+get_12()+"\t"+get_degree();
    }
}

