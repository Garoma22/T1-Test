package ru.galkin.task.utils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.galkin.task.exception.InvalidInputException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class UtilsTest {

    @Test
    void testValidInputString() {
        String inputString = "abcd";
        assertEquals(inputString.toLowerCase(), Utils.checkInputString(inputString));
    }

    @Test
    void testInvalidInputString() {
        String inputString = "123";
        assertThrows(InvalidInputException.class, () -> {
            Utils.checkInputString(inputString);
        });
    }

    @Test
    void testEmptyInputString() {
        String inputString = "";
        assertEquals("", Utils.checkInputString(inputString));
    }
}
