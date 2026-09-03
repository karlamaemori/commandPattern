public class Light {
    private int brightness;

    public String turnOn() {
        this.brightness = 100;
        return "Light is ON (Brightness: )" + brigthness + "%";
    }

    public String turnOff() {
        this.brightness = 0;
        return "Light is OFF!";
    }
}