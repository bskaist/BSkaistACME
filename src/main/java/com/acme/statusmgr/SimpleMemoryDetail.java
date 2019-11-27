package com.acme.statusmgr;

import com.acme.statusmgr.Decorators.ServerStatusDecorator;
import com.acme.statusmgr.beans.IServerStatus;
import com.acme.statusmgr.simpleDecorators.SimpleMemoryDecorator;

public class SimpleMemoryDetail extends Detail {

    public SimpleMemoryDetail(IServerStatus ssd) {
        super(ssd);
    }

    @Override
    protected ServerStatusDecorator makeDetail(IServerStatus ssd) {
        return new SimpleMemoryDecorator(ssd);
    }
}
