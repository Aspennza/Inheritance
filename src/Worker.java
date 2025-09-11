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
}
