package mentor.salad.sketch.saladmaker;

/**
 * Created by Andriana_Yarmoliuk on 10/6/2016.
 */
public class SaladMenu extends Menu{
    private Salad salad;

    private SaladMenu(Salad salad){
        this.salad = salad;
        currentMenu = this;
        parentMenu = this;
        nextMenu = this;
    }
    public static Menu getSaladMenuInstance(Salad salad){
        return new SaladMenu(salad);
    }
    @Override
    public void display() {
        System.out.println("currently working with " + salad.getName() + " salad");
        System.out.println("1- return to main menu, 2 - go to choosing ingredients, 3 - make salad, 4 - sort salad, 5 - calc calories.....");
    }
    @Override
    public void performAction(String action) {
        switch (action){
            case "1": toMainMenu(); return;
            case "2": goToIngredients(); return;
            case "3": makeSalad(); return;
        }
    }
    private void toMainMenu(){
        moveNextMenu = parentMenu;
    }
    private void goToIngredients(){
        moveNextMenu = nextMenu;
    }
    private void makeSalad(){
        salad.makeSalad();
    }

}
