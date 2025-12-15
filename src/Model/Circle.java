/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.tree.DefaultMutableTreeNode;
/**
 *
 * @author adrien.peytavie
 */
public class Circle extends Shape {
    private Point center;
    private double radius;

    
    public Circle(Point p, Color c){
       super(c);
       center = p;
       radius = 100;
    }
    
    public Rectangle getBox()
    {
        return new Rectangle((int)(center.x), (int)(center.y ), (int)(radius), (int)( radius)); 
    }
   
    public String getType()
    {
        return "Circle"; 
    }

    public String toString(int padding) {
        String indentation = " ".repeat(padding * 2);
        String str = new String();
        
        str += indentation + getType() + "(" + center +")";
        
        return str;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(center.x,center.y,(int)radius,(int)radius);
        g.setColor(Color.black);
        g.drawOval(center.x,center.y,(int)radius,(int)radius);
    }
    
    // Getters pour accéder aux propriétés
    public Point getCenter() {
        return center;
    }
    
    public double getRadius() {
        return radius;
    }
    
    public Color getColor() {
        return color;
    }

    public DefaultMutableTreeNode getJTreeNodes() {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(getType()+ "(Center["+center.x+", "+center.y +"], R["+radius+"]");
        node.setUserObject(this);
        return node;
    }
}
