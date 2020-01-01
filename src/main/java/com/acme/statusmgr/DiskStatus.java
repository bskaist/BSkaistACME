package com.acme.statusmgr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/**
 * Simple class to handle disk status requests
 */

public class DiskStatus {

    private long id;
    private String contentHeader;
    private String diskCommandOutput;
    private static String diskCommand = "chkdsk c: ";

    public DiskStatus(long id, String contentHeader) {
        this.id = id;
        this.contentHeader = contentHeader;
        diskCommandOutput = checkDiskStatus();
    }


    public long getId() {
        return id;
    }

    public String getContentHeader() {
        return contentHeader;
    }

    public String getDiskCommand() {
        return diskCommand;
    }

    public String getDiskCommandOutput() {
        return diskCommandOutput;
    }

    public static String checkDiskStatus()
    {
        Runtime rt = Runtime.getRuntime();

        try {
            Process chkProcess = rt.exec(diskCommand);

            /*
              This will read the output coming from the command (into our input), and collect
              all of the output into one string.
             */
            return new BufferedReader(new InputStreamReader(chkProcess.getInputStream()))
                    .lines().collect(Collectors.joining("\n"));

        } catch (IOException e) { e.printStackTrace(); }

        return "Unable to obtain disk status";
    }
}
