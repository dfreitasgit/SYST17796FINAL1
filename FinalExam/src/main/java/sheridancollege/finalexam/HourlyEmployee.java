package sheridancollege.finalexam;

/* This class outlines the base class of the hourly employee to be extended
 *  by the commissioned employee class later.
 *
 * @author David Freitas
 */

public class HourlyEmployee {
    
    private String name;
    private int id;
    private double salary;
    
    public HourlyEmployee() {}
        
    public HourlyEmployee(String givenName, int employeeId, double salaryPay) {
        name = givenName;
        id = employeeId;
        salary = salaryPay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public double calculatePay(HourlyEmployee employee, int hoursWorked) {
        return employee.getSalary() * hoursWorked;
    }
}