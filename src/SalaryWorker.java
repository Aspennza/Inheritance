//Need to:
//finish main class
//create WorkerTest.java & SalaryWorkerTest.java
//create UML class diagrams
//check if you need to override equals
//check if there's a way to have a second constructor for salaryworker

import java.util.Objects;

public class SalaryWorker extends Worker
{
    private double annualSalary;

    public SalaryWorker(String ID, String firstName, String lastName, String title, int YOB, double hourlyPayRate, double annualSalary)
    {
        super(ID, firstName, lastName, title, YOB, hourlyPayRate);
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

    @Override
    public String toCSV()
    {
        return super.toCSV() + ", " + annualSalary;
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
        retString += " " + DQ + "hourlyPayRate" + DQ + ":" + this.getHourlyPayRate() + ",";
        retString += " " + DQ + "annualSalary" + DQ + ":" + annualSalary + "}";

        return retString;
    }

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

    @Override
    public double calculateWeeklyPay(double hoursWorked)
    {
        double weeklyPay = 0.00;

        weeklyPay = annualSalary/52;

        return weeklyPay;
    }

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
