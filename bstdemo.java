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
        MyNode prev = null;
        int flag = 0;
        while(key!=ptr.data){
            prev = ptr;
            if(key<ptr.data){
                ptr = ptr.left;
                flag = 1;
            }
            else{
                ptr = ptr.right;
                flag = 2;
            }
        }
        if(ptr.left==null && ptr.right==null){
            if(flag==1)
                prev.left = null;
            else if(flag==2)
                prev.right = null;
        }
        else if(ptr.left==null){
            if(flag==1){
                prev.left = ptr.right;
            }
            else if(flag==2){
                prev.right = ptr.right;
            }
        }
        else if(ptr.right==null){
            if(flag==1){
                prev.left = ptr.left;
            }
            else if(flag==2){
                prev.right = ptr.left;
            }
        }
        else{
            MyNode qtr = ptr.right;
            while(qtr.left!=null){
                prev = qtr;
                qtr = qtr.left;
            }
            int temp = qtr.data;
            qtr.data = ptr.data;
            ptr.data = temp;
            prev.left = null;
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
