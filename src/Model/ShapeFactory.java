package Model;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

public class ShapeFactory {
    public static Shape createShape(String name, Color c ){
        Random rand = new Random(System.currentTimeMillis());
        Shape forme = null;
        if(name.equals("Circle")){
            forme = new Circle(new Point(rand.nextInt(200), rand.nextInt(200)), c);
        }
        else if(name.equals("Square")){
            forme = new Square(new Point(rand.nextInt(200), rand.nextInt(200)), c);
        
        }
        else if(name.equals("Rectangle")){
            forme = new Rectangle(new Point(rand.nextInt(200), rand.nextInt(200)), c);
        }
        return forme;
    }
}
