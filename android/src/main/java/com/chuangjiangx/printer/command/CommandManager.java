package com.chuangjiangx.printer.command;

import com.chuangjiangx.print.info.PrintPaper;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {

    private static CommandManager sInstance = new CommandManager();

    public static CommandManager getInstance() {
        return sInstance;
    }

    private List<ICommand> commands = new ArrayList<>();


    public void add(ICommand command) {
        commands.add(command);
    }

    public PrintPaper buildPrintPage() {
        PrintPaper.Builder builder = new PrintPaper.Builder();
        for (ICommand command : commands) {
            builder = command.command(builder);
        }
        return builder.build();
    }

    public void clear() {
        commands.clear();
    }
}
