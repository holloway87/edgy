package com.hw.edgy;

import java.awt.*;

public class Game {
    private Shape shape;

    public Game() {
        shape = new Shape();
    }

    public void draw(Graphics g) {
        shape.draw(g);
    }
}
