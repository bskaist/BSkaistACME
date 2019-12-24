package com.acme.statusmgr;

import com.acme.statusmgr.Decorators.ServerStatusDecorator;
import com.acme.statusmgr.beans.IServerStatus;
import com.acme.statusmgr.simpleDecorators.SimpleOperationsDecorator;

public class SimpleOperationDetail extends Detail  {

    IServerStatus ssd;

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
        return new SimpleOperationsDecorator(ssd).getId();
    }

    @Override
    public String getContentHeader() {
        return new SimpleOperationsDecorator(ssd).getContentHeader();
    }

    @Override
    public String getStatusDesc() {
        return new SimpleOperationsDecorator(ssd).getStatusDesc();
    }
}
