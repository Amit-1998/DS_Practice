public class AVL{
     
     static class Node{
         int data;
         Node left;
         Node right;
         int ht; // height
         int bf; // balancing factor
         Node(){}
         Node(int data){
             this.data = data;
             this.ht = 0;
             this.bf = 0;
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
        update_Height_bf(root);
        return root;
    }

    public static void update_Height_bf(Node root){
         if(node == null){
             return; 
         }
        //  update_Height_bf(root.left);
        //  update_Height_bf(root.right);

         int lht = (root.left==null)?-1:root.left.ht;
         int rht = (root.right==null)?-1:root.right.ht;

         int meriHt = Math.max(lht,rht)+1;
         int merabf = lht-rht;

         node.ht = meriHt;
         node.bf = merabf;
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