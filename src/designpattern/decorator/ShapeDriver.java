package designpattern.decorator;

public class ShapeDriver {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();

        ShapeDecorator redFillDecorator = new ShapeFillDecorator(circle, "red");
        redFillDecorator.draw();

        ShapeDecorator doubleThicknerDecorator = new ShapeThickenDecorator(rectangle, 2);
        doubleThicknerDecorator.draw();

        System.out.println("------------");
        //this is where the fun is, no need for inifinite nuber of subclassed to handle infine combinations.
        //just decorate away.
        ShapeDecorator  interstingMixDecorator =   new ShapeThickenDecorator(
                new ShapeFillDecorator(rectangle, "blue"), 3 );
        interstingMixDecorator.draw();
    }
}
