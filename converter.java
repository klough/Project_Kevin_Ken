public class Converter

{ 
//Your names go here:


/*
* @Author: 	Kevin
				Ken
				Name of the third student
*
*/

private double celsiusToFahrenheit(double C){
	// TODO: The third student will implement this method
	
		return (C*9/5)+32;
	
	}
	
private double fahrenheitToCelsius(double F){
		// TODO: The second student will implement this method
		
		
		return (F - 32) * 5/9;
		
	}
		
public static void main(String[] args) {
		
		//TODO:The first student will implement this method.
		//Call CelsiusToFahrenheit to convert 180 Celsius to Fahrenheit value.
		// Call FahrenheitToCelsius to convert 250 Fahrenheit to Celsius value.
		Converter C = new Converter(); 
		System.out.println(C.celsiusToFahrenheit(180)); //180 System.out.println
		//C.celsiusToFahrenheit(180);
		System.out.println(C.fahrenheitToCelsius(250)); //250
	}
	
	}