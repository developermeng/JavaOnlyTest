package OnlyTest;
import java.nio.ByteOrder;
import java.util.*;

import java.util.EmptyStackException;
import java.util.Stack;
import java.lang.StringBuffer;

//sort class
class Sort{
    public int bubble(int []nums)
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

    public void quickSort(int []nums , int l, int r){
        if(l > r){
            return;
        }
        int left = l;
        int right = r;
        int flag = nums[l];
        int temp;

        while (right > left){
            while (right > left && nums[right] >= flag)
            {
                right--;
            }
            nums[left] = nums[right];

            while (right > left && (nums[left] <= flag) )
            {
                left++;
            }
            nums[right] = nums[left];
        }


        nums[left] = flag;


        quickSort(nums, l, left - 1);
        quickSort(nums,left + 1, r);

    }




}




public class Test {



    public static void main(String []args) {


        Map<String,String> test = new HashMap<>();
        test.put("sb", "1");
        System.out.println(test.get("sb"));

        int []num = {3,12,33,41,9,21,2,37,3};
        int []num2 = {11,23,14,15,2,11,14,23,15};
        oddInFrontOfeven(num);

        int a = onlyOnce(num2);
        //System.out.print(a);


    }

    public static int onlyOnce(int []num){
        int n = num[0];
        for(int i = 1; i < num.length; i++){
            n = n^num[i];
        }
        return n;
    }

    public static void oddInFrontOfeven(int []num){
        int begin = 0;
        int end = num.length - 1;
        int temp;
        while (end > begin){
            while (num[begin] % 2 == 1 && end > begin){
                begin++;
            }
            while (num[end] %2 == 0 && end > begin){
                end--;
            }

            temp = num[end];
            num[end] = num[begin];
            num[begin] = temp;
        }

    }



}

