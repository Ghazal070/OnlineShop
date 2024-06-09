package menu;

import menu.login.LoginMenu;
import menu.main.MainMenu;
import menu.signup.SignupMenu;
import menu.util.Input;
import menu.util.Massage;

public class Menu {
    private final Input INPUT;
    private final Massage MASSAGE;
    private final LoginMenu LOGIN_MENU;
    private final SignupMenu SIGNUP_MENU;
    private final MainMenu MAIN_MENU;

    public Menu(Input INPUT, Massage MASSAGE, LoginMenu LOGIN_MENU, SignupMenu SIGNUP_MENU, MainMenu MAIN_MENU) {
        this.INPUT = INPUT;
        this.MASSAGE = MASSAGE;
        this.LOGIN_MENU = LOGIN_MENU;
        this.SIGNUP_MENU = SIGNUP_MENU;
        this.MAIN_MENU = MAIN_MENU;

    }
    public void show(){
        System.out.println("Welcome to my program");
        while(true){
            MAIN_MENU.show();
            switch (INPUT.scanner.next()){
                case "1":{
                    SIGNUP_MENU.show();
                    break;}
                case "2":{
                    LOGIN_MENU.show();
                    break;}
                case "3":{
                    System.exit(0);
                    break;}
                default: System.out.println(Massage.getInvalidMassage());
            }
        }
    }

}

