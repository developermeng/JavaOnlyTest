package OnlineTest;
import java.util.*;



abstract class test1{
    test1(){
        System.out.println("test1");
    }

    void print(){
        System.out.println("OOP");
    }
}

class sonOftest1 extends test1{
    sonOftest1(){
        super();
    }
}


public class Main{

    public boolean flag;

    public class JiClass implements Runnable {
        public Main t;

        public JiClass(Main t) {
            this.t = t;
        }

        @Override
        public void run() {
            int i = 1;  //本线程打印奇数,则从1开始
            while (i < 100) {
                //两个线程的锁的对象只能是同一个object
                synchronized (t) {
                    if (!t.flag) {
                        System.out.println("-----" + i);

                        i += 2;
                        t.flag = true;
                        t.notify();

                    } else {
                        try {
                            t.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }
    }


    public class OuClass implements Runnable {
        public Main t;

        public OuClass(Main t) {
            this.t = t;
        }

        @Override
        public void run() {
            int i = 2;//本线程打印偶数,则从2开始
            while (i <= 100)
                //两个线程的锁的对象只能是同一个object
                synchronized (t) {
                    if (t.flag) {
                        System.out.println("-----------" + i);
                        i += 2;
                        t.flag = false;
                        t.notify();

                    } else {
                        try {
                            t.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        }
    }


    public static void main(String[] args) {
        Main tt = new Main();
        JiClass jiClass = tt.new JiClass(tt);
        OuClass ouClass = tt.new OuClass(tt);
        new Thread(jiClass).start();
        new Thread(ouClass).start();
    }
}
