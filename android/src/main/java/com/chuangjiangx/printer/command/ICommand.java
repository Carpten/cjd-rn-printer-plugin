package com.chuangjiangx.printer.command;

import com.chuangjiangx.print.info.PrintPaper;

public interface ICommand {
    PrintPaper.Builder command(PrintPaper.Builder builder);
}
