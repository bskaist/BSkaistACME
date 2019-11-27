package com.acme.statusmgr.simpleDecorators;

import com.acme.statusmgr.ComplexDecorators.ComplexOperationsDecorator;
import com.acme.statusmgr.Decorators.ServerStatusDecorator;
import com.acme.statusmgr.Detail;

public class ComplexOperationDetail extends Detail {
    public ComplexOperationDetail(ServerStatusDecorator ssd) {
        super(ssd);
    }

    @Override
    protected ServerStatusDecorator makeDetail(ServerStatusDecorator ssd) {
        return new ComplexOperationsDecorator(ssd);
    }
}
