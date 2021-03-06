package com.acme.servermgr;

import org.springframework.beans.factory.annotation.Autowired;
/**
 * Manage all servers (service providers) being tracked by the Acme server tracking system
 * For now just some simple static methods for use in school project
 */
public class ServerManager {

    /**
     * Reference to a class that knows how to get details about what we are interested in on a server
     */
    @Autowired
    private IMonitorableServer monitor;

    /**
     * Get the status of this server
     *
     * @return a descriptive string about the servers status
     */
    static public String getCurrentServerStatus() {
        return "Server is up";
    }
    static public String getCurrentOperationStatus() {
        return ", and is operating normally";
    }

    static public String getCurrentExtensionsStatus() {
        return ", and is using these extensions - [Hypervisor, Kubernetes, RAID-6]";
    }

    static public String getCurrentMemoryStatus() {
        return ", and its memory is Running low";
    }


    /**
     * Find out if this server is operating normally
     *
     * @return Boolean indicating if server is operating normally
     */
    static public Boolean isOperatingNormally() {
        return true;
    }
}
