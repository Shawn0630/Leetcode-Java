import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class LetterCombinationsPhoneNumberTest {
    LetterCombinationsPhoneNumber lcpn = new LetterCombinationsPhoneNumber();

    @Test
    public void test1() {
        assertThat(lcpn.letterCombinations("23"), containsInAnyOrder("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"));
    }
}
