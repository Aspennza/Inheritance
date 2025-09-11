//Need to:
//create WorkerTest.java & SalaryWorkerTest.java
//check if you need to override equals
//check if there's a way to have a second constructor for salaryworker

import java.util.ArrayList;

public class InheritanceDemo
{
    public static void main(String[] args)
    {
        ArrayList<Worker> workers = new ArrayList<>();

        Worker john = new Worker("000001", "John", "Doe", "Mr.", 1980, 25.00);
        Worker jane = new Worker("000002", "Jane", "Doe", "Ms.", 1979, 26.00);
        Worker sally = new Worker("000003", "Sally", "Williams", "Mrs.", 1985, 23.00);
    }
}