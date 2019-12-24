package com.acme.statusmgr;

import com.acme.statusmgr.Decorators.ServerStatusDecorator;
import com.acme.statusmgr.beans.IServerStatus;
import com.acme.statusmgr.simpleDecorators.SimpleExtensionDecorator;

class SimpleExtensionDetail extends Detail{
    IServerStatus ssd;

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
        return new SimpleExtensionDecorator(ssd).getId();
    }

    @Override
    public String getContentHeader() {
        return new SimpleExtensionDecorator(ssd).getContentHeader();
    }

    @Override
    public String getStatusDesc() {
        return new SimpleExtensionDecorator(ssd).getStatusDesc();
    }
}
