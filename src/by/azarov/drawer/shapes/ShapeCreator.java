package by.azarov.drawer.shapes;

import java.util.HashMap;
import java.util.Map;

public class ShapeCreator {

    private ShapeFactory currentFactory;
    private Map<String, ShapeFactory> factories = new HashMap<>();

    public ShapeCreator(String currentFactory) {
        factories.put("Line", new LineFactory());
        factories.put("Rectangle", new RectangleFactory());
        factories.put("Oval", new OvalFactory());
        factories.put("RightTriangle", new RightTriangleFactory());
        factories.put("Triangle", new TriangleFactory());
        this.currentFactory = factories.get(currentFactory);
    }

    public Shape create() {
        return currentFactory.createShape();
    }

    public void setCurrentFactory(String currentFactory) {
        this.currentFactory = factories.get(currentFactory);
    }
}


abstract class ShapeFactory {
    public abstract Shape createShape();
}

class LineFactory extends ShapeFactory {

    @Override
    public Shape createShape() {
        return new Line();
    }
}

class OvalFactory extends ShapeFactory {

    @Override
    public Shape createShape() {
        return new Oval();
    }
}

class RectangleFactory extends ShapeFactory {

    @Override
    public Shape createShape() {
        return new Rectangle();
    }
}

class RightTriangleFactory extends ShapeFactory {
    @Override
    public Shape createShape() {
        return new RightTriangle();
    }
}

class TriangleFactory extends ShapeFactory {
    @Override
    public Triangle createShape() {
        return new Triangle();
    }
}
