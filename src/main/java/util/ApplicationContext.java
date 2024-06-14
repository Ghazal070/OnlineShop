package util;

import config.DataSource;
import menu.Menu;
import menu.login.LoginMenu;
import menu.login.LoginSubmenu;
import menu.main.MainMenu;
import menu.signup.SignupMenu;
import menu.util.Input;
import menu.util.Massage;
import repository.CartItemRepository;
import repository.CartRepository;
import repository.CustomerRepository;
import repository.ProductRepository;
import repository.impl.CartItemRepositoryImpl;
import repository.impl.CartRepositoryImpl;
import repository.impl.CustomerRepositoryImpl;
import repository.impl.ProductRepositoryImpl;
import service.CartItemService;
import service.CartService;
import service.CustomerService;
import service.ProductService;
import service.impl.CartItemServiceImpl;
import service.impl.CartServiceImpl;
import service.impl.CustomerServiceImpl;
import service.impl.ProductServiceImpl;

import java.sql.Connection;

public class ApplicationContext {
//    private final static ApplicationContext Instance = new ApplicationContext();
//    private Menu menu;

//    private ApplicationContext() {
//        Connection connection = DataSource.getConnection();
//        AuthHolder authHolder = new AuthHolder();
//        Input input = new Input();
//        Massage massage = new Massage();
//        MainMenu mainMenu = new MainMenu();
//        LoginSubmenu loginSubmenu = new LoginSubmenu(input,massage);
//        CustomerRepository customerRepository = new CustomerRepositoryImpl(connection);
//        CustomerService customerService =new CustomerServiceImpl(customerRepository,authHolder);
//        LoginMenu loginMenu = new LoginMenu(input,massage,customerService);
//        SignupMenu signUpMenu = new SignupMenu(input,massage,customerService);
//
//        menu = new Menu(input,massage,loginMenu,signUpMenu,mainMenu);
//
//    }
private final static ApplicationContext Instance = new ApplicationContext();
    private Menu menu;
    public Connection connection;
//    public CustomerService customerService;
    public CustomerRepository customerRepository;
    public ProductService productService;
    public CartItemService cartItemService;
//    public  CartService cartService;
public CartService cartService;

    private ApplicationContext() {
        connection = DataSource.getConnection();
        AuthHolder authHolder = new AuthHolder();
        Input input = new Input();
        Massage massage = new Massage();
        MainMenu mainMenu = new MainMenu();
        ProductRepository productRepository=new ProductRepositoryImpl(connection);
        productService =new ProductServiceImpl(productRepository);
        CartItemRepository cartItemRepository =new CartItemRepositoryImpl(connection);
        cartItemService = new CartItemServiceImpl(cartItemRepository);
        CartRepository cartRepository = new CartRepositoryImpl(connection,authHolder);
        cartService= new CartServiceImpl(cartRepository,authHolder, productService, cartItemService);
        LoginSubmenu loginSubmenu = new LoginSubmenu(input,massage, productService, cartService, authHolder, cartItemService);
        customerRepository = new CustomerRepositoryImpl(connection);
        CustomerService customerService =new CustomerServiceImpl(customerRepository,authHolder,cartService);
        LoginMenu loginMenu = new LoginMenu(input,massage,customerService, authHolder, loginSubmenu);
        SignupMenu signUpMenu = new SignupMenu(input,massage,customerService);

        menu = new Menu(input,massage,loginMenu,signUpMenu,mainMenu);

    }

    public static ApplicationContext getInstance(){
        return Instance;
    }

    public  Menu getMenu() {
        return menu;
    }
}
