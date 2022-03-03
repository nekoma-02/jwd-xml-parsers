package by.epam.tc.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.epam.tc.controller.command.impl.Parse;


public class CommandProvided {

	private static final CommandProvided instance = new CommandProvided();

	private Map<CommandName, Command> commands = new HashMap<CommandName, Command>();

	public static CommandProvided getInstance() {
		return instance;
	}

	public CommandProvided() {
		commands.put(CommandName.PARSE, new Parse());
	}
			
			
	public Command getCommand(String commandName) {
		CommandName name = CommandName.valueOf(commandName.toUpperCase());
		Command command = null;

		if (name != null) {
			command = commands.get(name);
		} else {
			command = commands.get(CommandName.NO_SUCH_COMMAND);
		}

		return command;

	}

}
