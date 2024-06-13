package entity;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class CartItem extends  BaseEntity<Integer>{
    public static final String TABLE_NAME="cart_item";
    private Cart cart;
    private Product product;
    private Integer countInCart;

    public CartItem(Integer id,Cart cart, Product product, Integer countInCart) {
        super(id);
        this.product = product;
        this.countInCart = countInCart;
        this.cart =cart;
    }
    public CartItem(Product product,Cart cart, Integer countInCart) {
        this.cart=cart;
        this.product = product;
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
