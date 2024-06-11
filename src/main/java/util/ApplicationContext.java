package util;

import config.DataSource;
import menu.Menu;
import menu.login.LoginMenu;
import menu.login.LoginSubmenu;
import menu.main.MainMenu;
import menu.signup.SignupMenu;
import menu.util.Input;
import menu.util.Massage;
import repository.CustomerRepository;
import repository.impl.CustomerRepositoryImpl;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

import java.sql.Connection;

public class ApplicationContext {
    private final static ApplicationContext Instance = new ApplicationContext();
    private Menu menu;

    private ApplicationContext() {
        Connection connection = DataSource.getConnection();
        AuthHolder authHolder = new AuthHolder();
        Input input = new Input();
        Massage massage = new Massage();
        MainMenu mainMenu = new MainMenu();
        LoginSubmenu loginSubmenu = new LoginSubmenu(input,massage);
        CustomerRepository customerRepository = new CustomerRepositoryImpl(connection);
        CustomerService customerService =new CustomerServiceImpl(customerRepository,authHolder);
        LoginMenu loginMenu = new LoginMenu(input,massage,customerService);
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
