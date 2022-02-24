package designpattern.decorator;

public abstract class ShapeDecorator implements Shape {
    Shape shapeToBeDecorated;

    public ShapeDecorator(Shape shapeToBeDecorated) {
        this.shapeToBeDecorated = shapeToBeDecorated;
    }


}
