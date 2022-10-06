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
            System.out.print(node.data+" ");
            displayInOrder(node.right);  
        }   
    }

    void displayPreOrder(MyNode node){
        if(node!=null){ 
            System.out.print(node.data+" ");
            displayPreOrder(node.left);
            displayPreOrder(node.right);  
        } 
    }

    void delete(int key){
        MyNode ptr = root;
        MyNode prev = null;
        int flag = 0;
        while(key!=ptr.data){
            prev = ptr;
            if(ptr==null){
                System.out.println("Number not found!");
                break;
            }
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
            prev = ptr;
            while(qtr.left!=null){
                prev = qtr;
                qtr = qtr.left;
            }
            int temp = qtr.data;
            qtr.data = ptr.data;
            ptr.data = temp;
            if(prev.left==qtr){
                prev.left = qtr.right;
            }
            else if(prev.right==qtr){
                prev.right = qtr.right;
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
        }
    }
}
public class bstexp5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree tree = new BinarySearchTree();
        int flag = 0,data,key;
        while(flag!=3){
            System.out.println("\nWhat do you want to perform:\n1 - Insertion\n2 - Deletion\n3 - Exit the code");
            flag = sc.nextInt();
            switch(flag){
                case 1:
                    System.out.println("Input data:");
                    data = sc.nextInt();
                    tree.insert(data);
                    System.out.print("In Order: ");
                    tree.displayInOrder(tree.root);
                    System.out.print("\n");
                    System.out.print("Pre Order: ");
                    tree.displayPreOrder(tree.root);
                    System.out.print("\n");
                    break;
                case 2:
                    System.out.println("Input data to be deleted:");
                    key = sc.nextInt();
                    tree.delete(key);
                    System.out.print("In Order: ");
                    tree.displayInOrder(tree.root);
                    System.out.print("\n");
                    System.out.print("Pre Order: ");
                    tree.displayPreOrder(tree.root);
                    System.out.print("\n");
                default:
                    break;
            }
        }
        
        sc.close();
    }
}
