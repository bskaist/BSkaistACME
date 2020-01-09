package com.acme.statusmgr;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.acme.statusmgr.commands.GetContentHeader;
import com.acme.statusmgr.commands.GetIdCommand;
import com.acme.statusmgr.commands.GetStatusDesc;
import com.acme.statusmgr.simpleDecorators.SimpleExtensionDecorator;
import com.acme.statusmgr.simpleDecorators.SimpleMemoryDecorator;
import com.acme.statusmgr.simpleDecorators.SimpleOperationsDecorator;
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
                                             @RequestParam(value = "details") List<String> details,
                                             @RequestParam(value = "levelOfDetail", defaultValue = "complex") String level) {
        System.out.println("*** DEBUG INFO ***");

        if(!(level.equals("complex") || level.equals("simple"))){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        IServerStatus ssd = new ServerStatus(counter.incrementAndGet(), String.format(template, name));

        for (String s : details) {
            if (s.equals("operations")) {
                if(level.equals("simple")){
                    ssd = new SimpleOperationDetail(ssd);
                }else{
                    ssd = new ComplexOperationDetail(ssd);
                }
            } else if (s.equals("extensions")) {
                if(level.equals("simple")){
                    ssd = new SimpleExtensionDetail(ssd);
                }else{
                    ssd = new ComplexExtensionDetail(ssd);
                }
            } else if (s.equals("memory")) {
                if(level.equals("simple")){
                    ssd = new SimpleMemoryDetail(ssd);
                }else{
                    ssd = new ComplexMemoryDetail(ssd);
                }

            } else {
                System.out.println("errorOverhere!");
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
        }
        return ssd;
    }
    @RequestMapping(value = "/disk/status")
    public DiskStatus getDiskStatus(@RequestParam(value="name", defaultValue="Anonymous") String name) {
        return new DiskStatus(counter.incrementAndGet(), String.format(template, name));
    }
}
