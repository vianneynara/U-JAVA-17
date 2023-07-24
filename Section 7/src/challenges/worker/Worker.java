package challenges.worker;

public class Worker {
    protected int currentYear = 2023;
    private String name;
    private String birthDate;
    protected String endDate;

    public Worker(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getAge() {
        return (currentYear - Integer.parseInt(birthDate.substring(6)));
    }

    public double collectPay() {
        return 0.0;
    }

    public void terminate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}

class Employee extends Worker {
    private long employeeId;
    private String hireDate;
    private static int employeeNo = 10000;

    public Employee(String name, String birthDate, String hireDate) {
        super(name, birthDate);
        this.employeeId = employeeNo++;
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", hireDate='" + hireDate + '\'' +
                "} " + super.toString();
    }
}

class SalariedEmployee extends Employee {
    private double annualSalary;
    private boolean isRetired = false;

    public SalariedEmployee(String name, String birthDate, String hireDate, double annualSalary) {
        super(name, birthDate, hireDate);
        this.annualSalary = annualSalary;
    }

    public void retire() {
        terminate("12/12/" + currentYear);
        isRetired = true;
        System.out.println("Mark has been retired");
    }

    @Override
    public double collectPay() {
        double payCheck = annualSalary/26;
        double adjustedPay = (isRetired) ? 0.9 * payCheck : payCheck;
        return ((int) adjustedPay);
    }
}

class HourlyEmployee extends Employee {
    private double hourlyPayRate;

    public HourlyEmployee(String name, String birthDate, String hireDate, double hourlyPayRate) {
        super(name, birthDate, hireDate);
        this.hourlyPayRate = hourlyPayRate;
    }

    public double getDoublePay() {
        return (2 * collectPay());
    }

    @Override
    public double collectPay() {
        return (40 * hourlyPayRate);
    }
}