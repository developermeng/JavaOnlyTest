package OnlyTest;
import java.nio.ByteOrder;

class sort{

    public sort()
    {

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



public class Test {
    public static void main(String []args)
    {
        if(ByteOrder.nativeOrder()!=ByteOrder.LITTLE_ENDIAN)
            System.out.println("big endian");
        else System.out.println("little endian");

        sort A = new sort();
        int[] SortNums = {22, 11, 0, 26, 112};
        A.bubble(SortNums);

    }
}
//change from ipad
