public class Main {
    public static void main(String[] args) {
        SmartKitchen smartKitchen = new SmartKitchen();

        smartKitchen.getCoffeeMaker().setHasWorkToDo(true);
        smartKitchen.getDishWasher().setHasWorkToDo(true);
        smartKitchen.doKitchenWork();

        smartKitchen.setKitchenState(true, true, true);
        smartKitchen.doKitchenWork();
    }
}
