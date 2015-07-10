package com.hw.edgy.input;

public class KeyPressedStruct {
    public boolean pressed;
    public KeyPressedCommandInterface command;

    public KeyPressedStruct(KeyPressedCommandInterface command) {
        this.command = command;
        pressed = false;
    }
}
