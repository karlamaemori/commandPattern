public class SmarthomeApp {
    public static void main(String[] args) {
        Light light = new Light();
        Thermostat thermostat = new Thermostat();
        MusicPlayer musicPlayer = new MusicPlayer();

        Command lightOnCommand = new LightOn(light);
        Command lightOffCommand = new LightOff(light);
        Command addTemperatureCommand = new AddingThermostat(thermostat);
        Command reduceTemperatureCommand = new ReducingThermostat(thermostat);
        Command volumeUpCommand = new VolumeUp(musicPlayer);
        Command volumeDownCommand = new VolumeDown(musicPlayer);

        DeviceController deviceController = new DeviceController();
        deviceController.setCommand("LIGHT_ON", lightOnCommand);
        deviceController.setCommand("LIGHT_OFF", lightOffCommand);
        deviceController.setCommand("THERMOSTAT_ADD", addTemperatureCommand);
        deviceController.setCommand("THERMOSTAT_REDUCE", reduceTemperatureCommand);
        deviceController.setCommand("MUSIC_VOLUME_UP", volumeUpCommand);
        deviceController.setCommand("MUSIC_VOLUME_DOWN", volumeDownCommand);

        System.out.println(deviceController.pressButton("LIGHT_ON"));
        System.out.println(deviceController.pressButton("THERMOSTAT_ADD"));
        System.out.println(deviceController.pressButton("MUSIC_VOLUME_UP"));
        System.out.println(deviceController.pressButton("MUSIC_VOLUME_DOWN"));
        System.out.println(deviceController.pressButton("THERMOSTAT_REDUCE"));
        System.out.println(deviceController.pressButton("LIGHT_OFF"));
    }

}