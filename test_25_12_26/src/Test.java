import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import java.util.Random;
import java.util.Scanner;



public class Test {


    static void main(String[] args) {
        Random rand = new Random();
    }

    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(str);

    }


    public static void main3(String[] args) {
        
        int i = 10;
        while (i < 100) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println(i);
            }
            i++;
        }


//        int i = 1;
//        while(i < 10) {
//            main2();
//            if(i % 3 == 0) {
//                System.out.println("finded !!!!!!!!");
//                break;
//            }
//            i++;
//        }
    }
}
