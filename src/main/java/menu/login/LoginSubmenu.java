package menu.login;

import menu.util.Input;
import menu.util.Massage;

public class LoginSubmenu {
    private final Input INPUT;
    private final Massage MASSAGE;


    public LoginSubmenu(Input INPUT, Massage MASSAGE) {
        this.INPUT = INPUT;
        this.MASSAGE = MASSAGE;
    }

    public void show(){
        while (true){
            System.out.println("""
                    Enter one of the following options
                    1- Product one type  
                    2- Product two type
                    3- Exit
                    """);
            switch (INPUT.scanner.next()){
                case "1":{
                    //todo
                    break;}
                case "2":{
                    //todo
                    break;
                }
                case "3":{System.exit(0);}
                default: System.out.println(MASSAGE.getInvalidMassage());
            }

        }
    }
}
