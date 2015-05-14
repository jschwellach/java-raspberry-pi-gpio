package de.schwellach.examples.javaraspberrypigpio;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;

public class GpioDigitalOutput {

	private GpioPinDigitalOutput gpioPinDigitalOutput;
	
	public GpioDigitalOutput(RaspberryPiModel model) {
		this(model, 1);
	}
	
	public GpioDigitalOutput(RaspberryPiModel model, int gpioPin) {
		this(model,gpioPin, PinState.LOW);
	}
	
	public GpioDigitalOutput(RaspberryPiModel model, int gpioPin, PinState pinState) {
		if (gpioPin>model.getTotalGpios()) {
			throw new IllegalArgumentException("you specified a pin that is not available for your raspberry pi. Please chose a pin between 0 and "+(model.getTotalGpios()-1)+". Recommended pins are between 0 and "+(model.getStandardGpios()-1));
		}
		GpioController gpioController = GpioFactory.getInstance();
		gpioPinDigitalOutput = gpioController.provisionDigitalOutputPin(model.getTotalPins()[gpioPin], pinState);
	}

	public GpioPinDigitalOutput getGpioPinDigitalOutput() {
		return gpioPinDigitalOutput;
	}
	
}
