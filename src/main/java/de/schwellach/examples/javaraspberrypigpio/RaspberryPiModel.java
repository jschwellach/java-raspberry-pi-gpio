package de.schwellach.examples.javaraspberrypigpio;

import java.util.ArrayList;
import java.util.List;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;

public enum RaspberryPiModel {
	PI_A ("Raspberry Pi - Model A", 15, 8),
	PI_B_PLUS ("Raspberry Pi - Model B+", 29, 15),
	PI_2_B ("Raspberry Pi 2 - Model B",29, 15);
	
	private String name;
	private int totalGpios;
	private int standardGpios;
	private Pin[] standardPins;
	private Pin[] totalPins;
	
	RaspberryPiModel(String name, int totalGpios, int standardGpios) {
		this.name = name;
		this.totalGpios = totalGpios;
		this.standardGpios = standardGpios;
		init();
	}
	
	private void init() {
		List<Pin> pins = new ArrayList<Pin>();
		for (int i=0;i<standardGpios;i++) {
			String pinName = "GPIO "+i;
			Pin pin = RaspiPin.getPinByName(pinName);
			pins.add(pin);
		}
		this.standardPins = pins.toArray(new Pin[pins.size()]);
		pins.clear();
		for (int i=0;i<totalGpios;i++) {
			String pinName = "GPIO "+i;
			Pin pin = RaspiPin.getPinByName(pinName);
			pins.add(pin);
		}
		this.totalPins = pins.toArray(new Pin[pins.size()]);
	}

	public String getName() {
		return name;
	}

	public int getTotalGpios() {
		return totalGpios;
	}

	public int getStandardGpios() {
		return standardGpios;
	}

	public Pin[] getStandardPins() {
		return standardPins;
	}

	public Pin[] getTotalPins() {
		return totalPins;
	}
	
}
