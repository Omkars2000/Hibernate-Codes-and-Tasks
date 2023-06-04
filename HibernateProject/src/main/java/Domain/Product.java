package Domain;

public class Product {
    private int productId;
    private String productName;
    private String productCategory;
    private double productPrice;
    

    public int getproductId() {
        return productId;
    }

    public void setproductId(int product_id) {
        this.productId = product_id;
    }

    public String getproductName() {
        return productName;
    }

    public void setproductName(String productName) {
        this.productName = productName;
    }
    

    public String getproductCategory() {
        return productCategory;
    }

    public void setproductCategory(String productCategory) {
        this.productCategory = productCategory;
    }
    

    public double getproductPrice() {
        return productPrice;
    }

    public void setproductPrice(double productPrice) {
        this.productPrice = productPrice;
    }



}
