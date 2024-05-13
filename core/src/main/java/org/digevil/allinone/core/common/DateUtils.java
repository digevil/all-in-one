package org.digevil.allinone.core.common;

import java.time.OffsetDateTime;

public class DateUtils {

    public static long convertGMT2Epoch(String gmtDatetimeStr) {
        // GMT time string
        String gmtTimeString = "2024-05-09T16:09:35-06:00";
        // Parse the GMT time string into an OffsetDateTime object
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(gmtTimeString);
        // Get the epoch timestamp in seconds
        return offsetDateTime.toEpochSecond();
    }
}
