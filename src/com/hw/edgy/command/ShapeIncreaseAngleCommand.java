package com.hw.edgy.command;

import com.hw.edgy.Shape;
import com.hw.edgy.input.KeyPressedCommandInterface;

public class ShapeIncreaseAngleCommand implements KeyPressedCommandInterface {
    private Shape shape;

    public ShapeIncreaseAngleCommand(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void execute() {
        shape.setRotateAngle(shape.getRotateAngle() +1);
    }
}
