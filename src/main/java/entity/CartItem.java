package entity;

public class CartItem extends  BaseEntity<Integer>{
    private Cart cart;
    //cart must be set tavasot khodam az cutomer login.
    private Product product;
    private Integer countInCart;

    public CartItem(Integer id, Product product, Integer countInCart) {
        super(id);
        this.product = product;
        this.countInCart = countInCart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCountInCart() {
        return countInCart;
    }

    public void setCountInCart(Integer countInCart) {
        this.countInCart = countInCart;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cart=" + cart +
                ", product=" + product +
                ", countInCart=" + countInCart +
                "} " + super.toString();
    }
}
