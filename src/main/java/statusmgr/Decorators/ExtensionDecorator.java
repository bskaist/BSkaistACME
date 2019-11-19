package statusmgr.Decorators;

/**
 * A decorator for the serverStatus class but also contains an extensions status
 */
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
