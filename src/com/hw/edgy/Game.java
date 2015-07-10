package com.hw.edgy;

import java.awt.Color;
import java.awt.Graphics;

public class Game {
    private Shape shape;

    public Game() {
        shape = new Shape();
    }

    public void checkKeys(InputManager input) {
        if (input.getState(InputManager.ROTATE_LEFT)) {
            shape.setRotateAngle(shape.getRotateAngle() - 1);
        } else if (input.getState(InputManager.ROTATE_RIGHT)) {
            shape.setRotateAngle(shape.getRotateAngle() + 1);
        }

        if (input.getState(InputManager.CORNERS_UP)) {
            shape.setCorners((short)(shape.getCorners() + 1));
        } else if (input.getState(InputManager.CORNERS_DOWN)) {
            shape.setCorners((short)(shape.getCorners() - 1));
        }
    }

    public void draw(Graphics g) {
        shape.draw(g);

        g.setColor(Color.white);
        g.drawString(String.format("Angel: %03d°", (int) shape.getRotateAngle()), 20, 35);
        g.drawString(String.format("Corners: %03d", shape.getCorners()), 20, 50);
    }
}
