package com.backend.system.controllers;

import com.backend.system.helpers.Monitor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class MetricController {


    @RequestMapping(value = "/cpu")
    public CompletableFuture<List<String>> getCpu() {
        Monitor m=new Monitor();
        CompletableFuture<List<String>> completableFuture =
                CompletableFuture.supplyAsync(m::cpuLoads);
        return completableFuture;
    }
    @RequestMapping(value = "/physicalmemor")
    public String getMemory() {
        Monitor m=new Monitor();
        return m.physicalMemory();
    }

}
