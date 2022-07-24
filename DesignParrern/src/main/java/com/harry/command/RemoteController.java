package com.harry.command;

public class RemoteController {
    // 开 按钮的命令数组
    Command[] onCommands;
    Command[] offCommands;

    Command undoCommand;

    public RemoteController() {
        onCommands = new Command[5];
        offCommands =  new Command[5];
        for (int i = 0; i <5 ; i++) {
            offCommands[i] = new NoCommand();
            onCommands[i] = new NoCommand();
            
        }
    }
    // 给我们的按钮设置你需要的命令
    public void setCommand(int no, Command onCommand, Command offCommand) {
        onCommands[no] = onCommand;
        offCommands[no] = offCommand;
    }

    // 按下按钮
    public void onButtonWasPushed(int no){
        // 找到按下的按钮， 并调用相应的方法
        onCommands[no].execute();
        // 记录这次的操作，用于撤销
        undoCommand = onCommands[no];
    }

    // 按下开按钮
    public void offButtonWasPushed(int no) { // no 0
        // 找到你按下的关的按钮， 并调用对应方法
        offCommands[no].execute();
        // 记录这次的操作，用于撤销
        undoCommand = offCommands[no];
    }
    // 按下撤销按钮
    public void undoButtonWasPushed() {
        undoCommand.undo();
    }

}
