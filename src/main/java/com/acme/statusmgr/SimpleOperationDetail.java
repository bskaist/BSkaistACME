package com.acme.statusmgr;

import com.acme.statusmgr.Decorators.ServerStatusDecorator;
import com.acme.statusmgr.beans.IServerStatus;
import com.acme.statusmgr.simpleDecorators.SimpleOperationsDecorator;

public class SimpleOperationDetail extends Detail  {
    public SimpleOperationDetail(ServerStatusDecorator ssd) {
        super(ssd);
    }

    public SimpleOperationDetail(IServerStatus ssd) {
        super(ssd);
    }

    @Override
    protected ServerStatusDecorator makeDetail(IServerStatus ssd) {
        return new SimpleOperationsDecorator(ssd);
    }

}
