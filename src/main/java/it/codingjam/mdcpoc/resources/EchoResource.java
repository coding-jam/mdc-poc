package it.codingjam.mdcpoc.resources;

import it.codingjam.mdcpoc.concurrency.ApplicationExecutorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executors;


@RestController
public class EchoResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(EchoResource.class);

    @Autowired
    private ApplicationExecutorService executorService;

    @GetMapping("/echo/{echo}")
    public String echo(@PathVariable("echo") String echo) {
        LOGGER.info("Received '{}' to echo", echo);
        this.executorService.execute(() -> LOGGER.info("Execute async '{}' to echo", echo));
        return echo;
    }
}
