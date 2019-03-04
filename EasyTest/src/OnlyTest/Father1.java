package OnlyTest;

import java.util.Stack;

public class Father1 {
    public Father1()
    {
        System.out.println("\nEasy OriginalClass Test");
    }
    public void PackorUnpackTest(){
        Integer I = 10;
        Long L = 42L;
        Double D = 32.0;
        double d = 32;
        int i = I;
        boolean TorF = (I == i);
        System.out.println("result:" + TorF);
    }
}

class MyThread implements Runnable{
    public MyThread(){

    }
    public void run(){
        synchronized (this)
        {
            System.out.println(Thread.currentThread().getName());
        }
    }
}

class StackRealizeQueue
{
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public StackRealizeQueue(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    void add(int NewNum)
    {
        stack1.push(NewNum);
    }

    int peek()
    {
        if(stack1.empty() && stack2.empty())
        {
            throw new RuntimeException("Queue no elements!");
        }
        if(stack2.empty())
        {
            while (!stack1.empty())
            {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    int poll()
    {
        if(stack1.empty() && stack2.empty())
        {
            throw new RuntimeException("Queue no elements!");
        }
        if(stack2.empty())
        {
            while (!stack1.empty())
            {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}
