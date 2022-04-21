package sheridancollege.finalexam;

/* This class extends the HourlyEmployee class to add an employee class that
 *  also receives commission.
 *
 * @author David Freitas
 */

public class HourlyPlusCommissionEmployee extends HourlyEmployee {
    
    private double commission;
    
    public HourlyPlusCommissionEmployee() {}
    
    public HourlyPlusCommissionEmployee(String givenName, int employeeId, double salaryPay,
            double commissionEarned) {
        super(givenName, employeeId, salaryPay);
        commission = commissionEarned;
    }
    
    public double calculatePay(HourlyPlusCommissionEmployee employee, int hoursWorked,
            double commissionEarned) {
        return employee.getSalary() * hoursWorked + commissionEarned;
    }
}