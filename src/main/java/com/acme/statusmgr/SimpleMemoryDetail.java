package com.acme.statusmgr;

import com.acme.statusmgr.Decorators.ServerStatusDecorator;
import com.acme.statusmgr.beans.IServerStatus;
import com.acme.statusmgr.commands.*;
import com.acme.statusmgr.simpleDecorators.SimpleMemoryDecorator;
import com.acme.statusmgr.simpleDecorators.SimpleOperationsDecorator;

public class SimpleMemoryDetail extends Detail {

    IServerStatus ssd;
    Invoker invoker = new Invoker();


    public SimpleMemoryDetail(IServerStatus ssd) {
        super(ssd);
        this.ssd = ssd;
    }

    @Override
    protected ServerStatusDecorator makeDetail(IServerStatus ssd) {

        return new SimpleMemoryDecorator(ssd);
    }

    @Override
    public long getId() {
        Command getIdCommand = new GetIdCommand(new SimpleMemoryDecorator(ssd));
        return (long) invoker.execute(getIdCommand);
    }

    @Override
    public String getContentHeader() {
        Command getContentHeaderCommand = new GetContentHeader(new SimpleMemoryDecorator(ssd));
        return (String) invoker.execute(getContentHeaderCommand);
    }

    @Override
    public String getStatusDesc() {
        Command getStatusDescCommand = new GetStatusDesc(new SimpleMemoryDecorator(ssd));
        return (String) invoker.execute(getStatusDescCommand);
    }
}
