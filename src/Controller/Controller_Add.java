/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Circle;
import Model.Square;
import Model.Rectangle;
import Model.ShapeFactory;
import Model.ShapeManager;
import java.awt.Color;
import java.awt.Point;
import Model.Shape; 
import java.util.Random;

/**
 *
 * @author adrien.peytavie
 */
public class Controller_Add {
    private final ShapeManager data;
   
    
    public Controller_Add(ShapeManager d)
    {
        data = d;

    }
    
    public void control(String name, Color color)
    {
        Shape shape = ShapeFactory.createShape(name, color);
        data.add(shape);
        
    }
}
