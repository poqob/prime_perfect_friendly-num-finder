import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeNumbers {
    // Prime number is a number that is greater than 1
    // only divided by 1 and itself

    public static void inputFunc() {
        // rule
        // a number which is not dividing with numbers that isn't itself.
        Scanner myinput = new Scanner(System.in);
        String st = "";
        screenCleaner();
        while (true) {

            try {
                System.out.print("*Prime Number Tester\n-To exit enter 'q'\n-Input: ");
                st = myinput.next();

                int a = Integer.parseInt(st);
                screenCleaner();

                primeController(a);
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

    private static void primeController(int a) {

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < a + 1; i++) {
            if (a % i == 0) {
                list.add(i);
            }
        }

        // case of having more than 2 dividers. --num isn't prime.
        if (list.size() > 2)
            writer(false, a, list);
        else
            writer(true, a, list);

    }

    // console writer method.
    private static void writer(boolean prime, int number, List<Integer> dividers) {
        String divs = "";
        for (int i = 0; i < dividers.size(); i++) {
            divs += dividers.get(i);
            divs += " ";
        }

        if (prime)
            System.out.println(number + " is prime.\ndividers are: " + divs);
        else
            System.out.println(number + " isn't prime.\ndividers are: " + divs);

    }

    // console cleaner method.
    private static void screenCleaner() {
        System.out.print("\033[H\033[2J");
    }

    // single input function's primeController.
    public static boolean isItPrime(int a) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < a + 1; i++) {
            if (a % i == 0) {
                list.add(i);
            }
        }

        // case of having more than 2 dividers. --num isn't prime.
        if (list.size() > 2)
            return false;
        else
            return true;
    }

}
