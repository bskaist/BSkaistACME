package com.acme.statusmgr;

import com.acme.statusmgr.Decorators.ExtensionDecorator;
import com.acme.statusmgr.Decorators.ServerStatusDecorator;
import com.acme.statusmgr.beans.IServerStatus;

public class ComplexExtensionDetail extends Detail{
    IServerStatus ssd;

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
        return new ExtensionDecorator(ssd).getId();
    }

    @Override
    public String getContentHeader() {
        return new ExtensionDecorator(ssd).getContentHeader();
    }

    @Override
    public String getStatusDesc() {
        return new ExtensionDecorator(ssd).getStatusDesc();
    }
}
