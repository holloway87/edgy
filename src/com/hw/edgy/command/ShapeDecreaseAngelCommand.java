package com.hw.edgy.command;

import com.hw.edgy.Shape;
import com.hw.edgy.input.KeyPressedCommandInterface;

public class ShapeDecreaseAngelCommand implements KeyPressedCommandInterface {
    private Shape shape;

    public ShapeDecreaseAngelCommand(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void execute() {
        shape.setRotateAngle(shape.getRotateAngle() -1);
    }
}
