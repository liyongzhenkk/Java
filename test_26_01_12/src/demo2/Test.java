package demo2;

import javafx.scene.shape.Circle;

public class Test {
    public static void main(String[] args) {
        Shape shape = new Tri();
        Shape shape1 = new Flower();
        Shape shape2 = new Squ();

        shape.draw();
        shape1.draw();
        shape2.draw();

    }
}
