package by.azarov.drawer.shapes;

import javafx.scene.canvas.GraphicsContext;

public class StackOfShapes implements Drawable {
    private Shape[] arrayOfShapes;
    private int pointer;

    public StackOfShapes() {
        arrayOfShapes = new Shape[256];
        pointer = 0;
    }

    public void push(Shape shape) {
        arrayOfShapes[pointer++] = shape;
    }

    public void pop() {
        if (pointer > 0) {
            pointer -= 1;
        }

    }

    @Override
    public void drawOn(GraphicsContext gc) {
        for (int i = 0; i < pointer; i++) {
            arrayOfShapes[i].drawOn(gc);
        }
    }
}