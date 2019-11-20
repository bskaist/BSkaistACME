package statusmgr.Decorators;

/**
 * A decorator for the serverStatus class but also contains a memory status
 */
import servermgr.ServerManager;
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
        return super.getStatusDesc() + ServerManager.getCurrentMemoryStatus();
    }
}
