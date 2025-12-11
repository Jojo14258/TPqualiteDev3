package Controller;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import Model.Group;
import Model.Shape;
import Model.ShapeManager;

public class Controller_ungroup {
     private final ShapeManager data;
    
    public Controller_ungroup(ShapeManager d) {
        this.data = d;
    }
    
    public void control(TreePath[] paths) {
        System.out.println("=== UNGROUP DEBUG ===");
        System.out.println("Nombre de sélections: " + (paths == null ? "null" : paths.length));
        
        if (paths == null || paths.length == 0) {
            System.out.println("Aucune sélection");
            return;
        }
        
        // Traiter chaque groupe sélectionné
        for(TreePath path : paths){
            System.out.println("\n--- Traitement d'un élément ---");
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
            Object userObject = node.getUserObject();
            
            System.out.println("Type: " + userObject.getClass().getSimpleName());
            
            // Vérifier que c'est un groupe
            if(!(userObject instanceof Group)){
                System.out.println("-> Ignoré: pas un groupe");
                continue;
            }
            
            Group groupToUngroup = (Group) userObject;
            
            // Récupérer le parent du groupe (où est situé le groupe actuellement)
            TreePath parentPath = path.getParentPath();
            if(parentPath == null){
                System.out.println("-> Ignoré: C'EST LA RACINE (pas de parent)");
                continue;
            }
            
            DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) parentPath.getLastPathComponent();
            Object parentObject = parentNode.getUserObject();
            
            if(!(parentObject instanceof Group)){
                System.out.println("-> Ignoré: parent pas un groupe");
                continue;
            }
            
            Group parent = (Group) parentObject;
            
            // Vérifier si le groupe sélectionné EST la racine (path.getPathCount() == 1)
            if(path.getPathCount() == 1){
                System.out.println("-> Ignoré: C'EST LA RACINE du modèle, on ne peut pas dissocier");
                continue;
            }
            
            // Récupérer tous les enfants du groupe
            ArrayList<Shape> children = groupToUngroup.getChildren();
            System.out.println("Nombre d'enfants: " + children.size());
            
            // Retirer le groupe de son parent
            parent.remove(groupToUngroup);
            System.out.println("Groupe retiré du parent");
            
            // Ajouter tous les enfants au même parent (pas au grandParent !)
            for(Shape child : children){
                parent.add(child);
                System.out.println("Enfant ajouté au parent: " + child.getType());
            }
            
            System.out.println("-> UNGROUP RÉUSSI");
        }
        
        // Notifier une seule fois après tous les changements
        System.out.println("\nNotification des observers...");
        this.data.notifyChange();
    }
}
