package com.hw.edgy;

import com.hw.edgy.input.KeyPressedCommandInterface;
import com.hw.edgy.input.KeyTypedCommandInterface;
import com.hw.edgy.input.KeyPressedStruct;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;

public class InputManager implements KeyListener {
    private HashMap<Integer, ArrayList<KeyPressedStruct>> keyPressedCommands;
    private HashMap<Character, ArrayList<KeyTypedCommandInterface>> keyTypedCommands;

    public InputManager() {
        keyPressedCommands = new HashMap<Integer, ArrayList<KeyPressedStruct>>();
        keyTypedCommands = new HashMap<Character, ArrayList<KeyTypedCommandInterface>>();
    }

    public void addKeyPressedCommand(int keyCode, KeyPressedCommandInterface command) {
        ArrayList<KeyPressedStruct> commands;

        commands = keyPressedCommands.get(keyCode);
        if (null == commands) {
            commands = new ArrayList<KeyPressedStruct>();
            keyPressedCommands.put(keyCode, commands);
        }

        commands.add(new KeyPressedStruct(command));
    }

    public void addKeyTypedCommand(char keyChar, KeyTypedCommandInterface command) {
        ArrayList<KeyTypedCommandInterface> commands;

        commands = keyTypedCommands.get(keyChar);
        if (null == commands) {
            commands = new ArrayList<KeyTypedCommandInterface>();
            keyTypedCommands.put(keyChar, commands);
        }

        commands.add(command);
    }

    public void executePressedCommands() {
        for (ArrayList<KeyPressedStruct> commands: keyPressedCommands.values()) {
            for (KeyPressedStruct command: commands) {
                if (command.pressed) {
                    command.command.execute();
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        ArrayList<KeyPressedStruct> commands = keyPressedCommands.get(e.getKeyCode());
        if (null != commands) {
            for (KeyPressedStruct command: commands) {
                command.pressed = true;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        ArrayList<KeyPressedStruct> commands = keyPressedCommands.get(e.getKeyCode());
        if (null != commands) {
            for (KeyPressedStruct command: commands) {
                command.pressed = false;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        ArrayList<KeyTypedCommandInterface> commands = keyTypedCommands.get(e.getKeyChar());
        if (null != commands) {
            for (KeyTypedCommandInterface command: commands) {
                command.execute();
            }
        }
    }
}
