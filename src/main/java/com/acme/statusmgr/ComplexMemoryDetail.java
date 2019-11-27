package com.acme.statusmgr;

import com.acme.statusmgr.Decorators.MemoryDecorator;
import com.acme.statusmgr.Decorators.ServerStatusDecorator;
import com.acme.statusmgr.beans.IServerStatus;

public class ComplexMemoryDetail extends Detail {
    public ComplexMemoryDetail(IServerStatus ssd) {
        super(ssd);
    }

    @Override
    protected ServerStatusDecorator makeDetail(IServerStatus ssd) {
        return new MemoryDecorator(ssd);
    }
}
