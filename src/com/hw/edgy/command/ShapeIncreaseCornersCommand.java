package com.hw.edgy.command;

import com.hw.edgy.Shape;
import com.hw.edgy.input.KeyPressedCommandInterface;

public class ShapeIncreaseCornersCommand implements KeyPressedCommandInterface {
    private Shape shape;

    public ShapeIncreaseCornersCommand(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void execute() {
        shape.setCorners((short)(shape.getCorners() +1));
    }
}
