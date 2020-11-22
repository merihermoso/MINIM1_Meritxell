package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Product {

    String id;
    String productName;
    String prize;
    int numVentas=0;
    static int lastId;

    public Product(String productName, String prize) {
        this.id = RandomUtils.getId();
    }

    public Product(String id, String productName, String prize) {
        this();
     //   this.setId(id);
        this.setPrize(prize);
        this.setProductName(productName);
        this.numVentas=0;
    }

    public Product() {

    }

    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id=id;
    }


    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrize() {
        return prize;
    }
    public void setPrize(String prize) {
        this.prize = prize;
    }

    @Override
    public String toString() {
        return "Product [id = "+id+", Name = " + productName + ", prize = " + prize +"€  ]";
    }

}