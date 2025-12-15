package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.tree.DefaultMutableTreeNode;

public class Square extends Shape{
     private Point center;
    private double size;

    
    public Square(Point p, Color c){
       super(c);
       center = p;
       size = 100;
    }
    
    public Rectangle getBox()
    {
        return new Rectangle((int)(center.x), (int)(center.y ), (int)(size), (int)(size)); 
    }
   
    public String getType()
    {
        return "Square"; 
    }

    public String toString(int padding) {
        String indentation = " ".repeat(padding * 2);
        String str = new String();
        
        str += indentation + getType() + "(" + center +")";
        
        return str;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(center.x, center.y, (int)size, (int)size);
        g.setColor(Color.black);
        g.drawRect(center.x, center.y, (int)size, (int)size);
    }
    
    // Getters pour accéder aux propriétés
    public Point getCenter() {
        return center;
    }
    
    public double getSize() {
        return size;
    }
    
    public Color getColor() {
        return color;
    }

    public DefaultMutableTreeNode getJTreeNodes() {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(getType()+ "(Center["+center.x+", "+center.y +"], Size["+size+"]");
        node.setUserObject(this);
        return node;
    }
}
