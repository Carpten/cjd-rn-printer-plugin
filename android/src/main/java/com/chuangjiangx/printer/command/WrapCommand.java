package com.chuangjiangx.printer.command;

import com.chuangjiangx.print.info.PrintPaper;

public class WrapCommand implements ICommand {
    @Override
    public PrintPaper.Builder command(PrintPaper.Builder builder) {
        return builder.addWrapLine();
    }
}
