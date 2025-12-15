/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author adrien.peytavie
 */
public class ShapeManager extends Observable {

    public Group group;
    private Shape selectedShape = null;

    public ShapeManager()
    {
        group = new Group(Color.BLACK);
    }
    
    public void init()
    {

        //  formes de test
        Circle c1 = new Circle(new Point(50, 50), Color.RED);
        Circle c2 = new Circle(new Point(150, 150), Color.BLUE);
        Square s1 = new Square(new Point(100, 200), Color.GREEN);
        
        //Sous groupes
        Group subGroup = new Group(Color.BLACK);
        subGroup.add(new Circle(new Point(200, 100), Color.YELLOW));
        subGroup.add(new Rectangle(new Point(250, 50), Color.ORANGE));
        
        // groupe racine
        group.add(c1);
        group.add(c2);
        group.add(s1);
        group.add(subGroup);
        
        System.out.println("=== Structure de l'arborescence ===");
        System.out.println(group.toString(0));
        
        setChanged();
        notifyObservers();
    }
    
    public void add(Shape shape)
    {
        group.add(shape);

        setChanged();
        notifyObservers();
    }
    
    public void remove(Shape shape)
    {
        group.remove(shape);

        setChanged();
        notifyObservers();
    }
    
    public void notifyChange()
    {
        setChanged();
        notifyObservers();
    }
    
    public void setSelectedShape(Shape shape)
    {
        this.selectedShape = shape;
        setChanged();
        notifyObservers();
    }
    
    public Shape getSelectedShape()
    {
        return this.selectedShape;
    }

    @Override
    public String toString() {
        return "Data{\n" + "  shape{\n" + group.toString(0) + "  }\n}";
    }

    public void draw(Graphics graphics) {
        group.draw(graphics);
    }
    
    public DefaultTreeModel getTreeModel() {
        return new DefaultTreeModel(group.getJTreeNodes());
    }
}
