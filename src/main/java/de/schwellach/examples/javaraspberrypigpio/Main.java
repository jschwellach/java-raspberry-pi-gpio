package de.schwellach.examples.javaraspberrypigpio;

import java.util.concurrent.Future;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;

public class Main {

	public static void main(String[] args) throws Exception {
//		GpioDigitalOutput digitalOutput = new GpioDigitalOutput(RaspberryPiModel.PI_2_B);
//		digitalOutput.getGpioPinDigitalOutput().high();
		
		RaspberryPiModel model = RaspberryPiModel.PI_2_B;
		Pin pin = model.getStandardPins()[1];
		
		GpioController controller = GpioFactory.getInstance();
		GpioPinDigitalOutput digitalOutputPin = controller.provisionDigitalOutputPin(pin, PinState.HIGH);
		Future<?> blink = digitalOutputPin.blink(1000, 10000);
		while (!blink.isDone()) {
		}
		System.out.println("done");
		System.exit(0);
	}
}
