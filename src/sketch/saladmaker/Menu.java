package mentor.salad.sketch.saladmaker;

/**
 * Created by Andriana_Yarmoliuk on 10/6/2016.
 */
public abstract class Menu {

    protected Menu currentMenu;
    protected Menu parentMenu;
    protected Menu nextMenu;
    protected Menu moveNextMenu;

    protected static String readedData;

    public final Menu getNext(){
        return moveNextMenu;
    }
    public abstract void display();
    public abstract void performAction(String action);

}
