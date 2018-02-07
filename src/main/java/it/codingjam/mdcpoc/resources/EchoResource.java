package it.codingjam.mdcpoc.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EchoResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(EchoResource.class);

    @GetMapping("/echo/{echo}")
    public String echo(@PathVariable("echo") String echo) {
        LOGGER.info("Received '{}' to echo", echo);
        return echo;
    }
}
