package com.acme.statusmgr.commands;

import com.acme.statusmgr.beans.IServerStatus;

/**
 * Command object for getId command
 */

public class GetIdCommand implements Command {

    private final IServerStatus serverStatus;

    public GetIdCommand(IServerStatus serverStatus){
        this.serverStatus = serverStatus;
    }

    @Override
    public Object execute() {
        serverStatus.getId();
        return null;
    }
}
