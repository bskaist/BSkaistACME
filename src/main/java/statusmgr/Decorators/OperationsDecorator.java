package statusmgr.Decorators;

import statusmgr.beans.IServerStatus;

public class OperationsDecorator extends ServerStatusDecorator {

    public OperationsDecorator(IServerStatus serverStatusToBeDecorated) {
        super(serverStatusToBeDecorated);
    }

    @Override
    public long getId() {
        return super.getId();
    }

    @Override
    public String getContentHeader() {
        return super.getContentHeader();
    }

    @Override
    public String getStatusDesc() {
        return super.getStatusDesc() + ", and is operating normally";
    }
}
