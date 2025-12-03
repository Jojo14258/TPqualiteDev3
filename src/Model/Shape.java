package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Classe abstraite Shape - Design Pattern Composite
 * @author adrien.peytavie
 */
public abstract class Shape {
    protected Color color;
    
    public Shape(Color c) {
        this.color = c;
    }
    
    /**
     * Retourne la boîte englobante de la forme
     */
    public abstract Rectangle getBox();
    
    /**
     * Retourne le type de la forme
     */
    public abstract String getType();
    
    /**
     * Représentation textuelle de la forme
     */
    public abstract String toString(int padding);
    
    /**
     * Dessine la forme
     */
    public abstract void draw(Graphics g);
    
    /**
     * Retourne la représentation JTree de la forme
     */
    public abstract DefaultMutableTreeNode getJTreeNodes();
}
