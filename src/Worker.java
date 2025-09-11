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

        System.out.printf("\n%-27s%-27f%-24s%-28f%6f", hoursAtRegularRate, payRegularRate, hoursOvertime, payOvertime, combinedPay);
    }
}
