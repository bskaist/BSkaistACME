package com.acme.statusmgr.beans;

/**
 * The interface for all ServerStatus objects
 */
public interface IServerStatus {
    public long getId();

    public String getContentHeader();

    public String getStatusDesc();
}
