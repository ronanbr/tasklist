package br.com.tasklist.uteis;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

/**
 * Utilidades em Datas
 *
 * @author ronan.cardoso
 */
public class DateUtil {

    private DateUtil() {
    }

    public static boolean isSextaDepois13h() {
        LocalDateTime sexta13h = LocalDateTime.now().with(DayOfWeek.FRIDAY).withHour(13).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime now = LocalDateTime.now();

        return now.isAfter(sexta13h);
    }

}
