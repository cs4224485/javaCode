package com.harry.command;

public class LightOnCommand implements Command{

    LightReceiver light;

    public LightOnCommand(LightReceiver lightReceiver) {
        this.light = lightReceiver;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
