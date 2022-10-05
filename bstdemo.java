import java.util.Scanner;
class MyNode{
    int data;
    MyNode left;
    MyNode right;
}
class BinarySearchTree{
    MyNode root;
    void displayInOrder(MyNode node){
        if(node!=null){ 
            displayInOrder(node.left);
            System.out.println("Data: "+node.data);
            displayInOrder(node.right);  
        }   
    }

    void displayPreOrder(MyNode node){
        if(node!=null){ 
            System.out.println("Data: "+node.data);
            displayPreOrder(node.left);
            displayPreOrder(node.right);  
        } 
    }

    void displayPostOrder(MyNode node){
        if(node!=null){ 
            displayPostOrder(node.left);
            displayPostOrder(node.right);  
            System.out.println("Data: "+node.data);
        } 
    }

    void delete(int key){
        MyNode ptr = root;
        while(key!=ptr.data){
            if(key<ptr.data){
                ptr = ptr.left;
            }
            else{
                ptr = ptr.right;
            }
        }
        
    }

    void insert(int data){
        MyNode newnode = new MyNode();
        newnode.data = data;
        newnode.left = null;
        newnode.right = null;
        if(root==null){
            root = newnode;
        }
        else{
            MyNode ptr = root;
            MyNode prev = null;
            int flag=0;
            while(ptr!=null){
                prev = ptr;
                if(ptr.data > data){
                    ptr = ptr.left;
                    flag = 1;
                }
                else{
                    ptr = ptr.right;
                    flag = 2;
                }
            }
            if(flag==1){
                prev.left = newnode;
            }
            else if(flag==2){
                prev.right = newnode;
            }
            ptr = newnode;
        }
    }
}
public class bstdemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree tree = new BinarySearchTree();
        int data;
        for(int i=0;i<7;i++){
            data = sc.nextInt();
            tree.insert(data);
        }
        tree.displayInOrder(tree.root);
        sc.close();
    }
}
