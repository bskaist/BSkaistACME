package com.acme.statusmgr.commands;

import com.acme.statusmgr.beans.IServerStatus;

/**
 * Command object for getContentHeader command
 */
public class GetContentHeader implements Command{
    private final IServerStatus serverStatus;

    public GetContentHeader(IServerStatus serverStatus){
        this.serverStatus = serverStatus;
    }

    @Override
    public Object execute() {
        serverStatus.getContentHeader();
        return null;
    }
}
