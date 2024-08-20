package AliceCompany;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CalculatorTest {
    @Test
    public void addtest() {
        Calculator calc = new Calculator();
        int result = calc.add(2, 3);
        assertEquals(5, result);
    }

    @Test
    public void subtest() {
        Calculator calc = new Calculator();
        int result = calc.sub(8, 3);
        assertEquals(5, result);
    }

    @Test
    public void mul() {
        Calculator calc = new Calculator();
        int result = calc.mul(-5, -3);
        assertEquals(15, result);
    }

    @Test
    public void div() {
        Calculator calc = new Calculator();
        int result = calc.div(2, 3);
        assertEquals(0, result);
    }
}
