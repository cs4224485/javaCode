package com.harry.command;

public class TVOffCommand implements Command{

    private TVReceiver tv;

    // 构造器
    public TVOffCommand(TVReceiver tv) {
        super();
        this.tv = tv;
    }
    @Override
    public void execute() {
        tv.off();
    }
    @Override
    public void undo() {
        tv.on();
    }

}
