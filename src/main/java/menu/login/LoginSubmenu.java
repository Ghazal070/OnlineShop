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
                    1- Add product 
                    2- Remove product
                    3- Print All Product
                    4- Print price of your cart
                    5- Exit
                    """);
            switch (INPUT.scanner.next()){
                case "1":{
                    System.out.println("""
                            Enter one of the following options
                            1- Electronic appliances 
                            2- Shoes
                            3- Previous Menu
                                    """);
                    switch(INPUT.scanner.next()){
                        case "1":{
                            System.out.println("""
                                    1- Radio
                                    2- Television
                                    """);
                            switch (INPUT.scanner.next()){

                            }
                        }
                        case "2":{
                            //todo
                            break;
                        }
                    }

                    break;}
                case "2":{
                    //todo
                    break;
                }
                case "5":{System.exit(0);}
                default: System.out.println(MASSAGE.getInvalidMassage());
            }

        }
    }
}
