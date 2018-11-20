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

    void stacktest()
    {
        Stack<Integer> st = new Stack<Integer>();
        showpush(st, 11);
        showpush(st, 22);
        showpush(st, 77);
        showpop(st);
        showpop(st);
        try{
            showpop(st);
        }catch (EmptyStackException e){
            System.out.println("no elements!");
        }
    }


}



public class Test {
    public static void main(String []args)
    {
        if(ByteOrder.nativeOrder()!=ByteOrder.LITTLE_ENDIAN)
            System.out.println("big endian");
        else System.out.println("little endian");


        //Bubble Algorithm test
        sort A = new sort();
        int[] SortNums = {22, 11, 0, 26, 112};
        A.bubble(SortNums);

        //Class practice
        Father1 F1 = new Father1();

        StackTest t = new StackTest();
        t.stacktest();


    }
}

