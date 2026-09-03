public class AddingThermostat implements Command {
    private Thermostat thermostat;

    public AddingThermostat(Thermostat thermostat) {
        this.thermostat = thermostat;
    }

    @Override
    public String execute() {
        return thermostat.addTemperature();
    }
}