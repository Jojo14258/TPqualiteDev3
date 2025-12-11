package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

public class Group  extends Shape{
    private ArrayList<Shape> listeShape;
    public Group(Color c) {
        super(c);
        listeShape = new ArrayList<Shape>();
    }

    @Override
    public Rectangle getBox() {
        if (listeShape.isEmpty()) {
            return null;
        }
        
        int xMin = Integer.MAX_VALUE;
        int yMin = Integer.MAX_VALUE;
        int xMax = Integer.MIN_VALUE;
        int yMax = Integer.MIN_VALUE;
        
        for (Shape shape : listeShape) {
            Rectangle box = shape.getBox();
            if (box != null) {
                xMin = Math.min(xMin, box.x);
                yMin = Math.min(yMin, box.y);
                xMax = Math.max(xMax, box.x + box.width);
                yMax = Math.max(yMax, box.y + box.height);
            }
        }
        
        return new Rectangle(xMin, yMin, xMax - xMin, yMax - yMin);
    }
    public ArrayList<Shape> getChildren() {
        return listeShape; 
    }
    @Override
    public String getType() {
        return "Group";
    }

    @Override
    public String toString(int padding) {
        String indentation = " ".repeat(padding * 2);
        String hierarchie = indentation + getType() + "\n";
        
        for(Shape shape : listeShape){
            hierarchie += shape.toString(padding + 1) + "\n";
        }
        
        return hierarchie;
    }

    @Override
    public void draw(Graphics g) {
        for(int i = 0; i<this.listeShape.size(); i++){
            listeShape.get(i).draw(g);
        }
    }

    @Override
    public DefaultMutableTreeNode getJTreeNodes() {
        DefaultMutableTreeNode architecture = new DefaultMutableTreeNode("Group");
        architecture.setUserObject(this);
        for(Shape shape : listeShape ){
            architecture.add(shape.getJTreeNodes());
        }
        return architecture;
    }
    
    public void add(Shape s) {
        listeShape.add(s);
    }
    
    public void remove(Shape s) {
        listeShape.remove(s);
    }
    
}
