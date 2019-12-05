package com.chuangjiangx.printer.command;

import com.chuangjiangx.print.info.PrintPaper;

public class BarcodeCommand implements ICommand {
    private String code;

    public BarcodeCommand(String code) {
        this.code = code;
    }

    @Override
    public PrintPaper.Builder command(PrintPaper.Builder builder) {
        return builder.addBarCode(code);
    }
}
