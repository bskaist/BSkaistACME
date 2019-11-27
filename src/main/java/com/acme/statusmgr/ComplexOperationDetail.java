package com.acme.statusmgr;

import com.acme.statusmgr.Decorators.OperationsDecorator;
import com.acme.statusmgr.Decorators.ServerStatusDecorator;
import com.acme.statusmgr.beans.IServerStatus;

public class ComplexOperationDetail extends Detail {
    public ComplexOperationDetail(IServerStatus ssd) {
        super(ssd);
    }

    @Override
    protected ServerStatusDecorator makeDetail(IServerStatus ssd) {
        return new OperationsDecorator(ssd);
    }
}
