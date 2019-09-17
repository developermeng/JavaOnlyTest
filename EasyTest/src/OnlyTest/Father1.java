package OnlyTest;
import java.sql.*;
import java.util.Stack;
import java.util.*;


public class Father1 {

    //非递归
    static int binSearch1(int []arr, int target){
        int minPosition = 0;
        int maxPosition = arr.length - 1;
        int mid;
        while (minPosition <= maxPosition){
            mid  = (maxPosition - minPosition)/2 + minPosition;

            if(target == arr[mid]){
                return mid;
            }else if (target < arr[mid]){
                maxPosition = mid - 1;
            }else if(target > arr[mid]){
                minPosition = mid + 1;
            }
            return Integer.MIN_VALUE;
        }

        return Integer.MIN_VALUE;
    }


    //递归
    static int binSearch2(int []arr, int target, int begin, int end){
        if(begin >= end){
            return Integer.MIN_VALUE;
        }

        int mid = (end - begin)/2 + begin;
        if(target == arr[mid]){
            return mid;
        }else if(target > arr[mid]){
            binSearch2(arr, target, mid + 1, end);
        }else if(target < arr[mid]){
            binSearch2(arr, target, begin, mid-1);
        }
        return Integer.MIN_VALUE;
    }


    public  static boolean flag;


    public static void main(String []args){


        System.out.println(flag);



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

//realize poll and peek
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

//original java mysql operation
 class MySQLDemo {

    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://123.59.116.205:9527/Important_Data";
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "hpdata";
    static final String PASS = "syshp1212";

    public void mysqltry(){
        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, name, url FROM websites";
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String url = rs.getString("url");

                // 输出数据
                System.out.print("ID: " + id);
                System.out.print(", 站点名称: " + name);
                System.out.print(", 站点 URL: " + url);
                System.out.print("\n");
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}

//binary search test
class BinaryTest
{
    BinaryTest(int [] srcArrray, int des){
        int LowIndex = 0;
        int HighIndex = srcArrray.length - 1;
        int middle;
        while (HighIndex >= LowIndex)
        {
            middle = (HighIndex + LowIndex)/2;
            if(des == srcArrray[middle]){
                System.out.println("result: " + middle);
                System.exit(2);
                break;
            } else if (srcArrray[middle] > des){
                HighIndex = middle - 1;
            }else {
                LowIndex = middle + 1;
            }
        }
        System.out.println("No Result!");
    }

}