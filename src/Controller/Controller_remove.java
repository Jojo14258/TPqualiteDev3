package Controller;

import Model.Shape;
import Model.ShapeManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class Controller_remove {
    private final ShapeManager data;
    
    public Controller_remove(ShapeManager d)
    {
        this.data = d;
    }

    public void control(TreePath[] paths){
        for(TreePath path : paths){
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
            
            Object userObject = node.getUserObject();
            
            if(userObject instanceof Shape){
                this.data.remove((Shape) userObject);
            }
        }
    }
}
