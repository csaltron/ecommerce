package com.inditex.ecommerce.rest.utils;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Util {

    private Util() {
    }

    public static ZonedDateTime getZonedDateTime() {

        return ZonedDateTime.now(ZoneId.of("Z"));
    }

    public static boolean isNotBlank(String str){
        return str != null && !str.isEmpty();
    }

}
