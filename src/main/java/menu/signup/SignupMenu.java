package menu.signup;

import menu.util.Input;
import menu.util.Massage;
import service.CustomerService;

public class SignupMenu {
    private final Input INPUT;
    private final Massage MASSAGE;

    private final CustomerService customerService;

    public SignupMenu(Input INPUT, Massage MASSAGE,CustomerService customerService) {
        this.INPUT = INPUT;
        this.MASSAGE = MASSAGE;
        this.customerService=customerService;
    }

    public void show() {

        signupMenu:
        while (true) {
            System.out.println("""
                    1- Enter information
                    2- Previous Menu
                    """);
            switch (INPUT.scanner.next()) {
                case "1": {
                    System.out.println(MASSAGE.getInputMassage("your information"));
                    System.out.println(MASSAGE.getInputMassage("username"));
                    String username = INPUT.scanner.next();
                    System.out.println(MASSAGE.getInputMassage("password"));
                    String password = INPUT.scanner.next();
                    if(customerService.signUp(username,password)){MASSAGE.getSuccessfulMassage(username);
                    break signupMenu;}
                    System.out.println(MASSAGE.getExistMassage(username));
                }
                case "2": {
                    break signupMenu;
                }
                default:
                    System.out.println(MASSAGE.getInvalidMassage());
            }

        }
    }
}
