import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void shouldCalculateRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;
        long actual = service.calculate(1000_60, true);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1000000_60;
        boolean registered = true;
        long expected = 500;
        long actual = service.calculate(1000000_60, true);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateUnregisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1000000_60;
        boolean registered = false;
        long expected = 500;
        long actual = service.calculate(1000000_60, false);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateUnregisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000_60;
        boolean registered = false;
        long expected = 10;
        long actual = service.calculate(1000_60, false);
        assertEquals(expected, actual);
    }
}