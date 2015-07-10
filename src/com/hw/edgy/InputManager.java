package com.hw.edgy;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputManager implements KeyListener {
    public static final int ROTATE_LEFT = 0;
    public static final int ROTATE_RIGHT = 1;
    public static final int CORNERS_UP = 2;
    public static final int CORNERS_DOWN = 3;

    private boolean states[];

    public InputManager() {
        int length = 4;
        states = new boolean[length];
        for (int i = 0; i < length; i++)
        {
            states[i] = false;
        }
    }

    public boolean getState(int key)
    {
        return states[key];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                states[ROTATE_LEFT] = true;
                break;
            case KeyEvent.VK_RIGHT:
                states[ROTATE_RIGHT] = true;
                break;
            case KeyEvent.VK_UP:
                states[CORNERS_UP] = true;
                break;
            case KeyEvent.VK_DOWN:
                states[CORNERS_DOWN] = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                states[ROTATE_LEFT] = false;
                break;
            case KeyEvent.VK_RIGHT:
                states[ROTATE_RIGHT] = false;
                break;
            case KeyEvent.VK_UP:
                states[CORNERS_UP] = false;
                break;
            case KeyEvent.VK_DOWN:
                states[CORNERS_DOWN] = false;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
