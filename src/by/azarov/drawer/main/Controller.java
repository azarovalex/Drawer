package by.azarov.drawer.main;

import by.azarov.drawer.shapes.*;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.awt.geom.Point2D;

public class Controller {
    @FXML
    private Canvas mainCanvas;

    private Shape currentShape;
    private ListOfShapes stack = new ListOfShapes();
    private ShapeCreator shapeCreator = new ShapeCreator("Line");
    private GraphicsContext gc;


    public void initialize() {
        gc = mainCanvas.getGraphicsContext2D();
        gc.strokeRect(0, 0, mainCanvas.getWidth(), mainCanvas.getHeight());
    }

    // Drawing on Canvas
    public void mousePressed(MouseEvent mouseEvent) {
        currentShape = shapeCreator.create();
        currentShape.setFirstPoint(new Point2D.Double(mouseEvent.getX(), mouseEvent.getY()));
    }

    public void mouseDragged(MouseEvent mouseEvent) {
        currentShape.setSecondPoint(new Point2D.Double(mouseEvent.getX(), mouseEvent.getY()));
        clearCanvas(null);
        stack.drawOn(gc);
        currentShape.drawOn(gc);

    }

    public void mouseReleased(MouseEvent mouseEvent) {
        currentShape.setSecondPoint(new Point2D.Double(mouseEvent.getX(), mouseEvent.getY()));
        currentShape.drawOn(gc);
        stack.push(currentShape);
        currentShape = null;
    }

    public void undoBtnWasClicked() {
        clearCanvas(null);
        stack.pop();
        stack.drawOn(gc);
    }

    public void shapeBtnWasClicked(MouseEvent event) {
        shapeCreator.setCurrentFactory(((Button) event.getSource()).getId());
    }

    public void clearCanvas(MouseEvent event) {
        gc.clearRect(1, 1, mainCanvas.getWidth() - 2, mainCanvas.getHeight() - 2);
        if (event != null) {
            stack = new ListOfShapes();
        }
    }

    public void drawAllFigures() {
        ListOfShapes demoList = new ListOfShapes();

        Line demoLine = new Line();
        demoLine.setFirstPoint(new Point2D.Double(10, 10));
        demoLine.setSecondPoint(new Point2D.Double(100, 100));
        demoList.push(demoLine);

        Oval demoOval = new Oval();
        demoOval.setFirstPoint(new Point2D.Double(110, 10));
        demoOval.setSecondPoint(new Point2D.Double(200, 100));
        demoList.push(demoOval);

        Rectangle demoRectangle = new Rectangle();
        demoRectangle.setFirstPoint(new Point2D.Double(210, 10));
        demoRectangle.setSecondPoint(new Point2D.Double(300, 100));
        demoList.push(demoRectangle);

        RightTriangle demoRightTriangle = new RightTriangle();
        demoRightTriangle.setFirstPoint(new Point2D.Double(310, 10));
        demoRightTriangle.setSecondPoint(new Point2D.Double(400, 100));
        demoList.push(demoRightTriangle);

        Triangle demoTriangle = new Triangle();
        demoTriangle.setFirstPoint(new Point2D.Double(510, 10));
        demoTriangle.setSecondPoint(new Point2D.Double(600, 100));
        demoList.push(demoTriangle);

        demoList.drawOn(gc);
    }
}
