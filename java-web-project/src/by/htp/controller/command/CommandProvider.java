package by.htp.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.htp.controller.command.impl.DeleteNews;
import by.htp.controller.command.impl.GoToAboutPage;
import by.htp.controller.command.impl.GoToAddNewsPage;
import by.htp.controller.command.impl.GoToEditNewsPage;
import by.htp.controller.command.impl.GoToIndexPage;
import by.htp.controller.command.impl.GoToSigninPage;
import by.htp.controller.command.impl.InsertNewNews;
import by.htp.controller.command.impl.GoToMainPage;
import by.htp.controller.command.impl.GoToRegistrationPage;
import by.htp.controller.command.impl.Logination;
import by.htp.controller.command.impl.Logout;
import by.htp.controller.command.impl.SaveEditedNews;
import by.htp.controller.command.impl.SaveNewUser;
import by.htp.controller.command.impl.ShowNews;

public class CommandProvider {
	private Map<CommandName, Command> commands = new HashMap<>();

	public CommandProvider() {
		commands.put(CommandName.LOGINATION, new Logination());
		commands.put(CommandName.REGISTRATION, new GoToRegistrationPage());
		commands.put(CommandName.SAVENEWUSER, new SaveNewUser());
		commands.put(CommandName.GOTOINDEXPAGE, new GoToIndexPage());
		commands.put(CommandName.GOTOSIGNINPAGE, new GoToSigninPage());
		commands.put(CommandName.GOTOMAINPAGE, new GoToMainPage());
		commands.put(CommandName.GOTOABOUTPAGE, new GoToAboutPage());
		commands.put(CommandName.LOGOUT, new Logout());
		commands.put(CommandName.SHOWNEWS, new ShowNews());
		commands.put(CommandName.GOTOEDITNEWSPAGE, new GoToEditNewsPage());
		commands.put(CommandName.SAVEEDITEDNEWS, new SaveEditedNews());
		commands.put(CommandName.DELETENEWS, new DeleteNews());
		commands.put(CommandName.GOTOADDNEWSPAGE, new GoToAddNewsPage());
		commands.put(CommandName.INSERTNEWNEWS, new InsertNewNews());

	}

	public Command takeCommand(String name) {
		CommandName commandName;

		commandName = CommandName.valueOf(name.toUpperCase());

		return commands.get(commandName);

	}
}
