package challenges.worker;

public class WorkerMain {
    public static void main(String[] args) {
        // Generic parent Employee object test
        Employee genericEmployee = new Employee(
                "genericName",
                "dd/mm/2000",
                "dd/mm/2021"
        );
        genericEmployee.terminate("dd/mm/2031");
        System.out.println(genericEmployee);
        System.out.println("Age: " + genericEmployee.getAge());
        System.out.println("_ _ _ _");

        // Salaried Employee test
        SalariedEmployee mark = new SalariedEmployee(
                "Mark",
                "12/09/1990",
                "02/07/2022",
                75000
        );
        mark.terminate("02/07/2032");
        System.out.println(mark);
        System.out.println("Age: " + mark.getAge());
        System.out.println("paycheck -> " + mark.collectPay());
        mark.retire();
        System.out.println("pension check -> " + mark.collectPay());
        System.out.println("_ _ _ _");

        // Hourly Employee test
        HourlyEmployee jonah = new HourlyEmployee(
                "Mark",
                "01/05/1995",
                "06/07/2020",
                35
        );
        jonah.terminate("06/07/2030");
        System.out.println(jonah);
        System.out.println("Age: " + jonah.getAge());
        System.out.println("paycheck -> " + jonah.collectPay());
        System.out.println("2x paycheck -> " + jonah.getDoublePay());
        System.out.println("_ _ _ _");
    }
}
