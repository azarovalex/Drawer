package by.azarov.drawer.shapes;

public class ShapeCreator {

    private String creatingType;

    public ShapeCreator(String creatingType) {
        this.creatingType = creatingType;
    }

    public Shape create() {
        switch (this.creatingType) {
            case "Line":
                return new Line();
            case "Rectangle":
                return new Rectangle();
            case "Oval":
                return new Oval();
            case "RightTriangle":
                return new RightTriangle();
            case "Triangle":
                return new Triangle();
        }
        return null;
    }

    public void setCreatingType(String creatingType) {
        this.creatingType = creatingType;
    }
}
