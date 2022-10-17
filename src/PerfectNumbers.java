import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PerfectNumbers {

    // Perfect numbers are the positive integers which are the sum of their proper
    // divisors.
    // The smallest perfect number is 6.
    // All the perfect numbers are even numbers. It is still unknown whether odd
    // perfect numbers exist or not.
    // All the perfect numbers end in 6 and 8 alternatively.

    public static void inputFunc() {

        Scanner myinput = new Scanner(System.in);
        String st = "";
        screenCleaner();
        while (true) {

            try {
                System.out.print("*Perfect Number Tester\n-To exit enter 'q'\n-Input: ");
                st = myinput.next();

                int a = Integer.parseInt(st);
                screenCleaner();

                perfectController(a);
            } catch (Exception e) {
                screenCleaner();
                if (!st.contains("q")) {
                    System.out.println("please press only numbers. \n");
                } else
                    break;
            }
        }
        // input 'q'
        myinput.close();
        System.exit(0);
    }

    private static void perfectController(int a) {

        List<Integer> list = new ArrayList<Integer>();
        // sum of divisors
        int b = 0;
        for (int i = 1; i < a; i++) {
            if (a % i == 0) {
                list.add(i);
                b += i;
            }
        }

        // if all divisors sum is equals to input num, the num is perfect num.
        if (b != a)
            writer(false, a, list);
        else
            writer(true, a, list);

    }

    // console writer method.
    private static void writer(boolean perfect, int number, List<Integer> dividers) {
        String divs = "";
        for (int i = 0; i < dividers.size(); i++) {
            divs += dividers.get(i);
            divs += " ";
        }

        if (perfect)
            System.out.println(number + " is perfect.\ndivisors are: " + divs);
        else
            System.out.println(number + " isn't perfect.\ndivisors are: " + divs);

    }

    private static void screenCleaner() {
        System.out.print("\033[H\033[2J");
    }

    public static boolean isItPerfect(int a) {
        List<Integer> list = new ArrayList<Integer>();
        // sum of divisors
        int b = 0;
        for (int i = 1; i < a; i++) {
            if (a % i == 0) {
                list.add(i);
                b += i;
            }
        }
        // if all divisors sum is equals to input num than num is perfect.
        return b != a ? false : true;
    }
}
