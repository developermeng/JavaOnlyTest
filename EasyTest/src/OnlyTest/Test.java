package OnlyTest;
import java.nio.ByteOrder;

public class Test {
    public static void main(String []args)
    {
        if(ByteOrder.nativeOrder()!=ByteOrder.LITTLE_ENDIAN)
            System.out.println("big endian");
        else System.out.println("little endian");
    }
}
