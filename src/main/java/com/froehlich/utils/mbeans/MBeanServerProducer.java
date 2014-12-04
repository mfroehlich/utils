package com.froehlich.utils.mbeans;

import javax.enterprise.inject.Produces;
import javax.management.MBeanServer;
import java.lang.management.ManagementFactory;

/**
 * Created by mfroehlich on 04.12.2014.
 */
public class MBeanServerProducer {

    @Produces
    public MBeanServer produceMBeanServer() {
        return ManagementFactory.getPlatformMBeanServer();
    }
}
