package it.codingjam.mdcpoc.concurrency;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class ApplicationExecutorService {

    private ExecutorService executorService;

    @PostConstruct
    void init() {
        this.executorService = Executors.newFixedThreadPool(10);
    }

    public void execute(Runnable runnable) {
        Map<String, String> contextMap = MDC.getCopyOfContextMap();
        this.executorService.execute(() -> {
            MDC.setContextMap(contextMap);
            runnable.run();
        });
    }

    @PreDestroy
    void close() {
        this.executorService.shutdown();
    }
}
