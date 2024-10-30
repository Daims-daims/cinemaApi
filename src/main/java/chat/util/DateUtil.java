package chat.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static boolean isDateInInterval(Date dateToTest, Date startDate, Integer minuteInterval){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.MINUTE,minuteInterval);

        return startDate.before(dateToTest) && dateToTest.before(calendar.getTime());
    }
}
