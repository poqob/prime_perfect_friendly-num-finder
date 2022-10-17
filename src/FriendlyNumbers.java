import java.util.Scanner;

public class FriendlyNumbers {
    // fields
    private long sumOfDivisors1 = 0;
    private long sumOfDivisors2 = 0;
    private static long temp = 0;
    private int numOfFriendlyNumber = 0;

    // Have it friend mode: the program will work for only requested number.
    // Find friend mode: the program will start working from 0 to requested number
    // to find any friendly number.
    enum ProgramMod {
        HAVE_IT_FRIEND, FIND_FRIEND
    };

    // program mode
    ProgramMod mode = ProgramMod.HAVE_IT_FRIEND;

    // constructor
    public FriendlyNumbers() {
        input();
    };

    // methods
    // input acceptor.
    private void input() {
        Scanner myinput = new Scanner(System.in);
        String st = "";
        screenCleaner();
        while (true) {

            try {
                // console message
                System.out.print(
                        "To change program mode 'm'\nTo exit enter 'q'\nProgram mode:" + mode.name() + "\nInput: ");
                // string input
                st = myinput.next();
                // if input is m, switch program mode.
                if (st.contains("m"))
                    switchProgramMode();
                // parsing operation for input.
                Long a = Long.parseLong(st);
                // launch alghorithm
                screenCleaner();
                findFriendNumber(a);

                Thread.sleep(1200);
            } catch (Exception e) {
                screenCleaner();
                // statue of input isn't numeric.
                // controls input if it is m,q or not.
                if (st.contains("m")) {
                    screenCleaner();
                    continue;
                } else if (st.contains("q")) {
                    break;
                } else {
                    System.out.println("please press only numbers. \n");
                }

            }
        }
        // statue of input contains 'q'
        myinput.close();
        System.exit(0);
    }

    // switches between program modes.
    private void switchProgramMode() {
        if (mode == ProgramMod.HAVE_IT_FRIEND)
            mode = ProgramMod.FIND_FRIEND;
        else
            mode = ProgramMod.HAVE_IT_FRIEND;
    }

    // the alghorithm
    private void findFriendNumber(long currentNum) {
        // main alghorithm
        /*
         * In number theory, friendly numbers are two or more natural numbers with a
         * common abundancy index, the ratio between the sum of divisors of a number and
         * the number itself.
         */
        /*
         * sumOfDivisors1 = sumOfDivisor(currentNum);
         * sumOfDivisors2 = sumOfDivisor(sumOfDivisors1);
         * if (currentNum == sumOfDivisors2)
         * writer(currentNum, sumOfDivisors1);
         * else
         * writer(currentNum);
         */

        // mode of find friend number in arange or is it friend number.
        if (mode == ProgramMod.FIND_FRIEND) {
            for (long i = 0; i <= currentNum; i++) {
                // reset divisor variables to calculate new values.
                cleanDivisors();
                sumOfDivisors1 = sumOfDivisor(i);
                sumOfDivisors2 = sumOfDivisor(sumOfDivisors1);
                if (i == sumOfDivisors2) {
                    writer(i, sumOfDivisors1);
                    numOfFriendlyNumber++;
                } else
                    writer(i);

            }
            writer();
        } else {
            // reset divisor variables to calculate new values.
            cleanDivisors();
            sumOfDivisors1 = sumOfDivisor(currentNum);
            sumOfDivisors2 = sumOfDivisor(sumOfDivisors1);
            if (currentNum == sumOfDivisors2)
                writer(currentNum, sumOfDivisors1);
            else
                writer(currentNum);
        }

    }

    private void writer(long friend1, long friend2) {
        System.out.println("#" + friend1 + " they are friend numbers:" + friend1 + "-" + friend2);
    }

    private void writer(long currentNum) {
        System.out.println("#" + currentNum + " have not any friend :(");
    }

    private void writer() {
        System.out.println("total finded friendly numbers:" + numOfFriendlyNumber);
    }

    // sum of lastNum's divisors except itself.
    private static long sumOfDivisor(long lastNum) {
        temp = 0;
        for (long i = 1; i < lastNum; i++) {
            if (lastNum % i == 0) {
                temp += i;
            }
        }
        return temp;
    }

    // reset divisor variables.
    private void cleanDivisors() {
        sumOfDivisors1 = 0;
        sumOfDivisors2 = 0;
    }

    // cleans screen.
    private void screenCleaner() {
        System.out.print("\033[H\033[2J");
    }
}
