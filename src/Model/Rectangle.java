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

    public DefaultMutableTreeNode getJTreeNodes() {
        return new DefaultMutableTreeNode(getType() + "(Center[" + center.x + ", " + center.y + "], Width[" + width + "], Height[" + height + "])");
    }
}
