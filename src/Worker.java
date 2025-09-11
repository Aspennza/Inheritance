//Need to:
//finish main class
//create WorkerTest.java & SalaryWorkerTest.java
//create UML class diagrams
//check if you need to override equals
//check if there's a way to have a second constructor for salaryworker

public class Worker extends Person
{
    private double hourlyPayRate;

    public Worker(String ID, String firstName, String lastName, String title, int YOB, double hourlyPayRate)
    {
        super(ID, firstName, lastName, title, YOB);
        this.hourlyPayRate = hourlyPayRate;
    }

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
    public String toCSV()
    {
        return super.toCSV() + ", " + hourlyPayRate;
    }

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
