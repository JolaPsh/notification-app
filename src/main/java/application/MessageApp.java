package application;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.LocalTime;
import java.util.Locale;
import java.util.ResourceBundle;
import static application.KeyMessage.*;
import static util.TimeUtil.*;

/**
 * Created by Joanna Pakosh on лист., 2018
 */
public class MessageApp {

    private static final Logger log = LogManager.getLogger(MessageApp.class);

    public static void main(String[] args) {
        Locale defaultLocale = Locale.getDefault();
        log.info("Default locale is {}:",  defaultLocale);

        ResourceBundle resourceBundle = ResourceBundle.getBundle("message", defaultLocale);
        String key = getKey(TIME_NOW);
        log.info("Part of the day, key : {}", key);
        log.info("MESSAGE : {}", resourceBundle.getString(key));

        System.out.println("------------------------------------------------------------------------------------"
                + "\n" +resourceBundle.getString(key)+"\n");
    }

    public static String getKey(LocalTime timeNow) {
        log.info(">> Current local time is {}", TIME_FORMATTER.format(timeNow));
        if (isBetween(timeNow, TIME_MORNING, TIME_DAY)) {
            return MORNING.getPartOfDay();
        } else if (isBetween(timeNow, TIME_DAY, TIME_EVENING)) {
            return DAY.getPartOfDay();
        } else if (isBetween(timeNow, TIME_EVENING, TIME_NIGHT)) {
            return EVENING.getPartOfDay();
        }  else {
            return NIGHT.getPartOfDay();}
    }
}
