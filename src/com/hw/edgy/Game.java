package com.hw.edgy;

import com.hw.edgy.command.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Game {
    private Shape shape;

    public Game() {
        shape = new Shape();
    }

    public void draw(Graphics g) {
        shape.draw(g);

        g.setColor(Color.white);
        g.drawString(String.format("Angel: %03d°", (int) shape.getRotateAngle()), 20, 35);
        g.drawString(String.format("Corners: %03d", shape.getCorners()), 20, 50);
    }

    public void registerInput(InputManager input) {
        input.addKeyPressedCommand(KeyEvent.VK_RIGHT, new ShapeIncreaseAngleCommand(shape));
        input.addKeyPressedCommand(KeyEvent.VK_LEFT, new ShapeDecreaseAngelCommand(shape));
        input.addKeyPressedCommand(KeyEvent.VK_UP, new ShapeIncreaseCornersCommand(shape));
        input.addKeyPressedCommand(KeyEvent.VK_DOWN, new ShapeDecreaseCornersCommand(shape));

        input.addKeyTypedCommand('w', new ShapeToggleWireframeCommand(shape));
    }
}
