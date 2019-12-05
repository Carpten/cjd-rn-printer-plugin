package com.chuangjiangx.printer.command;

import com.chuangjiangx.print.info.PrintPaper;

public class TextCommand implements ICommand {

    private String text;
    private boolean isCenter;
    private boolean isLarge;

    public TextCommand(String text, boolean isCenter, boolean isLarge) {
        this.text = text;
        this.isCenter = isCenter;
        this.isLarge = isLarge;
    }

    @Override
    public PrintPaper.Builder command(PrintPaper.Builder builder) {
        if (isCenter && isLarge) {
            return builder.addTitle(text);
        } else if (isCenter) {
            return builder.addCenterTxt(text);
        } else {
            return builder.addTxt(text);
        }
    }
}
