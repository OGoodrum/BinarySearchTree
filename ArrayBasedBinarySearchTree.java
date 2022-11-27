public class ArrayBasedBinarySearchTree extends ArrayBasedBinaryTree{

    public ArrayBasedBinarySearchTree(){
        this.data = new Integer[100];
        root = 0;
        size = 0;
    }
    
    
    public void insert(Integer value){
        int index = 0;
        while(data[index] != null){
            if(value.compareTo(data[index]) > 0){
                index = getRight(index);
            } else if(value.compareTo(data[index]) < 0){
                index = getLeft(index);
            }
        }

        data[index] = value;
        size ++;
    }


    
    public static void main(String[] args) {
        ArrayBasedBinarySearchTree emptyTree = new ArrayBasedBinarySearchTree();
        
        ArrayBasedBinarySearchTree myTree = new ArrayBasedBinarySearchTree();
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
    }

}
