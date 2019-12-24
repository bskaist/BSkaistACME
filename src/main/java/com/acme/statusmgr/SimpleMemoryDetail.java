package com.acme.statusmgr;

import com.acme.statusmgr.Decorators.ServerStatusDecorator;
import com.acme.statusmgr.beans.IServerStatus;
import com.acme.statusmgr.simpleDecorators.SimpleMemoryDecorator;

public class SimpleMemoryDetail extends Detail {

    IServerStatus ssd;

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
        return new SimpleMemoryDecorator(ssd).getId();
    }

    @Override
    public String getContentHeader() {
        return new SimpleMemoryDecorator(ssd).getContentHeader();
    }

    @Override
    public String getStatusDesc() {
        return new SimpleMemoryDecorator(ssd).getStatusDesc();
    }
}
