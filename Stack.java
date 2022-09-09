import java.util.Scanner;
import java.util.Arrays;
class MyCode{
    int changeToInt(char c){
        int num = (int)c - 48;
        return num;
    }
    void push(int [] arr,int top,int key){
        arr[top] = key;
        System.out.println("The Stack is: "+Arrays.toString(arr));
        System.out.println();
    }
    void pop(int [] arr,int top){
        arr[top] = 0;
    }
}
public class Stack {
    public static void main(String[] args){
        MyCode ob = new MyCode();
        Scanner sc = new Scanner(System.in);
        int i,sum,dif,multi,div;
        System.out.println("Enter the postfix expression:");
        String exp = sc.nextLine();
        int[] myStack = new int[exp.length()];
        int top = -1;
        top++;
        myStack[top] = ob.changeToInt(exp.charAt(0));
        System.out.println("Solution:\n-------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\nInitially top = -1\nAfter pushing the first Operand - "+exp.charAt(0)+" into the stack:\ntop = 0");
        System.out.println("The Stack will be: "+Arrays.toString(myStack));
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
        top++;
        for(i=1;i<exp.length();i++){
            if(Character.isDigit(exp.charAt(i))){
                System.out.println("Operand "+exp.charAt(i)+" will get pushed into the stack\nTherefore, top = "+top);
                ob.push(myStack,top,ob.changeToInt(exp.charAt(i)));
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
                top++;
            }
            else if(exp.charAt(i)=='+'){
                //System.out.println("top: "+top);
                sum = myStack[top-2] + myStack[top-1];
                System.out.println("As we encountered the '+' operator, 2 operands(top operand and the operand before the top) from the stack are popped out and the summation of the 2 operands is again pushed into the stack");
                System.out.printf("%d + %d = %d\n",myStack[top-2],myStack[top-1],sum);
                myStack[top-1] = 0;
                myStack[top-2] = sum;
                System.out.println("top = "+(top-2));
                System.out.println("The Stack is: "+Arrays.toString(myStack));
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
                System.out.println();
                top --;
            }
            else if(exp.charAt(i)=='-'){
                dif = myStack[top-2] - myStack[top-1];
                System.out.println("As we encountered the '-' operator, 2 operands(top operand and the operand before the top) from the stack are popped out and the differnece of the 2 operands is again pushed into the stack");
                System.out.printf("%d - %d = %d\n",myStack[top-2],myStack[top-1],dif);
                myStack[top-1] = 0;
                myStack[top-2] = dif;
                System.out.println("top = "+(top-2));
                System.out.println("The Stack is: "+Arrays.toString(myStack));
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
                System.out.println();
                top --;
            }
            else if(exp.charAt(i)=='*'){
                multi = myStack[top-2] * myStack[top-1];
                System.out.println("As we encountered the '*' operator, 2 operands(top operand and the operand before the top) from the stack are popped out and the multiplication of the 2 operands is again pushed into the stack");
                System.out.printf("%d * %d = %d\n",myStack[top-2],myStack[top-1],multi);
                myStack[top-1] = 0;
                myStack[top-2] = multi;
                System.out.println("top = "+(top-2));
                System.out.println("The Stack is: "+Arrays.toString(myStack));
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
                System.out.println();
                top --;
            }
            else if(exp.charAt(i)=='/'){
                div = myStack[top-2] / myStack[top-1];
                System.out.println("As we encountered the '/' operator, 2 operands(top operand and the operand before the top) from the stack are popped out and the div of the 2 operands is again pushed into the stack");
                System.out.printf("%d / %d = %d\n",myStack[top-2],myStack[top-1],div);
                myStack[top-1] = 0;
                myStack[top-2] = div;
                System.out.println("top = "+(top-2));
                System.out.println("The Stack is: "+Arrays.toString(myStack));
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
                System.out.println();
                top --;
            }
        }
        top--;
        System.out.println("The answer is ["+myStack[top]+"] which is the only operand left in the stack at the end of the expression.");
        sc.close();
    }
}
