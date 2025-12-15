package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.tree.DefaultMutableTreeNode;

public class Rectangle extends Shape {
    private Point center;
    private double width;
    private double height;

    public Rectangle(Point p, Color c) {
        super(c);
        center = p;
        width = 150;
        height = 100;
    }

    public java.awt.Rectangle getBox() {
        return new java.awt.Rectangle((int)(center.x), (int)(center.y), (int)(width), (int)(height));
    }

    public String getType() {
        return "Rectangle";
    }

    public String toString(int padding) {
        String indentation = " ".repeat(padding * 2);
        String str = new String();
        
        str += indentation + getType() + "(" + center + ")";
        
        return str;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(center.x, center.y, (int)width, (int)height);
        g.setColor(Color.black);
        g.drawRect(center.x, center.y, (int)width, (int)height);
    }
    
    // Getters pour accéder aux propriétés
    public Point getCenter() {
        return center;
    }
    
    public double getWidth() {
        return width;
    }
    
    public double getHeight() {
        return height;
    }
    
    public Color getColor() {
        return color;
    }

    public DefaultMutableTreeNode getJTreeNodes() {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(getType() + "(Center[" + center.x + ", " + center.y + "], Width[" + width + "], Height[" + height + "]");
        node.setUserObject(this);
        return node;
    }
}
