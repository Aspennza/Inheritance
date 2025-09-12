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
    void setFirstName() {
    }

    @Test
    void setLastName() {
    }

    @Test
    void setTitle() {
    }

    @Test
    void setYOB() {
    }

    @Test
    void fullName() {
    }

    @Test
    void formalName() {
    }

    @Test
    void getAge() {
    }

    @Test
    void testGetAge() {
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