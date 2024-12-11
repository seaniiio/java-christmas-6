package christmas.util;

import java.util.ArrayList;
import java.util.List;

public class Calender {

    // 첫 주말 날짜를 기반으로 해당 날짜가 주말인지 확인
    public static boolean isWeekend(int weekendStartDay, int day) {
        List<Integer> weekends = new ArrayList<>();
        int nowDay = weekendStartDay;
        while (nowDay <= 31) {
            weekends.add(nowDay);
            weekends.add(nowDay + 1);
            nowDay += 7;
        }

        return weekends.contains(day);
    }
}
