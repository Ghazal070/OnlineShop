package menu.login;

import menu.util.Input;
import menu.util.Massage;
import service.CustomerService;
import util.AuthHolder;

public class LoginMenu {
    private final Input INPUT;
    private final Massage MASSAGE;
    private final CustomerService customerService;

    public LoginMenu(Input INPUT, Massage MASSAGE, CustomerService customerService) {
        this.INPUT = INPUT;
        this.MASSAGE = MASSAGE;
        this.customerService = customerService;
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
                    if(customerService.login(username,password)){MASSAGE.getSuccessfulMassage(username);
                        break login;}
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
