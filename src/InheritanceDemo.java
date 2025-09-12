//Need to:
//create WorkerTest.java & SalaryWorkerTest.java
//create UML class diagrams
//check if you need to override equals
//check if there's a way to have a second constructor for salaryworker

import java.util.ArrayList;

public class InheritanceDemo
{
    public static void main(String[] args)
    {
        ArrayList<Worker> workers = new ArrayList<>();
        int week = 0;
        int hoursWorked = 0;

        Worker john = new Worker("000001", "John", "Doe", "Mr.", 1980, 25.00);
        Worker jane = new Worker("000002", "Jane", "Doe", "Ms.", 1979, 26.00);
        Worker sally = new Worker("000003", "Sally", "Williams", "Mrs.", 1985, 23.00);

        SalaryWorker bella = new SalaryWorker("000004", "Bella", "Goth", "Mrs.", 2000, 40.00, 83200.00);
        SalaryWorker johnny = new SalaryWorker("000005", "Johnny", "Zest", "Mr.", 2003, 37.00, 76960.00);
        SalaryWorker nancy = new SalaryWorker("000006", "Nancy", "Landgraab", "Mrs.", 2000, 41.00, 85280.00);

        workers.add(john);
        workers.add(jane);
        workers.add(sally);
        workers.add(bella);
        workers.add(johnny);
        workers.add(nancy);

        System.out.println("\nWeek        John's Pay        Jane's Pay        Sally's Pay        Bella's Pay        Johnny's Pay        Nancy's Pay");
        System.out.print("=====================================================================================================================");

        do {
            if(week == 0)
            {
                hoursWorked = 40;
            }else if(week == 1)
            {
                hoursWorked = 50;
            } else
            {
                hoursWorked = 40;
            }

            int printWeek = week + 1;

            System.out.printf("\n%-12d%-18f%-18f%-19f%-19f%-20f%11f", printWeek, john.calculateWeeklyPay(hoursWorked), jane.calculateWeeklyPay(hoursWorked), sally.calculateWeeklyPay(hoursWorked), bella.calculateWeeklyPay(hoursWorked), johnny.calculateWeeklyPay(hoursWorked), nancy.calculateWeeklyPay(hoursWorked));

            week++;
        }while(week < 3);
    }
}