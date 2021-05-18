package com.backend.system;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import oshi.SystemInfo;
import oshi.hardware.*;
import oshi.software.os.OSSession;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;
import oshi.util.Util;

import java.io.File;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SystemApplication {
	static List<String> oshi = new ArrayList<>();
	public static void main(String[] args) {

		SpringApplication.run(SystemApplication.class, args);

	}


}
