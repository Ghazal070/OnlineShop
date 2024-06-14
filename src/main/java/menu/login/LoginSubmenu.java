package menu.login;

import entity.Cart;
import entity.CartItem;
import entity.Product;
import menu.util.Input;
import menu.util.Massage;
import service.CartItemService;
import service.CartService;
import service.ProductService;
import util.AuthHolder;

public class LoginSubmenu {
    private final Input INPUT;
    private final Massage MASSAGE;
    private final ProductService productService;
    private final CartService cartService;
    private final AuthHolder authHolder;
    private final CartItemService cartItemService;


    public LoginSubmenu(Input INPUT, Massage MASSAGE, ProductService productService, CartService cartService, AuthHolder authHolder, CartItemService cartItemService) {
        this.INPUT = INPUT;
        this.MASSAGE = MASSAGE;
        this.productService = productService;
        this.cartService = cartService;
        this.authHolder = authHolder;
        this.cartItemService = cartItemService;
    }

    public void show() {

        while (true) {
            System.out.println("""
                    Enter one of the following options
                    1- Add product 
                    2- Remove product
                    3- Print All Product
                    4- Print price of your cart
                    5- Exit
                    """);
            switch (INPUT.scanner.next()) {
                case "1": {
                    System.out.println("""
                            Enter one of the following options
                            1- Electronic appliances 
                            2- Shoes
                            3- Previous Menu
                                    """);
                    Integer inputNumber = null;
                    switch (INPUT.scanner.next()) {
                        case "1": {
                            System.out.println("""
                                    Enter one of the following options
                                    1- Radio
                                    2- Television
                                    3- Previous Menu
                                    """);
                            switch (INPUT.scanner.next()) {
                                case "1":
                                    inputNumber = 1;
                                    break;
                                case "2":
                                    inputNumber = 2;
                                    break;
                                case "3":
                                    break;
                            }

                            Product product = productService.findByID(inputNumber);
                            Cart cart = cartService.findByCustomerID(authHolder.tokenId);
                            if (product != null && cart != null) {
                                CartItem cartItem = new CartItem(product, cart, 1);
                                if (cartService.add(cartItem)) {
                                    System.out.println(MASSAGE.getSuccessfulMassage("add "));
                                } else {
                                    System.out.println(MASSAGE.getFailMassage("add "));
                                }
                                break;
                            } else {
                                System.out.println("Product or cart not found.");
                            }
                            break;
                        }
                        case "2": {
                            System.out.println("""
                                    Enter one of the following options
                                    1- Sport
                                    2- Formal
                                    3- Previous Menu
                                    """);
                            switch (INPUT.scanner.next()) {
                                case "1":
                                    inputNumber = 4;
                                    break;
                                case "2":
                                    inputNumber = 3;
                                case "3":
                                    break;
                            }
                            Product product = productService.findByID(inputNumber);
                            Cart cart = cartService.findByCustomerID(authHolder.tokenId);
                            if (product != null && cart != null) {
                                CartItem cartItem = new CartItem(product, cart, 1);
                                if (cartService.add(cartItem)) {
                                    System.out.println(MASSAGE.getSuccessfulMassage("add "));
                                } else {
                                    System.out.println(MASSAGE.getFailMassage("add "));
                                }
                                break;
                            } else {
                                System.out.println("Product or cart not found.");
                            }
                            break;
                        }
                        case "3": {
                            break;
                        }
                        default:
                            System.out.println(MASSAGE.getInvalidMassage());
                    }
                }

                case "2": {
                    System.out.println("""
                            Enter one of the following options
                            1- Electronic appliances 
                            2- Shoes
                            3- Previous Menu
                                    """);
                    Integer inputNumber = null;
                    switch (INPUT.scanner.next()) {
                        case "1": {
                            System.out.println("""
                                    Enter one of the following options
                                    1- Radio
                                    2- Television
                                    3- Previous Menu
                                    """);
                            switch (INPUT.scanner.next()) {
                                case "1":
                                    inputNumber = 1;
                                    break;
                                case "2":
                                    inputNumber = 2;
                                    break;
                                case "3":
                                    break;
                            }

                            Product product = productService.findByID(inputNumber);
                            Cart cart = cartService.findByCustomerID(authHolder.tokenId);
                            if (product != null && cart != null) {
                                CartItem cartItem = new CartItem(product, cart, 1);
                                if (cartService.remove(cartItem)) {
                                    System.out.println(MASSAGE.getSuccessfulMassage("remove "));
                                } else {
                                    System.out.println(MASSAGE.getFailMassage("remove "));
                                }
                                break;
                            } else {
                                System.out.println("Product or cart not found.");
                            }
                            break;
                        }
                        case "2": {
                            System.out.println("""
                                    Enter one of the following options
                                    1- Sport
                                    2- Formal
                                    3- Previous Menu
                                    """);
                            switch (INPUT.scanner.next()) {
                                case "1":
                                    inputNumber = 4;
                                    break;

                                case "2":
                                    inputNumber = 3;
                                case "3":
                                    break;
                            }
                            Product product = productService.findByID(inputNumber);
                            Cart cart = cartService.findByCustomerID(authHolder.tokenId);
                            if (product != null && cart != null) {
                                CartItem cartItem = new CartItem(product, cart, 1);
                                if (cartService.remove(cartItem)) {
                                    System.out.println(MASSAGE.getSuccessfulMassage("remove "));
                                } else {
                                    System.out.println(MASSAGE.getFailMassage("remove "));
                                }
                                break;
                            } else {
                                System.out.println("Product or cart not found.");
                            }
                            break;
                        }
                        case "3": {
                            break;
                        }
                        default:
                            System.out.println(MASSAGE.getInvalidMassage());
                    }
                }
                case "3": {
                    Cart cart = cartService.findByCustomerID(authHolder.tokenId);
                    if (cart != null) {
                        System.out.println(cartItemService.showCartItem(cart));
                        break;
                    }
                    else {System.out.println("Cart not found.");}
                    break;
                }
                case "4": {
                    Cart cart = cartService.findByCustomerID(authHolder.tokenId);
                    if (cart != null) {
                        System.out.println(cartItemService.calculatePrice(cart));
                        break;
                    }
                    else {System.out.println("Cart not found.");}
                    break;
                }
                case "5": {
                    System.exit(0);
                }
                default:
                    System.out.println(MASSAGE.getInvalidMassage());
            }

        }
    }
}
