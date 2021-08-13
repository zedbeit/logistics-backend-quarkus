package org.miles.lang.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

public class DateUtils {
    public static Instant currentInstant(){
        return LocalDateTime.ofInstant(Instant.now(),ZoneId.of("Africa/Lagos")).toInstant(ZoneOffset.UTC);
    }
}
