import java.lang.Math;
/*
 * RefBasedBinarySearchTree.java
 *
 * A ref-based BinaryTree meant to store values of type Integer
 */
public class RefBasedBinarySearchTree extends RefBasedBinaryTree {

    public RefBasedBinarySearchTree(){
        root = null;
    }

    public void insert(Integer value){
        TreeNode cur = root;
        TreeNode parent = null;
        TreeNode n = new TreeNode(value);
        if(cur == null){
            root = n;
            return;
        }
        while(cur != null){
            parent = cur;
            if(value.compareTo(cur.getValue()) > 0){
                cur = cur.getRight();
            } else if(value.compareTo(cur.getValue()) < 0){
                cur = cur.getLeft();
            }

        }

        if(value.compareTo(parent.getValue()) > 0){
            parent.setRight(n);
        } else if(value.compareTo(parent.getValue()) < 0){
            parent.setLeft(n);
        }
    }

    public int getMax() throws TreeEmptyException{
        if(root == null){
            throw new TreeEmptyException();
        }

        TreeNode cur = root;
        while(cur.getRight() != null){
            cur = cur.getRight();
        }

        return cur.getValue();
    }

    public boolean find(Integer value){
        TreeNode cur = root;
        while(cur != null){
            
            if(cur.getValue() == value){
                return true;
            } else if(value.compareTo(cur.getValue()) > 0){
                cur = cur.getRight();
            } else {
                cur = cur.getLeft();
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // use these trees to test the methods you will implement
        RefBasedBinarySearchTree emptyTree = new RefBasedBinarySearchTree();
        RefBasedBinarySearchTree myTree = new RefBasedBinarySearchTree();
        myTree.insert(2);
        myTree.insert(1);
        myTree.insert(5);
        myTree.insert(7);
        myTree.insert(0);
        myTree.insert(4);
        myTree.insert(6);
        
        System.out.println("in");
        myTree.inOrder();
        System.out.println("pre");
        myTree.preOrder();
        System.out.println("post");
        myTree.postOrder();
        
        System.out.println("toString\n" + myTree);
        try{
            System.out.println(emptyTree.getMax());
        } catch (TreeEmptyException e){
            System.out.println("true");
        }

        System.out.println(emptyTree.find(7));
    }
}
