package com.phexum.uniqueID;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;

public class ProcessorID {

	public static String generateLicenseKey() throws Exception {

		SystemInfo systemInfo = new SystemInfo();
		HardwareAbstractionLayer hardwareAbstractionLayer = systemInfo.getHardware();
		CentralProcessor centralProcessor = hardwareAbstractionLayer.getProcessor();

		String processorSerialNumber = centralProcessor.getSystemSerialNumber();

		return processorSerialNumber;
	}

	public static void main(String[] args) throws Exception {
		String identifier = generateLicenseKey();
		System.out.println(identifier);
	}
}
