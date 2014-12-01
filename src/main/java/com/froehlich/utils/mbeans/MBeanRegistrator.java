package com.froehlich.utils.mbeans;

import org.slf4j.Logger;

import javax.inject.Inject;
import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

/**
 * Created by mfroehlich on 21.11.2014.
 */
public class MBeanRegistrator {

    @Inject
    private MBeanServer mbeanServer;

    @Inject
    private Logger logger;

    public <M> void registerMBean(String objectNameStr, M mbeanInstance) {

        try {
            ObjectName objectName = new ObjectName(objectNameStr);

            try {
                mbeanServer.unregisterMBean(objectName);
            } catch (InstanceNotFoundException e) {
                logger.info("Tried to unregister MBean before registering it, but wasn't there. Everything's ok.");
            }

            mbeanServer.registerMBean(mbeanInstance, objectName);
            logger.debug("MBean " + objectNameStr + " registered");

        } catch (InstanceAlreadyExistsException | MBeanRegistrationException | NotCompliantMBeanException
                | MalformedObjectNameException e) {
            logger.error("Error registering MBean " + objectNameStr, e);
            throw new IllegalArgumentException("Error registering MBean " + objectNameStr);
        }
    }
}
