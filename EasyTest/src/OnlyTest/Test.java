package OnlyTest;
import java.nio.ByteOrder;
import java.util.EmptyStackException;
import java.util.Stack;

//sort class
class sort{
    public sort()
    {
        System.out.println("sort class!");
    }
    int bubble(int []nums)
    {
        int temp;
        System.out.println("we have " + nums.length + " numbers");
        for(int FirstCycle = 0; FirstCycle < nums.length; FirstCycle++)
        {
            for(int SecondCycle = 0; SecondCycle < nums.length - FirstCycle - 1; SecondCycle ++ )
            {
                if(nums[SecondCycle] > nums[SecondCycle + 1])
                {
                    temp = nums[SecondCycle];
                    nums[SecondCycle] = nums[SecondCycle + 1];
                    nums[SecondCycle + 1] = temp;
                }
            }
        }
        for(int tnum : nums)
        {
            System.out.print(tnum + " ");
        }
        return 0;
    }
}

//Exception Test
class Myexception extends Exception{
    public Myexception(){}
    public Myexception(String msg){
        super(msg);
    }
}


//stack test
class StackTest{

    void showpush(Stack<Integer> st, int a){
        st.push(new Integer(a));
        System.out.println("input(" + a + ")");
        System.out.println("stack is : " + st);
    }

    void  showpop(Stack<Integer> st)
    {
        System.out.print("pop ->");
        Integer a = (Integer)st.pop();
        System.out.println(a);
        System.out.println("stack is :" + st);
    }

    void showpeak(Stack<Integer> st)
    {
        System.out.print("top num is:");
        Integer n = (Integer)st.peek();
        System.out.println(n);
        System.out.println("stack is:" + st);
    }

    void stacktest  ()throws Myexception
    {
        Stack<Integer> st = new Stack<Integer>();
        showpush(st, 11);
        showpush(st, 22);
        showpush(st, 77);
        showpush(st, 32);
        showpop(st);
        showpop(st);
        showpop(st);

        try{
            showpeak(st);
        }catch (EmptyStackException e)
        {
            System.out.println("no elements");
        }
    }

}

class MyStack1{
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public int getmin(){
        if(this.stackMin.isEmpty()){
            throw new RuntimeException("Your stack is empty");
        }else{
            return this.stackMin.peek();
        }
    }

    public Stack<Integer> getStackData() {
        return stackData;
    }

    public Stack<Integer> getStackMin(){
        return stackMin;
    }


    public MyStack1()
    {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int newNum)
    {
        if(this.stackMin.isEmpty()){
            this.stackMin.push(newNum);
        }else if (newNum <= this.getmin()){
                this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    public int pop(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("Your stack is empty");
        }
        int value = this.stackData.pop();
        if(value == this.getmin()){
            this.stackMin.pop();
        }
        return value;
    }

}

class MyStack2{
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;
    public MyStack2(){
        stackData = new Stack<Integer>();
        stackMin = new Stack<Integer>();
    }

    public Stack<Integer> getStackData() {
        return stackData;
    }

    public Stack<Integer> getStackMin() {
        return stackMin;
    }

    public int getMin(){
        if(this.stackMin.empty()){
            throw new RuntimeException("stackMin is empty");
        }else{
            return this.stackMin.peek();
        }
    }

    public void push(int num){
        if(this.stackMin.empty()){
            this.stackMin.push(num);
        }else if (num < this.getMin()){
            this.stackMin.push(num);
        }else{
            int newMin = this.stackMin.peek();
            this.stackMin.push(newMin);
        }
        this.stackData.push(num);
    }

    public void pop(){
        if(this.stackData.empty()){
            throw new RuntimeException("stackData is empty");
        }
        this.stackData.pop();
        this.stackMin.pop();
    }


}


public class Test {
    public static void main(String []args) throws EmptyStackException, Myexception {

        //Bubble Algorithm test
//        sort A = new sort();
//        int[] SortNums = {22, 11, 0, 26, 112};
//        A.bubble(SortNums);

        //Class practice
        //Father1 F1 = new Father1();

//        StackTest t = new StackTest();
//        t.stacktest();
//        int temp = 0;
//
//        System.out.println("\n\nSmartStack Show\n");
//
//        MyStack1 SmartSt = new MyStack1();
//
//        SmartSt.push(11);
//        temp = SmartSt.getmin();
//        System.out.println("min of SmartStack:" + temp);
//        SmartSt.push(33);
//        SmartSt.push(21);
//        SmartSt.push(2);
//        SmartSt.push(13);
//        SmartSt.push(0);
//
//        System.out.println("SmartStack : " + SmartSt.getStackData());
//        temp = SmartSt.getmin();
//        System.out.println("min of SmartStack:" + temp);
//
//        SmartSt.pop();
//
//        System.out.println("SmartStack : " + SmartSt.getStackData());
//        temp = SmartSt.getmin();
//        System.out.println("min of SmartStack:" + temp);
//
//        SmartSt.pop();
//        SmartSt.pop();
//
//        System.out.println("SmartStack : " + SmartSt.getStackData());
//        temp = SmartSt.getmin();
//        System.out.println("min of SmartStack:" + temp);
        MyStack2 smartSt2 = new MyStack2();
        smartSt2.push(11);
        smartSt2.push(1);
        smartSt2.push(2);
        smartSt2.push(25);
        smartSt2.push(1);
        System.out.println("StackData: " + smartSt2.getStackData());
        System.out.println("MinData: " + smartSt2.getStackMin());
        System.out.println("MinNum: " + smartSt2.getMin());
        smartSt2.push(-1);
        smartSt2.push(0);
        System.out.println("StackData: " + smartSt2.getStackData());
        System.out.println("MinData: " + smartSt2.getStackMin());
        System.out.println("MinNum: " + smartSt2.getMin());


    }
}

