package com.acme.statusmgr;

import com.acme.statusmgr.Decorators.MemoryDecorator;
import com.acme.statusmgr.Decorators.ServerStatusDecorator;
import com.acme.statusmgr.beans.IServerStatus;
import com.acme.statusmgr.commands.*;


/**
 * class uses factory to add details to object
 */

public class ComplexMemoryDetail extends Detail {
    IServerStatus ssd;
    Invoker invoker = new Invoker();

    public ComplexMemoryDetail(IServerStatus ssd) {
        super(ssd);
        this.ssd = ssd;
    }

    @Override
    protected ServerStatusDecorator makeDetail(IServerStatus ssd) {
        return new MemoryDecorator(ssd);
    }

    @Override
    public long getId() {
        Command getIdCommand = new GetIdCommand(new MemoryDecorator(ssd));
        return (long) invoker.execute(getIdCommand);
    }

    @Override
    public String getContentHeader() {
        Command getContentHeaderCommand = new GetContentHeader(new MemoryDecorator(ssd));
        return (String) invoker.execute(getContentHeaderCommand);
    }

    @Override
    public String getStatusDesc() {
        Command getStatusDescCommand = new GetStatusDesc(new MemoryDecorator(ssd));
        return (String) invoker.execute(getStatusDescCommand);
    }
}
