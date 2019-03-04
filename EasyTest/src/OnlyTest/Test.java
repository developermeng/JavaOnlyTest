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

//minNum by Stack push easy pop difficult
class MyStack1{
    private Stack<Integer> stackData ;
    private Stack<Integer> stackDataMin;
    public MyStack1(){
        stackData = new Stack<>();
        stackDataMin = new Stack<>();
    }
    public void push(int newNum){
        if(this.stackDataMin.empty())
        {
            this.stackData.push(newNum);
            this.stackDataMin.push(newNum);
        } else {
            this.stackData.push(newNum);
            if(newNum < this.stackDataMin.peek())
            {
                this.stackDataMin.push(newNum);
            }
        }
    }
    public void pop()
    {
        if(this.stackData.empty()){
            throw new RuntimeException("Stack is empty!");
        }
        else{
            if(this.stackData.peek() == this.stackDataMin.peek())
            {
                this.stackDataMin.pop();
            }
            this.stackData.pop();
        }
    }
    public int peek()
    {
        if(this.stackData.empty()){
            throw new RuntimeException("Stack is empty!");
        }
        return this.stackData.peek();
    }

    public int MinNum(){
        if(this.stackDataMin.empty())
        {
            throw new RuntimeException("Stack is empty!");
        }
        return this.stackDataMin.peek();
    }
}
//minNum by Stack push difficult pop easy
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

class Obj{
    private String str = "default name";
    public void setStr(String str){
        this.str = str;
    }
    public String toString()
    {
        return str;
    }
}


public class Test {

    private Obj aObj = new Obj();
    private int aInt = 0;
    public Obj GetAObj(){
        return aObj;
    }
    public int getaInt(){
        return aInt;
    }

    public void changeObj(Obj inObj)
    {
        inObj.setStr("change value!");
    }
    public void changeInt(int inInt)
    {
        inInt = 1;
    }



    public static void main(String []args) throws EmptyStackException, Myexception {

        //Bubble Algorithm test
//        sort A = new sort();
//        int[] SortNums = {22, 11, 0, 26, 112};
//        A.bubble(SortNums);
        int NumTemp;









//
//        Father1 test = new Father1();
//        test.PackorUnpackTest();
//        MyThread mt = new MyThread();
//        Thread t1 = new Thread(mt,"t1");
//        Thread t2 = new Thread(mt, "t2");
//        Thread t3 = new Thread(mt,"t3");
//        Thread t4 = new Thread(mt, "t4");
//        Thread t11 = new Thread(mt,"t11");
//        Thread t21 = new Thread(mt, "t21");
//        Thread t31 = new Thread(mt,"t31");
//        Thread t41 = new Thread(mt, "t41");
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        t11.start();
//        t21.start();
//        t31.start();
//        t41.start();
    }
}

