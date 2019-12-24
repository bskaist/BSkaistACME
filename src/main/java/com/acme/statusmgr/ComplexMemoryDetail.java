package com.acme.statusmgr;

import com.acme.statusmgr.Decorators.MemoryDecorator;
import com.acme.statusmgr.Decorators.ServerStatusDecorator;
import com.acme.statusmgr.beans.IServerStatus;

public class ComplexMemoryDetail extends Detail {
    IServerStatus ssd;

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
        return new MemoryDecorator(ssd).getId();
    }

    @Override
    public String getContentHeader() {
        return new MemoryDecorator(ssd).getContentHeader();
    }

    @Override
    public String getStatusDesc() {
        return new MemoryDecorator(ssd).getStatusDesc();
    }
}
