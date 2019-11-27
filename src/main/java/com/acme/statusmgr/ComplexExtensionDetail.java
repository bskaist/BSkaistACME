package com.acme.statusmgr;

import com.acme.statusmgr.Decorators.ExtensionDecorator;
import com.acme.statusmgr.Decorators.ServerStatusDecorator;
import com.acme.statusmgr.beans.IServerStatus;
import com.acme.statusmgr.simpleDecorators.SimpleExtensionDecorator;

public class ComplexExtensionDetail extends Detail{

    public ComplexExtensionDetail(IServerStatus ssd) {
        super(ssd);
    }

    @Override
    protected ServerStatusDecorator makeDetail(IServerStatus ssd) {
        return new ExtensionDecorator(ssd);
    }
}
