public class Thermostat {
    private int temperature = 20;

public String addTemperature() {
    temperature++;
    return "Thermostat increased to " + temperature + "\u00B0C";
}

public String minusTemperature() {
    temperature--;
    return "Termostat decreased to " + temperature + "\u00B0C";
}
}