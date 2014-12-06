package com.froehlich.utils.date;

import java.time.LocalDateTime;

/**
 * Created by mfroehlich on 06.12.2014.
 */
public class CurrentTimeService {
    public LocalDateTime now() {
        LocalDateTime now = LocalDateTime.now();
        return now;
    }
}
