public class ReducingThermostat implements Command {
    private Thermostat thermostat;

    public ReducingThermostat(Thermostat thermostat) {
        this.thermostat = thermostat;
    }

    @Override
    public String execute() {
        return thermostat.minusTemperature();
    }
}