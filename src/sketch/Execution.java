package mentor.salad.sketch;

import mentor.salad.sketch.saladmaker.Controller;
import mentor.salad.sketch.saladmaker.MainMenu;

import static mentor.salad.sketch.saladmaker.Controller.readData;

/**
 * Created by Andriana_Yarmoliuk on 10/7/2016.
 */
public class Execution {
    protected static Controller mc = new Controller(new MainMenu());

    public static void main(String[] args) {
        mc.displayControllerEntryPoint();
        String readedData = readData();
        while(!readedData.equals("exit")){
            mc.performMenuAction(readedData);
            readedData = readData();
        }
    }
}
