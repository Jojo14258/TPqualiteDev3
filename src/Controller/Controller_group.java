package Controller;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import Model.Group;
import Model.Shape;
import Model.ShapeManager;

public class Controller_group {
    private final ShapeManager data;
    
    public Controller_group(ShapeManager d) {
        this.data = d;
    }
    
    public void control(TreePath[] paths) {
        if (paths == null || paths.length < 2) {
            return;
        }
        
        ArrayList<Shape> shapesToGroup = new ArrayList<>();
        ArrayList<Group> parents = new ArrayList<>();

        for(TreePath path : paths){
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
            Object userObject = node.getUserObject();
            
            if(userObject instanceof Shape){
                Shape shape = (Shape) userObject;
                shapesToGroup.add(shape);
                
                TreePath parentPath = path.getParentPath();
                DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) parentPath.getLastPathComponent();
                Object parentObject = parentNode.getUserObject();
                
                if(parentObject instanceof Group){
                    Group parent = (Group) parentObject;
                    parents.add(parent);
                }
            }
        }
        
        Group firstParent = parents.get(0);
        boolean sameParent = true;
        for(Group parent : parents){
            if(parent != firstParent){
                sameParent = false;
                break;
            }
        }
        
        Group newGroup = new Group(java.awt.Color.BLACK);
        
        for(int i = 0; i < shapesToGroup.size(); i++){
            Shape shape = shapesToGroup.get(i);
            Group parent = parents.get(i);
            parent.remove(shape);
            newGroup.add(shape);
        }
        
        // Ajouter le groupe au bon endroit
        if(sameParent){
            firstParent.add(newGroup);
            this.data.notifyChange();
        } else {
            this.data.add(newGroup);
        }
    }
}
