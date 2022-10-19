import java.util.Scanner;
class MyNode{
    char operand;
    MyNode left, right;
    MyNode(char operand){
        this.operand = operand;
        left = null;
        right = null;
    }
}

class StackandTree{
    MyNode[] stack = new MyNode[50];
    int top = -1;
    void push(MyNode operand){
        top++;
        stack[top] = operand;
    }
    MyNode pop(){
        MyNode popedNode = stack[top];
        top--;
        return popedNode;
    }
    void displayInOrder(MyNode root){
        if(root!=null){
            displayInOrder(root.left);
            System.out.print(root.operand);
            displayInOrder(root.right);
        }
    }
}
public class myeExpTree {
    static boolean isOperand(char ch){
        if(((int)ch - 48)>=0 && ((int)ch - 48)<10)
            return true;
        else   
            return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackandTree stack = new StackandTree();
        int operand = 0,operator = 0;
        System.out.println("Enter the postfix expression:");
        String exp = sc.nextLine();
        for(int i=0;i<exp.length();i++){
            if(isOperand(exp.charAt(i)))
                operand++;
            else
                operator++;
        }
        if (operand != (operator+ 1)) {
	        System.out.println("Invalid expression");
	        System.exit(0);
        }
        MyNode parent = null;
        for (int i = 0; i < exp.length(); i++) {
	        parent = new MyNode(exp.charAt(i));
	        if (isOperand(exp.charAt(i)))
                stack.push(parent);
            else {
                if (stack.top >= 1) {
		            MyNode newnodeA = stack.pop();
		            MyNode newnodeB = stack.pop();
		            parent.right = newnodeA;
		            parent.left = newnodeB;
		            stack.push(parent);
	            }
	            else {
		            System.out.println("Invalid expression");
		            System.exit(0);
	            }
            }
        }
        System.out.println("The required infix expression:");
        stack.displayInOrder(parent);
        sc.close();
    }
}
