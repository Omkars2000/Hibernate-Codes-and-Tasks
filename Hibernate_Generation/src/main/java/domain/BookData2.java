package domain;

import javax.persistence.*;

@Entity
@Table(name = "book_info2")
public class BookData2 {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
      @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "book_generator")
    @SequenceGenerator(name = "book_generator",sequenceName = "book_sequence",initialValue = 10001,allocationSize = 1)
    @Column(name = "book_id")
    private int bookId;
    @Column(name="book_name")
    private String bookName;
    @Column(name = "book_price")
    private double bookPrice;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }
}
