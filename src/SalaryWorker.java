import java.util.Objects;

/**
 * Creates SalaryWorker objects containing all the criteria from Worker but adding an annualSalary.
 * Also includes functions for acting on said objects.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class SalaryWorker extends Worker
{
    //This double stores the annual salary for each SalaryWorker object
    private double annualSalary;

    //This constructor creates SalaryWorker objects through manually inputting all the necessary data
    public SalaryWorker(String ID, String firstName, String lastName, String title, int YOB, double hourlyPayRate, double annualSalary)
    {
        super(ID, firstName, lastName, title, YOB, hourlyPayRate);
        this.annualSalary = annualSalary;
    }

    //This constructor creates SalaryWorker objects given an existing Worker and an hourly pay rate
    public SalaryWorker(Worker worker, double annualSalary)
    {
        super(worker.getID(),
                worker.getFirstName(),
                worker.getLastName(),
                worker.getTitle(),
                worker.getYOB(),
                worker.getHourlyPayRate());
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    @Override
    public String toString() {
        return super.toString() + "SalaryWorker{" +
                "annualSalary=" + annualSalary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SalaryWorker that = (SalaryWorker) o;
        return getYOB() == that.getYOB() && Objects.equals(getID(), that.getID()) && Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(getTitle(), that.getTitle()) && getHourlyPayRate() == that.getHourlyPayRate() && annualSalary == that.annualSalary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), annualSalary);
    }

    /**
     * Takes the content of a SalaryWorker object and converts it into a CSV format.
     * @return a String containing a comma-separated list of personal traits.
     */
    @Override
    public String toCSV()
    {
        return super.toCSV() + ", " + annualSalary;
    }

    /**
     * Takes the content of a SalaryWorker object and converts it into a JSON format.
     * @return a String containing personal traits listed in the JSON format.
     */
    @Override
    public String toJSON()
    {
        String retString = "";
        char DQ = '\u0022';
        retString = "{" + DQ + "IDNum" + DQ + ":" + DQ + this.getID() + DQ + ",";
        retString += " " + DQ + "firstName" + DQ + ":" + DQ + this.getFirstName() + DQ + ",";
        retString += " " + DQ + "lastName" + DQ + ":" + DQ + this.getLastName() + DQ + ",";
        retString += " " + DQ + "title" + DQ + ":" + DQ + this.getTitle() + DQ + ",";
        retString += " " + DQ + "YOB" + DQ + ":" + this.getYOB() + ",";
        retString += " " + DQ + "hourlyPayRate" + DQ + ":" + this.getHourlyPayRate() + ",";
        retString += " " + DQ + "annualSalary" + DQ + ":" + annualSalary + "}";

        return retString;
    }

    /**
     * Takes the content of a SalaryWorker object and converts it into XML format.
     * @return a String containing personal traits listed in the XML format.
     */
    @Override
    public String toXML()
    {
        String retString = "";
        retString = "<SalaryWorker>";
        retString += "<IDNum>" + this.getID() + "</IDNum>";
        retString += "<firstName>" + this.getFirstName() + "</firstName>";
        retString += "<lastName>" + this.getLastName() + "</lastName>";
        retString += "<title>" + this.getTitle() + "</title>";
        retString += "<YOB>" + this.getYOB() + "</YOB>";
        retString += "<hourlyPayRate>" + this.getHourlyPayRate() + "</hourlyPayRate>";
        retString += "<annualSalary>" + annualSalary + "</annualSalary></SalaryWorker>";

        return retString;
    }

    /**
     * Calculates a SalaryWorker's weekly pay by dividing their annual salary by 52 weeks.
     * @param hoursWorked   The number of hours a SalaryWorker worked in a week.
     * @return    The amount of money a SalaryWorker was paid in a week.
     */
    @Override
    public double calculateWeeklyPay(double hoursWorked)
    {
        double weeklyPay = 0.00;

        weeklyPay = annualSalary/52;

        return weeklyPay;
    }

    /**
     * Calculates and prints a SalaryWorker's weekly pay to the console in a tabular format.
     * @param hoursWorked    The number of hours a SalaryWorker worked in a week.
     */
    @Override
    public void displayWeeklyPay(double hoursWorked)
    {
        double weeklyPay = 0.00;

        weeklyPay = annualSalary/52;

        System.out.println("Weekly Pay (fraction of yearly salary)");
        System.out.println("======================================");

        System.out.printf("%-38f", weeklyPay);
    }
}
