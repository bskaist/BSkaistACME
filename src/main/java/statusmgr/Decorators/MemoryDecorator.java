package statusmgr.Decorators;

import statusmgr.beans.IServerStatus;

public class MemoryDecorator  extends ServerStatusDecorator {

    public MemoryDecorator(IServerStatus serverStatusToBeDecorated) {
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
        return super.getStatusDesc() + ", and its memory is Running low";
    }
}
