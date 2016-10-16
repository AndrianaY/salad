package salad.sketch.saladmaker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Andriana on 06.10.2016.
 */
public class Controller {
    private Menu currentControllerMenu = new MainMenu();

    public Controller(Menu menu){
        currentControllerMenu = menu;
    }
    public void displayControllerEntryPoint(){
        currentControllerMenu.display();
    }

    public void performMenuAction(String action){
        currentControllerMenu.performAction(action);
        goToNextControllerMenu();
        displayControllerMenu();
    }
    private void goToNextControllerMenu(){
        currentControllerMenu = currentControllerMenu.getNext();
    }

    private void displayControllerMenu(){
        currentControllerMenu.display();
    }
    public static String readData(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            return  br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "smthng went wrong"; //todo: via logger
    }


}
