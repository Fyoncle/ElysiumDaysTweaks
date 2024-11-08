package net.fyoncle.elysiumdaystweaks.utility.other;

import java.util.Calendar;

public class HolidayChecker {
    private static Calendar calendar;
    public static boolean isChristmas() {
        calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH) == Calendar.DECEMBER &&
                (calendar.get(Calendar.DAY_OF_MONTH) >= 24 && calendar.get(Calendar.DAY_OF_MONTH) <= 26);
    }
    public static boolean isHalloween() {
        calendar = Calendar.getInstance();
        if (calendar.get(Calendar.MONTH) != Calendar.OCTOBER) return false;
        calendar.get(Calendar.DAY_OF_MONTH);
        return calendar.get(Calendar.DAY_OF_MONTH) <= 31;
    }
}
