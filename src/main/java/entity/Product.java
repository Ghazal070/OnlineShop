package entity;

import entity.enumration.ProductCategory;
import entity.enumration.ProductSubType;

public class Product extends BaseEntity<Integer>{
    public static final String TABLE_NAME="product";
    private String name;
    private ProductCategory productCategory;
    private ProductSubType productSubType;
    double price;
    private Integer countInShop;


    public Product(Integer id, String name, ProductCategory productCategory, ProductSubType productSubType, double price, Integer countInShop) {
        super(id);
        this.name = name;
        this.productCategory = productCategory;
        this.productSubType = productSubType;
        this.price = price;
        this.countInShop = countInShop;

    }
    //if a product add to shop or sells must count change

    public Product(String name, ProductCategory productCategory, ProductSubType productSubType, double price, Integer countInShop) {
        this.name = name;
        this.productCategory = productCategory;
        this.productSubType = productSubType;
        this.price = price;
        this.countInShop = countInShop;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public ProductSubType getProductSubType() {
        return productSubType;
    }

    public void setProductSubType(ProductSubType productSubType) {
        this.productSubType = productSubType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getCountInShop() {
        return countInShop;
    }

    public void setCountInShop(Integer countInShop) {
        this.countInShop = countInShop;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", productCategory=" + productCategory +
                ", price=" + price +
                ", count=" + countInShop +
                "} " + super.toString();
    }
}
