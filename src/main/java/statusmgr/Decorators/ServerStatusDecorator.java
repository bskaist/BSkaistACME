package statusmgr.Decorators;

/**
 * A decorator that is an abstract class containing a reference to an interface that will
 * all the ServerStatus objects
 */
import statusmgr.beans.IServerStatus;


public abstract class ServerStatusDecorator implements IServerStatus {

    private final IServerStatus serverStatusToBeDecorated;

    public ServerStatusDecorator(IServerStatus serverStatusToBeDecorated) {
        this.serverStatusToBeDecorated = serverStatusToBeDecorated;
    }

    @Override
    public long getId() {
        return serverStatusToBeDecorated.getId();
    }

    @Override
    public String getContentHeader() {
        return serverStatusToBeDecorated.getContentHeader();
    }

@Override
    public String getStatusDesc() {
        return serverStatusToBeDecorated.getStatusDesc();
    }

}
