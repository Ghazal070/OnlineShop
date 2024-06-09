package util;

import config.DataSource;
import menu.Menu;
import menu.login.LoginMenu;
import menu.login.LoginSubmenu;
import menu.main.MainMenu;
import menu.signup.SignupMenu;
import menu.util.Input;
import menu.util.Massage;

import java.sql.Connection;

public class ApplicationContext {
    private final static ApplicationContext Instance = new ApplicationContext();
    private static Menu menu;

    private ApplicationContext() {
        Connection connection = DataSource.getConnection();
        AuthHolder authHolder = new AuthHolder();
        Input input = new Input();
        Massage massage = new Massage();
        MainMenu mainMenu = new MainMenu();
        LoginSubmenu loginSubmenu = new LoginSubmenu(input,massage);
        LoginMenu loginMenu = new LoginMenu(input,massage,authHolder,loginSubmenu);
        SignupMenu signUpMenu = new SignupMenu(input,massage);

        menu = new Menu(input,massage,loginMenu,signUpMenu,mainMenu);

    }

    public static ApplicationContext getInstance(){
        return Instance;
    }

    public static Menu getMenu() {
        return menu;
    }
}
