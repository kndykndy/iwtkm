package some.company.commands;

import com.google.common.base.Strings;
import some.company.Constants;
import some.company.Utilities;
import some.company.commands.impl.FindAllBooksCommand;
import some.company.commands.impl.FindAllBooksOrderedCommand;
import some.company.commands.impl.FindBookByAuthorCommand;
import some.company.commands.impl.FindBookByIsbnCommand;

public enum CommandLineValidator {

    INSTANCE;

    public Command validate(final String[] args) {
        Command result = FindAllBooksCommand.INSTANCE;

        if (args != null && args.length != 0 && !Strings.isNullOrEmpty(args[0])) {
            final String commandStr = args[0];

            if (Constants.SHOW_SORTED_ARG.equalsIgnoreCase(commandStr)) {
                result = FindAllBooksOrderedCommand.INSTANCE;
            } else if (commandStr.startsWith(Constants.GET_BY_AUTHOR)) {
                result = new FindBookByAuthorCommand(Utilities.getParamValueOrNull(commandStr));
            } else if (commandStr.startsWith(Constants.GET_BY_ISBN)) {
                result = new FindBookByIsbnCommand(Utilities.getParamValueOrNull(commandStr));
            }
        }

        return result;
    }

}
