package com.acme.statusmgr;

import com.acme.statusmgr.Decorators.ExtensionDecorator;
import com.acme.statusmgr.Decorators.ServerStatusDecorator;
import com.acme.statusmgr.beans.IServerStatus;
import com.acme.statusmgr.commands.*;

/**
 * class uses factory to add details to object
 */

public class ComplexExtensionDetail extends Detail{
    IServerStatus ssd;
    Invoker invoker = new Invoker();

    public ComplexExtensionDetail(IServerStatus ssd) {
        super(ssd);
        this.ssd = ssd;
    }

    @Override
    protected ServerStatusDecorator makeDetail(IServerStatus ssd) {
        return new ExtensionDecorator(ssd);
    }

    @Override
    public long getId() {
        Command getIdCommand = new GetIdCommand(new ExtensionDecorator(ssd));
        return (long) invoker.execute(getIdCommand);
    }

    @Override
    public String getContentHeader() {
        Command getContentHeaderCommand = new GetContentHeader(new ExtensionDecorator(ssd));
        return (String) invoker.execute(getContentHeaderCommand);
    }

    @Override
    public String getStatusDesc() {
        Command getStatusDescCommand = new GetStatusDesc(new ExtensionDecorator(ssd));
        return (String) invoker.execute(getStatusDescCommand);
    }
}
