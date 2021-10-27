public class AVL{
     
     static class Node{
         int data;
         Node left;
         Node right;
         Node(){}
         Node(int data){
             this.data = data;
         }
     }

     public static void display(Node root) {
        if(root == null) {
            return;
        }

        String str = " <- "+ root.data + " -> ";
        String l = (root.left != null) ?  (root.left.data + "") : (".");
        String r = (root.right != null) ? (root.right.data + ""): (".");

        System.out.println(l + str + r);

        display(root.left);
        display(root.right); 
    }

    public static Node add(Node root, int data){
        if(root == null){
            Node addit = new Node(data);
            return addit;
        }
        if(data < root.data){
            root.left = add(root.left,data);
        }
        else if(data > root.data){
            root.right = add(root.right,data);
        }
        return root;
    }

    public static void main(String[] args){
        Node root = null;
        
        root = add(root, 10);
        add(root, 30);
        add(root, 40);
        add(root, 35);
        add(root, 90);
        add(root, 50);

        display(root);
    }
}