package AliceCompany;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StaticUtilsTest {

    @Test
    void givenStaticMethodWithNoArgs() {
        // Using try-with-resources to mock static methods
        try (MockedStatic<StaticUtils> utilities = Mockito.mockStatic(StaticUtils.class)) {
            // Adding a rule: return "Привет" when StaticUtils.name() is called
            utilities.when(StaticUtils::name).thenReturn("Привет");

            // Verifying that the rule works
            assertEquals("Привет", StaticUtils.name());
        }
    }
}
