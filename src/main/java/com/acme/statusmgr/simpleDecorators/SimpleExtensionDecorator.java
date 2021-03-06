package com.acme.statusmgr.simpleDecorators;


import com.acme.servermgr.ServerManager;
import com.acme.statusmgr.Decorators.ServerStatusDecorator;
import com.acme.statusmgr.beans.IServerStatus;

public class SimpleExtensionDecorator  extends ServerStatusDecorator {


    public SimpleExtensionDecorator(IServerStatus serverStatusToBeDecorated) {
        super(serverStatusToBeDecorated);
    }

    @Override
    public long getId() {
        return(0);
    }

    @Override
    public String getContentHeader() {
        return("");
    }

    @Override
    public String getStatusDesc() {
        return super.getStatusDesc() + ServerManager.getCurrentExtensionsStatus();
    }
}
