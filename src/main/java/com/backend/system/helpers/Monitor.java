package com.backend.system.helpers;

import oshi.SystemInfo;
import oshi.hardware.*;
import oshi.software.os.OSSession;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;
import oshi.util.Util;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public  class Monitor {
    private  SystemInfo si = new SystemInfo();
    private  HardwareAbstractionLayer hal = si.getHardware();


    public String getOsName()
    {
       return si.getOperatingSystem().toString();
    }


    public  List<String> cpuLoads() {
        List<String> lis=new ArrayList<>();
        CentralProcessor processor = hal.getProcessor();
        long[][] prevProcTicks = processor.getProcessorCpuLoadTicks();
        Util.sleep(1000);

        double[] load = processor.getProcessorCpuLoadBetweenTicks(prevProcTicks);
        for (double avg : load) {
            lis.add(String.format(" %.1f%%", avg * 100));
        }
        return lis;

    }
    public  String physicalMemory() {

        GlobalMemory memory=hal.getMemory();

        return memory.toString();


    }
    public  String virtualMemory() {

        GlobalMemory memory=hal.getMemory();
        return memory.getVirtualMemory().toString();
    }
}
