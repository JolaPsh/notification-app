package application;

import static application.TestData.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Joanna Pakosh on лист, 2018
 */
@ExtendWith(TimingExtension.class)
class MessageAppTest {

    @Test
    public void testMorning() {
        assertEquals(MessageApp.getKey(TIME_1), "morning");
    }

    @Test
    public void testMorningInvalid() {
        assertNotEquals(MessageApp.getKey(TIME_4), "day");
    }

    @Test
    public void testDay() {
        assertEquals(MessageApp.getKey(TIME_3), "day");
    }

    @Test
    public void testDayInvalid() {
        assertNotEquals(MessageApp.getKey(TIME_2), "morning");
    }

    @Test
    public void testEvening() {
        assertEquals(MessageApp.getKey(TIME_4), "evening");
    }

    @Test
    public void testEveningInvalid() {
        assertNotEquals(MessageApp.getKey(TIME_3), "evening");
    }

    @Test
    public void testNight() {
        assertEquals(MessageApp.getKey(TIME_5), "night");
    }

    @Test
    public void testNightInvalid() {
        assertNotEquals(MessageApp.getKey(TIME_3), "night");
    }

    @Test
    public void testResourceBundleExists() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message", Locale.getDefault());
        assertNotNull(resourceBundle);
    }
}
