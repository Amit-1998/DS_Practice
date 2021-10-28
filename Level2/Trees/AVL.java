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
        // after adding the node
        update_Height_bf(root); // update the bfs of node to whom right or left it is added and update in postarea upwards
        return checkAndSolve(root); // type of Problem
        // return root;
    }

    public static Node solveRR(Node node){
        // we have to do left rotation at node's right child
        Node rc = node.right; // right child of node
        Node temp = rc.left;  // left child of rc

        rc.left = node;
        node.right = temp;

        return rc;
    }

    public static Node solveLL(Node node){
        // we have to do right rotation at node's left child
        Node lc = node.left; // left child of node
        Node temp = lc.right; // right child of lc
        lc.right = node;
        node.left = temp;

        return lc;
    }

    // public static Node leftRotation(Node node){

    // }

    // public static Node rightRotation(Node node){

    // }

    public static Node checkAndSolve(Node node){
        if(node.bf>1 || node.bf<-1){
            // problem is detected, identify and then solve it
            if(node.bf>0){
                // problem starts with 'L'
                 if(node.left.bf>0){
                    // LL problem
                    return solveLL(node); 
                 }
                 else{
                     // LR problem
                     //First Layer -> solve RR problem at node's left child
                     node.left = solveRR(node.left);
                     return solveLL(node);
                 }
            }
            else{
                // problem starts with 'R'
                if(node.right.bf<0){
                   // RR problem
                   return solveRR(node);
                }
                else{
                   // RL problem
                   node.right = solveLL(node.right);
                   return solveLL(node);
                }
            }
        }

        return node;
    }

    public static void update_Height_bf(Node node){
         if(node == null){
             return; 
         }
        //  update_Height_bf(root.left);
        //  update_Height_bf(root.right);

         int lht = (node.left==null)?-1:node.left.ht;
         int rht = (node.right==null)?-1:node.right.ht;

         int meriHt = Math.max(lht,rht)+1;
         int merabf = lht-rht;

         node.ht = meriHt;
         node.bf = merabf;
    }

    public static void main(String[] args){
        Node root = null;
        
        // root = add(root, 10);
        // subsequent additon mein root node change ho sakti hai so do like this
        // root = add(root, 30);
        // root = add(root, 40);
        // root = add(root, 35);
        // root = add(root, 90);
        // root = add(root, 50);
        // so rathan than calling every time and change root do store add nodes in an array
        int[] arr = {10,30,40,35,90,50,8};
        for(int i=0; i<arr.length; i++){
            root = add(root, arr[i]);
        }
        display(root);
    }
}