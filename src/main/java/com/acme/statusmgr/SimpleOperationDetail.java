package com.acme.statusmgr;

import com.acme.statusmgr.Decorators.ServerStatusDecorator;
import com.acme.statusmgr.beans.IServerStatus;
import com.acme.statusmgr.commands.Command;
import com.acme.statusmgr.commands.GetContentHeader;
import com.acme.statusmgr.commands.GetIdCommand;
import com.acme.statusmgr.commands.GetStatusDesc;
import com.acme.statusmgr.simpleDecorators.SimpleOperationsDecorator;

/**
 * class uses factory to add details to object
 */

public class SimpleOperationDetail extends Detail  {

    IServerStatus ssd;
    Invoker invoker = new Invoker();

    public SimpleOperationDetail(IServerStatus ssd) {
        super(ssd);
        this.ssd = ssd;
    }

    @Override
    protected ServerStatusDecorator makeDetail(IServerStatus ssd) {
        return new SimpleOperationsDecorator(ssd);
    }

    @Override
    public long getId() {
        Command getIdCommand = new GetIdCommand(new SimpleOperationsDecorator(ssd));
        return (long) invoker.execute(getIdCommand);
    }

    @Override
    public String getContentHeader() {
        Command getContentHeaderCommand = new GetContentHeader(new SimpleOperationsDecorator(ssd));
        return (String) invoker.execute(getContentHeaderCommand);
    }

    @Override
    public String getStatusDesc() {
        Command getStatusDescCommand = new GetStatusDesc(new SimpleOperationsDecorator(ssd));
        return (String) invoker.execute(getStatusDescCommand);
    }
}
