package menu.login;

import menu.util.Input;
import menu.util.Massage;
import util.AuthHolder;

public class LoginMenu {
    private final Input INPUT;
    private final Massage MASSAGE;
    private final AuthHolder AUTH_HOLDER;
    private final LoginSubmenu LOGIN_SUBMENU;

    public LoginMenu(Input INPUT, Massage MASSAGE, AuthHolder auth_holder, LoginSubmenu login_submenu) {
        this.INPUT = INPUT;
        this.MASSAGE = MASSAGE;
        AUTH_HOLDER = auth_holder;
        LOGIN_SUBMENU = login_submenu;
    }

    public void show() {
        login:
        while (true) {
            System.out.println("""
                    1- Enter information
                    2- Previous Menu
                    """);
            switch (INPUT.scanner.next()) {
                case "1": {
                    System.out.println(MASSAGE.getInputMassage("username"));
                    String username = INPUT.scanner.next();
                    System.out.println(MASSAGE.getInputMassage("password"));
                    String password = INPUT.scanner.next();
                    //todo
                    System.out.println(MASSAGE.getInCorrectMessage());
                    break;
                }
                case "2": {
                    break login;
                }
                default:
                    System.out.println(Massage.getInvalidMassage());
            }
        }
    }
}
