package com.acme.statusmgr;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.acme.statusmgr.Decorators.ExtensionDecorator;
import com.acme.statusmgr.Decorators.MemoryDecorator;
import com.acme.statusmgr.Decorators.OperationsDecorator;
import com.acme.statusmgr.beans.IServerStatus;
import com.acme.statusmgr.beans.ServerStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for all web/REST requests about the status of servers
 * <p>
 * For initial school project - just handles info about this server
 * Syntax for URLS:
 * All start with /server
 * /status  will give back status of server
 * a param of 'name' specifies a requestor name to appear in response
 * <p>
 * Examples:
 * http://localhost:8080/server/status
 * <p>
 * http://localhost:8080/server/status?name=Noach
 */

@RestController
@RequestMapping("/server")
public class StatusController {

    protected static final String template = "Server Status requested by %s";
    protected final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/status")
    public ServerStatus printStatus(@RequestParam(value = "name", defaultValue = "Anonymous") String name,
                                    @RequestParam(value = "details", required = false) List<String> details) {
        System.out.println("*** DEBUG INFO ***" + details);

        return new ServerStatus(counter.incrementAndGet(),
                String.format(template, name));

    }

    @RequestMapping(value = "/status/detailed")
    public IServerStatus printStatusDetailed(@RequestParam(value = "name", defaultValue = "Anonymous") String name,
                                             @RequestParam(value = "details") List<String> details) {
        System.out.println("*** DEBUG INFO ***");

        IServerStatus ssd = new ServerStatus(counter.incrementAndGet(), String.format(template, name));

        for (String s : details) {
            if (s.equals("operations")) {
                System.out.println(ssd);
                ssd = new OperationsDecorator(ssd);
            } else if (s.equals("extensions")) {
                ssd = new ExtensionDecorator(ssd);
            } else if (s.equals("memory")) {
                ssd = new MemoryDecorator(ssd);
            } else {
                System.out.println("errorOverhere!");
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
        }

        return ssd;

    }
}
