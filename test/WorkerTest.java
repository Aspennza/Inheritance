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
        worker1.setHourlyPayRate(25.00);
        assertEquals(25.00, worker1.getHourlyPayRate());
    }

    @Test
    void testToString() {
        assertEquals("Person{ID='000001', firstName='John', lastName='Doe', title='Mr.', YOB=1980}Worker{hourlyPayRate=20.0}", worker1.toString());
    }

    @Test
    void testEquals() {
        assertTrue(worker1.equals(worker1));
        assertFalse(worker2.equals(worker1));
    }

    @Test
    void testHashCode() {
        assertEquals(-523391361, worker1.hashCode());
    }

    @Test
    void toCSV() {
        assertEquals("000001, John, Doe, Mr., 1980, 20.0", worker1.toCSV());
    }

    @Test
    void toJSON() {
        assertEquals("{\"IDNum\":\"000001\", \"firstName\":\"John\", \"lastName\":\"Doe\", \"title\":\"Mr.\", \"YOB\":1980, \"hourlyPayRate\":20.0}", worker1.toJSON());
    }

    @Test
    void toXML() {
        assertEquals("<Worker><IDNum>000001</IDNum><firstName>John</firstName><lastName>Doe</lastName><title>Mr.</title><YOB>1980</YOB><hourlyPayRate>20.0</hourlyPayRate></Worker>", worker1.toXML());
    }

    @Test
    void calculateWeeklyPay() {
        assertEquals(800.00, worker1.calculateWeeklyPay(40));
        assertEquals(1100.00, worker1.calculateWeeklyPay(50));
    }
}