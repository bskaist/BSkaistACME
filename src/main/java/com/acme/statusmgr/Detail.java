package com.acme.statusmgr;

import com.acme.statusmgr.Decorators.ServerStatusDecorator;
import com.acme.statusmgr.beans.IServerStatus;

public abstract class  Detail  implements IServerStatus{
    private final ServerStatusDecorator serverStatusDecorator;

    public Detail(IServerStatus ssd) {
        serverStatusDecorator = makeDetail(ssd);
    }

    abstract protected ServerStatusDecorator makeDetail(IServerStatus ssd);
}
