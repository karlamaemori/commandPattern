public class LightOff implements Command {
    private Light light;

    public LightOff(Light light) {
        this.light = light;
    }

    @Override
    public String execute() {
        return light.turnOff();
    }
}