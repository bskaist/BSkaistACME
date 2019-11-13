package statusmgr.beans;

import servermgr.ServerManager;
import statusmgr.Decorators.ServerStatusDecorator;

import java.util.List;

/**
 * A POJO that represents Server Status and can be used to generate JSON for that status
 */
public class ServerStatus implements IServerStatus {

    private long id;
    private String contentHeader;
    private String statusDesc = "Unknown";

    /**
     * Construct a ServerStatus using info passed in for identification, and obtaining current
     * server status from the appropriate Manager class.
     *
     * @param id            a numeric identifier/counter of which request this
     * @param contentHeader info about the request
     */
    public ServerStatus(long id, String contentHeader) {
        this.id = id;
        this.contentHeader = contentHeader;

        // Obtain current status of server
        this.statusDesc = ServerManager.getCurrentServerStatus();
    }

    public ServerStatus() {

    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getContentHeader() {

        return contentHeader;
    }

    @Override
    public String getStatusDesc() {
        return statusDesc;
    }


}
