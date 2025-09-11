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
        int hoursAtRegularRate = 0;
        double hoursOvertime = 0;

            if (hoursWorked <= 40)
            {
                weeklyPay = hoursWorked * hourlyPayRate;
            } else
            {
                hoursAtRegularRate = 40;
                hoursOvertime = hoursWorked - hoursAtRegularRate;

                payRegularRate = hoursAtRegularRate * hourlyPayRate;
                payOvertime = hoursOvertime * (hourlyPayRate * 1.5);
                weeklyPay = payRegularRate + payOvertime;
            }
        return weeklyPay;
    }
}
