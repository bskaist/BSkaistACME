package com.acme.statusmgr.beans;

import com.acme.servermgr.ServerManager;

/**
 * The basic implementaion of the IServerStatus
 */
public class ServerStatus implements IServerStatus {

    private long id;
    private String contentHeader;
    private String statusDesc = "Unknown";

    /**
     * Construct a ServerStatus using info passed in for identification, and obtaining current
     * server status from the appropriate Manager class.
     *
     * @param id            a numeric identifier/counter of which request this
     * @param contentHeader info about the request
     */
    public ServerStatus(long id, String contentHeader) {
        this.id = id;
        this.contentHeader = contentHeader;

        // Obtain current status of server
        this.statusDesc = ServerManager.getCurrentServerStatus();
    }

    public ServerStatus() {

    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getContentHeader() {
        return contentHeader;
    }

    @Override
    public String getStatusDesc() {
        return statusDesc;
    }


}
