package AliceCompany;

import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class StringUtilsTest {
    @Test
    public void givenNumericString_whenIsNumeric_thenTrue() {
        String string = "12345";

        // Using Hamcrest to assert that the string is numeric
        assertThat(StringUtils.isNumeric(string), is(true));
    }

    @Test
    public void givenNonNumericString_whenIsNumeric_thenFalse() {
        String str = "123a45";

        // Using Hamcrest to assert that the string is not numeric
        assertThat(StringUtils.isNumeric(str), is(false));
    }

    @Test
    public void givenNullString_whenIsNumeric_thenFalse() {
        String str = null;

        // Using Hamcrest to assert that the string is null
        assertThat(StringUtils.isNumeric(str), is(false));
    }

    @Test
    public void givenString_whenCheckingProperties_thenCorrect() {
        String str = "12345";

        // Using Hamcrest to assert that the string is not empty and has a length of 5
        assertThat(str, is(not(emptyString())));
        assertThat(str.length(), is(5));
    }
}