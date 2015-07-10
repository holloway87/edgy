package com.hw.edgy.command;

import com.hw.edgy.Shape;
import com.hw.edgy.input.KeyTypedCommandInterface;

public class ShapeToggleWireframeCommand implements KeyTypedCommandInterface {
    private Shape shape;

    public ShapeToggleWireframeCommand(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void execute() {
        shape.setShowWireframe(!shape.getShowWireframe());
    }
}
