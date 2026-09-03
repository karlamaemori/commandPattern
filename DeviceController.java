import java.util.Arrays;

public class DeviceController {
    private static class CommandEntry {
        String name;
        Command command;

        CommandEntry(String name, Command command) {
            this.name = name;
            this.command = command;
        }
    }

    private CommandEntry[] commands = new CommandEntry[10];
    private int size = 0;

    public void setCommand(String name, Command command) {
        for (int i = 0; i < size; i++) {
            if (commands[i].name.equals(name)) {
                commands[i].command = command;
                return;
            }
        }
        if (size == commands.length) {
            commands = Arrays.copyOf(commands, size * 2);
        }
        commands[size++] = new CommandEntry(name, command);
    }

    public String pressButton(String name) {
        for (int i = 0; i < size; i++) {
            if (commands[i].name.equals(name)) {
                return commands[i].command.execute();
            }
        }
        return "No command assigned to \"" + name + "\"";
    }
}