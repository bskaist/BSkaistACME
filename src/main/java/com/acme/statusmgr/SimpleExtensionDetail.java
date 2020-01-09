package com.acme.statusmgr;

import com.acme.statusmgr.Decorators.ServerStatusDecorator;
import com.acme.statusmgr.beans.IServerStatus;
import com.acme.statusmgr.commands.*;
import com.acme.statusmgr.simpleDecorators.*;

/**
 * class uses factory to add details to object
 */

class SimpleExtensionDetail extends Detail{
    IServerStatus ssd;
    Invoker invoker = new Invoker();

    public SimpleExtensionDetail(IServerStatus ssd) {
        super(ssd);
        this.ssd = ssd;
    }

    @Override
    protected ServerStatusDecorator makeDetail(IServerStatus ssd) {
        return new SimpleExtensionDecorator(ssd);
    }

    @Override
    public long getId() {
        Command getIdCommand = new GetIdCommand(new SimpleExtensionDecorator(ssd));
        return (long) invoker.execute(getIdCommand);
    }

    @Override
    public String getContentHeader() {
        Command getContentHeaderCommand = new GetContentHeader(new SimpleExtensionDecorator(ssd));
        return (String) invoker.execute(getContentHeaderCommand);
    }

    @Override
    public String getStatusDesc() {
        Command getStatusDescCommand = new GetStatusDesc(new SimpleExtensionDecorator(ssd));
        return (String) invoker.execute(getStatusDescCommand);
    }
}
