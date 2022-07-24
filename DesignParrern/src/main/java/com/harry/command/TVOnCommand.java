package com.harry.command;

public class TVOnCommand implements Command{

    // 聚合 TVReceiver
    TVReceiver tv;

    // 构造器
    public TVOnCommand(TVReceiver tv) {
        this.tv = tv;
    }
    @Override
    public void execute() {
        tv.on();
    }
    @Override
    public void undo() {
        tv.off();
    }

}
