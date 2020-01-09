package com.acme.statusmgr.commands;

import com.acme.statusmgr.beans.IServerStatus;

/**
 * Command object for getStatusDesc command
 */

public class GetStatusDesc implements Command {

    private final IServerStatus serverStatus;

    public GetStatusDesc(IServerStatus serverStatus){
        this.serverStatus = serverStatus;
    }

    @Override
    public Object execute() {

        return null;
    }
}
