
package com.chuangjiangx.printer;

import com.chuangjiangx.print.PrintSupport;
import com.chuangjiangx.print.impl.sunmisc.SmPrinter;
import com.chuangjiangx.print.info.PrintPaper;
import com.chuangjiangx.print.size.Print58Size;
import com.chuangjiangx.printer.command.BarcodeCommand;
import com.chuangjiangx.printer.command.CommandManager;
import com.chuangjiangx.printer.command.TextCommand;
import com.chuangjiangx.printer.command.WrapCommand;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class RNPrinterModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public RNPrinterModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNPrinter";
    }

    /**
     * 打印机初始化，对商米打印机而言只需初始化一次
     */
    @ReactMethod
    public void init() {
        PrintSupport.getInstance().init(reactContext, new SmPrinter(), new Print58Size());
    }

    /**
     * @param text     打印文本内容
     * @param isCenter 文字是否剧中
     * @param isLarge  文字是否加大
     */
    @ReactMethod
    public void addText(String text, boolean isCenter, boolean isLarge) {
        CommandManager.getInstance().add(new TextCommand(text, isCenter, isLarge));
    }

    /**
     * 添加空白行
     */
    @ReactMethod
    public void addWrapLine() {
        CommandManager.getInstance().add(new WrapCommand());
    }

    /**
     * 打印条码
     *
     * @param code 条码内容
     */
    @ReactMethod
    public void addBarcode(String code) {
        CommandManager.getInstance().add(new BarcodeCommand(code));
    }

    /**
     * 开始打印
     */
    @ReactMethod
    public void startPrint() {
        PrintPaper printPaper = CommandManager.getInstance().buildPrintPage();
        CommandManager.getInstance().clear();
        PrintSupport.getInstance().print(printPaper);
    }
}