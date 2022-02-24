package designpattern.decorator;

public class ShapeFillDecorator extends ShapeDecorator {
    String color;

    public ShapeFillDecorator(Shape shape, String color) {
        super(shape);
        this.color = color;
    }

    @Override
    public void draw() {
        this.shapeToBeDecorated.draw();
        System.out.println("also filling the shape with the color "+ this.color );
    }
}
