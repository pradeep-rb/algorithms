package designpattern.decorator;

public class ShapeThickenDecorator extends  ShapeDecorator {

    int thickness;

    public ShapeThickenDecorator(Shape shapeToBeDecorated, int thickness) {
        super(shapeToBeDecorated);
        this.thickness = thickness;
    }

    @Override
    public void draw() {
        this.shapeToBeDecorated.draw();
        System.out.println("also making the shape thick by " + thickness);
    }
}
