import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the basic functionality of the functions in the SalaryWorker.java class.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
class SalaryWorkerTest {

    //A SalaryWorker object for testing the functions
    SalaryWorker worker1;

    //A SalaryWorker object for testing the functions
    SalaryWorker worker2;

    @BeforeEach
    void setUp() {
        worker1 = new SalaryWorker("000001", "John", "Doe", "Mr.", 1980, 35.00, 72800.00);
        worker2 = new SalaryWorker("000002", "Jane", "Doe", "Ms.", 1989, 36.00, 74880.00);
    }

    @Test
    void testSalaryWorkerConstructor1()
    {
        SalaryWorker worker3 = new SalaryWorker("000003", "Sally", "Williams", "Mrs.", 1979, 40.00, 83200.00);
        assertEquals("000003", worker3.getID());
        assertEquals("Sally", worker3.getFirstName());
        assertEquals("Williams", worker3.getLastName());
        assertEquals("Mrs.", worker3.getTitle());
        assertEquals(1979, worker3.getYOB());
        assertEquals(40.00, worker3.getHourlyPayRate());
        assertEquals(83200.00, worker3.getAnnualSalary());
    }

    @Test
    void testSalaryWorkerConstructor2()
    {
        Worker worker3 = new Worker("000003", "Sally", "Williams", "Mrs.", 1979, 40.00);
        SalaryWorker worker4 = new SalaryWorker(worker3, 83200.00);
        assertEquals("000003", worker4.getID());
        assertEquals("Sally", worker4.getFirstName());
        assertEquals("Williams", worker4.getLastName());
        assertEquals("Mrs.", worker4.getTitle());
        assertEquals(1979, worker4.getYOB());
        assertEquals(40.00, worker4.getHourlyPayRate());
        assertEquals(83200.00, worker4.getAnnualSalary());
    }

    @Test
    void setHourlyPayRate() {
        worker1.setHourlyPayRate(25.00);
        assertEquals(25.00, worker1.getHourlyPayRate());
    }

    @Test
    void setFirstName() {
        worker1.setFirstName("Sally");
        assertEquals("Sally", worker1.getFirstName());
    }

    @Test
    void setLastName() {
        worker1.setLastName("Williams");
        assertEquals("Williams", worker1.getLastName());
    }

    @Test
    void setTitle() {
        worker1.setTitle("Mrs.");
        assertEquals("Mrs.", worker1.getTitle());
    }

    @Test
    void setYOB() {
        worker1.setYOB(1979);
        assertEquals(1979, worker1.getYOB());
    }

    @Test
    void fullName() {
        assertEquals("John Doe", worker1.fullName());
    }

    @Test
    void formalName() {
        assertEquals("Mr. John Doe", worker1.formalName());
    }

    @Test
    void getAge() {
        assertEquals("45", worker1.getAge());
    }

    @Test
    void testGetAge() {
        assertEquals("20", worker1.getAge(2000));
    }

    @Test
    void setAnnualSalary() {
        worker1.setAnnualSalary(70000.00);
        assertEquals(70000.00, worker1.getAnnualSalary());
    }

    @Test
    void testToString() {
        assertEquals("Person{ID='000001', firstName='John', lastName='Doe', title='Mr.', YOB=1980}Worker{hourlyPayRate=35.0}SalaryWorker{annualSalary=72800.0}", worker1.toString());
    }

    @Test
    void testEquals() {
        assertTrue(worker1.equals(worker1));
        assertFalse(worker2.equals(worker1));
    }

    @Test
    void testHashCode() {
        assertEquals(2071751458, worker1.hashCode());
    }

    @Test
    void toCSV() {
        assertEquals("000001, John, Doe, Mr., 1980, 35.0, 72800.0", worker1.toCSV());
    }

    @Test
    void toJSON() {
        assertEquals("{\"IDNum\":\"000001\", \"firstName\":\"John\", \"lastName\":\"Doe\", \"title\":\"Mr.\", \"YOB\":1980, \"hourlyPayRate\":35.0, \"annualSalary\":72800.0}", worker1.toJSON());
    }

    @Test
    void toXML() {
        assertEquals("<SalaryWorker><IDNum>000001</IDNum><firstName>John</firstName><lastName>Doe</lastName><title>Mr.</title><YOB>1980</YOB><hourlyPayRate>35.0</hourlyPayRate><annualSalary>72800.0</annualSalary></SalaryWorker>", worker1.toXML());
    }

    @Test
    void calculateWeeklyPay() {
        assertEquals(1400, worker1.calculateWeeklyPay(40));
    }
}