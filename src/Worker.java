import java.util.Objects;

/**
 * Creates Worker objects containing all the criteria from Person but adding an hourlyPayRate.
 * Also includes functions for acting on said objects.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class Worker extends Person
{
    //This double holds the hourly pay rate for each Worker object
    private double hourlyPayRate;

    //This constructor creates Worker objects through manually inputting all the necessary data
    public Worker(String ID, String firstName, String lastName, String title, int YOB, double hourlyPayRate)
    {
        super(ID, firstName, lastName, title, YOB);
        this.hourlyPayRate = hourlyPayRate;
    }

    //This constructor creates Worker objects given an existing Person and an hourly pay rate
    public Worker(Person person, double hourlyPayRate)
    {
        super(person.getID(),
                person.getFirstName(),
                person.getLastName(),
                person.getTitle(),
                person.getYOB());
        this.hourlyPayRate = hourlyPayRate;
    }

    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    public void setHourlyPayRate(double hourlyPayRate) {
        this.hourlyPayRate = hourlyPayRate;
    }

    @Override
    public String toString() {
        return super.toString() + "Worker{" +
                "hourlyPayRate=" + hourlyPayRate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Worker worker = (Worker) o;
        return getYOB() == worker.getYOB() && Objects.equals(getID(), worker.getID()) && Objects.equals(getFirstName(), worker.getFirstName()) && Objects.equals(getLastName(), worker.getLastName()) && Objects.equals(getTitle(), worker.getTitle()) && hourlyPayRate == worker.hourlyPayRate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hourlyPayRate);
    }

    /**
     * Takes the content of a Worker object and converts it into a CSV format.
     * @return a String containing a comma-separated list of personal traits.
     */
    @Override
    public String toCSV()
    {
        return super.toCSV() + ", " + hourlyPayRate;
    }

    /**
     * Takes the content of a Worker object and converts it into a JSON format.
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
        retString += " " + DQ + "hourlyPayRate" + DQ + ":" + hourlyPayRate + "}";

        return retString;
    }

    /**
     * Takes the content of a Worker object and converts it into XML format.
     * @return a String containing personal traits listed in the XML format.
     */
    @Override
    public String toXML()
    {
        String retString = "";
        retString = "<Worker>";
        retString += "<IDNum>" + this.getID() + "</IDNum>";
        retString += "<firstName>" + this.getFirstName() + "</firstName>";
        retString += "<lastName>" + this.getLastName() + "</lastName>";
        retString += "<title>" + this.getTitle() + "</title>";
        retString += "<YOB>" + this.getYOB() + "</YOB>";
        retString += "<hourlyPayRate>" + hourlyPayRate + "</hourlyPayRate></Worker>";

        return retString;
    }

    /**
     * Calculates a Worker's weekly pay based on their hours worked and their hourly wage. Calculates overtime at 1.5 times regular pay.
     * @param hoursWorked   The number of hours a Worker worked in a week.
     * @return    The amount of money a Worker was paid in a week.
     */
    public double calculateWeeklyPay(double hoursWorked)
    {
        double weeklyPay = 0.00;
        double payRegularRate = 0.00;
        double payOvertime = 0.00;
        double hoursAtRegularRate = 0.00;
        double hoursOvertime = 0.00;

            if(hoursWorked <= 40)
            {
                weeklyPay = hoursWorked * hourlyPayRate;
            } else
            {
                hoursAtRegularRate = 40.0;
                hoursOvertime = hoursWorked - hoursAtRegularRate;

                payRegularRate = hoursAtRegularRate * hourlyPayRate;
                payOvertime = hoursOvertime * (hourlyPayRate * 1.5);
                weeklyPay = payRegularRate + payOvertime;
            }
        return weeklyPay;
    }

    /**
     * Calculates and displays to the console a Worker's regular hours, regular pay, overtime hours, overtime pay, and total pay in a week.
     * @param hoursWorked    The number of hours a Worker worked in a week.
     */
    public void displayWeeklyPay(double hoursWorked)
    {
        double hoursAtRegularRate = 0.00;
        double hoursOvertime = 0.00;
        double payRegularRate = 0.00;
        double payOvertime = 0.00;
        double combinedPay = 0.00;

        if(hoursWorked <= 40)
        {
            hoursAtRegularRate = hoursWorked;
            hoursOvertime = 0.0;

            payRegularRate = hoursAtRegularRate * hourlyPayRate;
            payOvertime = 0.00;
            combinedPay = payRegularRate + payOvertime;
        } else
        {
            hoursAtRegularRate = 40.0;
            hoursOvertime = hoursWorked - hoursAtRegularRate;

            payRegularRate = hoursAtRegularRate * hourlyPayRate;
            payOvertime = hoursOvertime * (hourlyPayRate * 1.5);
            combinedPay = payRegularRate + payOvertime;
        }

        System.out.println("Hours Regular Pay          Regular Pay Total          Hours Overtime          Overtime Pay Total          Combined Pay");
        System.out.println("======================================================================================================================");

        System.out.printf("%-27s%-27f%-24s%-28f%6f", hoursAtRegularRate, payRegularRate, hoursOvertime, payOvertime, combinedPay);
    }
}
