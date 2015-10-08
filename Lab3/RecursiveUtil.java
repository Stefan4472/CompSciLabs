/**
 * Created by lhscompsci on 10/8/15.
 */
public class RecursiveUtil {

    public static boolean powerOf3(int num) {
        if(num == 1) {
            return true;
        } else if(num == 0) {
            return false;
        }
        return powerOf3((int) Math.ceil(num / 3));
    }

    public static int reverse(int num) {
        System.out.println(num);
        if(num == 0) {
            return num;
        } else {
            return num + reverse(num / 10) * 10;
        }
    }

    public static void printWithCommas(int num) {
        if(num < 1_000) {
            System.out.print(num);
        } else {
            printWithCommas(num / 1_000);
            System.out.print("," + num % 1_000);
        }
    }
}
