package com.acme.statusmgr;


import com.acme.statusmgr.Decorators.OperationsDecorator;
import com.acme.statusmgr.Decorators.ServerStatusDecorator;
import com.acme.statusmgr.beans.IServerStatus;

public class ComplexOperationDetail extends Detail {

    IServerStatus ssd;

    public ComplexOperationDetail(IServerStatus ssd) {
        super(ssd);
        this.ssd=ssd;
    }

    @Override
    protected ServerStatusDecorator makeDetail(IServerStatus ssd) {
        return new OperationsDecorator(ssd);
    }

    @Override
    public long getId() {
        return new OperationsDecorator(ssd).getId();
    }

    @Override
    public String getContentHeader() {
        return new OperationsDecorator(ssd).getContentHeader();
    }

    @Override
    public String getStatusDesc() {
        return new OperationsDecorator(ssd).getStatusDesc();
    }
}

