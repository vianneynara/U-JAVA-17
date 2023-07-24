public class SmartKitchen {
    private Refrigerator refrigerator;
    private DishWasher dishWasher;
    private CoffeeMaker coffeeMaker;

    public SmartKitchen() {
        refrigerator = new Refrigerator();
        dishWasher = new DishWasher();
        coffeeMaker = new CoffeeMaker();
    }

    public SmartKitchen(Refrigerator refrigerator, DishWasher dishWasher, CoffeeMaker coffeeMaker) {
        this.refrigerator = refrigerator;
        this.dishWasher = dishWasher;
        this.coffeeMaker = coffeeMaker;
    }

    public Refrigerator getRefrigerator() {
        return refrigerator;
    }

    public DishWasher getDishWasher() {
        return dishWasher;
    }

    public CoffeeMaker getCoffeeMaker() {
        return coffeeMaker;
    }

    public void addWater() {
        coffeeMaker.brewCoffee();
    }
    public void pourMilk() {
        refrigerator.orderFood();
    }
    public void loadDishWasher() {
        dishWasher.doDishes();
    }
    public void setKitchenState(boolean coffeeMakerFlag, boolean refrigeratorFlag, boolean dishWasherFlag) {
        coffeeMaker.setHasWorkToDo(coffeeMakerFlag);
        refrigerator.setHasWorkToDo(refrigeratorFlag);
        dishWasher.setHasWorkToDo(dishWasherFlag);
    }
    public void doKitchenWork() {
        coffeeMaker.brewCoffee();
        refrigerator.orderFood();
        dishWasher.doDishes();
    }
}

class Refrigerator {
    private boolean hasWorkToDo;

    public Refrigerator() {}
    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

    public void orderFood() {
        if (hasWorkToDo) {
            System.out.println("Ordering food...");
            hasWorkToDo = false;
        }
    }
}
class DishWasher {
    private boolean hasWorkToDo;

    public DishWasher() {}
    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }
    public void doDishes() {
        if (hasWorkToDo) {
            System.out.println("Doing dishes...");
            hasWorkToDo = false;
        }
    }
}
class CoffeeMaker {
    private boolean hasWorkToDo;

    public CoffeeMaker() {}
    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }
    public void brewCoffee() {
        if (hasWorkToDo) {
            System.out.println("Brewing coffee...");
            hasWorkToDo = false;
        }
    }
}
