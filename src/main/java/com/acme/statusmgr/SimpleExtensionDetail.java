package com.acme.statusmgr;

import com.acme.statusmgr.Decorators.ServerStatusDecorator;
import com.acme.statusmgr.beans.IServerStatus;
import com.acme.statusmgr.simpleDecorators.SimpleExtensionDecorator;

class SimpleExtensionDetail extends Detail{

    public SimpleExtensionDetail(IServerStatus ssd) {
        super(ssd);
    }

    @Override
    protected ServerStatusDecorator makeDetail(IServerStatus ssd) {
        return new SimpleExtensionDecorator(ssd);
    }
}
