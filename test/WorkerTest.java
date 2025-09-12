import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {

    Worker worker1;
    Worker worker2;

    @BeforeEach
    void setUp() {
        worker1 = new Worker("000001","John", "Doe", "Mr.", 1980, 20.00);
        worker2 = new Worker("000002", "Jane", "Doe", "Ms.", 1985, 23.00);
    }

    @Test
    void testWorkerConstructor1()
    {
        Worker worker3 = new Worker("000003", "Sally", "Williams", "Mrs.", 1979, 30.00);
        assertEquals("000003", worker3.getID());
        assertEquals("Sally", worker3.getFirstName());
        assertEquals("Williams", worker3.getLastName());
        assertEquals("Mrs.", worker3.getTitle());
        assertEquals(1979, worker3.getYOB());
        assertEquals(30.00, worker3.getHourlyPayRate());
    }

    @Test
    void testWorkerConstructor2()
    {
        Person person1 = new Person("000001", "Sally", "Williams", "Mrs.", 1979);
        Worker worker3 = new Worker(person1, 30.00);
        assertEquals("000001", worker3.getID());
        assertEquals("Sally", worker3.getFirstName());
        assertEquals("Williams", worker3.getLastName());
        assertEquals("Mrs.", worker3.getTitle());
        assertEquals(1979, worker3.getYOB());
        assertEquals(30.00, worker3.getHourlyPayRate());
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
    void setHourlyPayRate() {
    }

    @Test
    void testToString() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void toCSV() {
    }

    @Test
    void toJSON() {
    }

    @Test
    void toXML() {
    }

    @Test
    void calculateWeeklyPay() {
    }

    @Test
    void displayWeeklyPay() {
    }
}