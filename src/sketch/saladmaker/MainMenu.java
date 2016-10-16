package mentor.salad.sketch.saladmaker;

import java.util.ArrayList;
import java.util.List;

import static mentor.salad.sketch.saladmaker.Controller.readData;


/**
 * Created by Andriana_Yarmoliuk on 10/6/2016.
 */
public class MainMenu extends Menu{

    private static List<Salad> salads = new ArrayList<>();
    private Salad currentSalad;
    private Salad foundedSalad;

     public MainMenu(){
        currentMenu = this;
        parentMenu = this;
        nextMenu = this;
    }
    public Menu getMainMenuInstance(){
        return new MainMenu();
    }
    @Override
    public void display() {
        System.out.println("1 - print existed salads, 2 - create, 3 - switch to salad....");
    }
    public void performAction(String action){
        switch (action){
            case "1": printSalads(); return;
            case "2": createNewSalad(); return;
            case "3": switchToSalad(); return;
        }
    }
    private void printSalads(){
        for (Salad s:salads) {
            System.out.println(s.getName());
        }
    }
    private void createNewSalad(){
        System.out.println("please enter the name");
        readedData = readData();
        if (readedData.equals("smthng went wrong")) {
            System.out.println("please try again");//todo: via logger received from readData
            readedData = readData();
        }
        else if(findByName(readedData)) {
            System.out.println("this salad already exists"); //todo: via logger
            readedData = readData();
        }
        else {
            System.out.println("\"" + readedData + "\" salad was created");
            addSalad(new Salad(readedData));
            setCurretnSalad(salads.get(salads.size()-1));
            moveNextMenu = nextMenu;
        }
    }
    private void switchToSalad(){
        System.out.println("please enter salad name to switch");
        readedData = readData();
        if (readedData.equals("smthng went wrong")) {
            System.out.println("smthng went wrong, please try again");
            readedData = readData();
        }//todo: via logger received from readData
        else if (findByName(readedData)) {
            setCurretnSalad(foundedSalad);
            moveNextMenu = nextMenu;
        }
        else {
            System.out.println("it doesnt exist. please try again"); //todo: log4j
            readedData = readData();
        }
    }
    private void setCurretnSalad(Salad salad){
        currentSalad = salad;
    }
    private boolean findByName(String name){
        for (Salad s:salads) {
            if(name.equals(s.getName())) {
                foundedSalad = s;
                return true;
            }
        }
        return false;
    }
    private void addSalad(Salad salad){
        salads.add(salad);
    }
}
