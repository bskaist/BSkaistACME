package com.acme.statusmgr;


import com.acme.statusmgr.commands.Command;

/**
 * Inkoer is used to execute commands
 */

public class Invoker {

    public Object execute(Command commandName) {
        Object obj = commandName.execute();
        return obj;
    }
}
