package statusmgr.Decorators;

import statusmgr.beans.IServerStatus;

public class ExtensionDecorator extends ServerStatusDecorator {

    public ExtensionDecorator(IServerStatus serverStatusToBeDecorated) {
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
        return super.getStatusDesc() + ", and is using these extensions" +
                " - [Hypervisor, Kubernetes, RAID-6]";
    }
}
