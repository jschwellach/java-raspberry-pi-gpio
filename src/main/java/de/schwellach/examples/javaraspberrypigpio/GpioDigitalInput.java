package de.schwellach.examples.javaraspberrypigpio;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.PinPullResistance;

public class GpioDigitalInput {

	private GpioPinDigitalInput gpioPinDigitalInput;

	public GpioDigitalInput(RaspberryPiModel model) {
		this(model, 4);
	}

	public GpioDigitalInput(RaspberryPiModel model, int gpioPin) {
		this(model, gpioPin, PinPullResistance.PULL_DOWN);
	}

	public GpioDigitalInput(RaspberryPiModel model, int gpioPin, PinPullResistance resistance) {
		if (gpioPin > model.getTotalGpios()) {
			throw new IllegalArgumentException(
					"you specified a pin that is not available for your raspberry pi. Please chose a pin between 0 and "
							+ (model.getTotalGpios() - 1) + ". Recommended pins are between 0 and " + (model.getStandardGpios() - 1));
		}
		GpioController gpioController = GpioFactory.getInstance();
		gpioPinDigitalInput = gpioController.provisionDigitalInputPin(model.getTotalPins()[gpioPin], resistance);
	}

	public GpioPinDigitalInput getGpioPinDigitalInput() {
		return gpioPinDigitalInput;
	}

}
