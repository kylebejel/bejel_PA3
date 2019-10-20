import java.util.Scanner;

public class problem_1 {
    public static class SecureRandom{
        int num1, num2;

        public SecureRandom() {
            num1 = (int)(Math.random() * ((10-1) + 1)) + 1;
            num2 = (int)(Math.random() * ((10-1) + 1)) + 1;
        }

        public SecureRandom(int difficulty) {
            if(difficulty == 1){
                num1 = (int)(Math.random() * ((10-1) + 1)) + 1;
                num2 = (int)(Math.random() * ((10-1) + 1)) + 1;
            }
            if(difficulty == 2) {
                num1 = (int)(Math.random() * ((100-1) + 1)) + 1;
                num2 = (int)(Math.random() * ((100-1) + 1)) + 1;
            }
            if(difficulty == 3){
                num1 = (int)(Math.random() * ((1000-1) + 1)) + 1;
                num2 = (int)(Math.random() * ((1000-1) + 1)) + 1;
            }
            if(difficulty == 4) {
                num1 = (int)(Math.random() * ((10000-1) + 1)) + 1;
                num2 = (int)(Math.random() * ((10000-1) + 1)) + 1;
            }
        }
    }

    public static void respond(boolean isCorrect) {
        int rand = (int) (Math.random() * 3);
        if (isCorrect) {
            switch (rand) {
                case 0:
                    System.out.println("Very good!");
                    break;
                case 1:
                    System.out.println("Excellent!");
                    break;
                case 2:
                    System.out.println("Nice work!");
                    break;
                case 3:
                    System.out.println("Keep up the good work!");
                    break;
            }
        } else {
            switch (rand) {
                case 0:
                    System.out.println("No.");
                    break;
                case 1:
                    System.out.println("Wrong.");
                    break;
                case 2:
                    System.out.println("Don't give up!");
                    break;
                case 3:
                    System.out.println("Keep trying.");
                    break;
            }
        }
    }

    public static int getType(Scanner scan) {
        System.out.println("What type of arithmetic would you like to study?");
        System.out.println("1) Addition");
        System.out.println("2) Multiplication");
        System.out.println("3) Subtraction");
        System.out.println("4) Division");
        System.out.println("5) Random Blend");
        return scan.nextInt();
    }

    public static int getDiff(Scanner scan) {
        System.out.println("What difficulty would you like? (1-5): ");
        return scan.nextInt();
    }

    public static double genQuestions(SecureRandom rand, int arith) {
        String ops[] = {"plus", "minus", "times", "divided by"};
        String op = ops[(int)(Math.random() * 4)];
        double ans = 0.0;
        switch(arith) {
            case 1:
                System.out.println(rand.num1 + " plus " + rand.num2);
                ans = rand.num1 + rand.num2;
                break;
            case 2:
                System.out.println(rand.num1 + " times " + rand.num2);
                ans = rand.num1 * rand.num2;
                break;
            case 3:
                System.out.println(rand.num1 + " minus " + rand.num2);
                ans = rand.num1 - rand.num2;
                break;
            case 4:
                System.out.println(rand.num1 + " divided by " + rand.num2);
                ans = rand.num1 / rand.num2;
                break;
            case 5:
                System.out.println(rand.num1 + " " + op + " " + rand.num2);
                if(op.equals("plus"))
                    ans = rand.num1 + rand.num2;
                if(op.equals("times"))
                    ans = rand.num1 * rand.num2;
                if(op.equals("minus"))
                    ans = rand.num1 - rand.num2;
                if(op.equals("divided by"))
                    ans = rand.num1 / rand.num2;
                break;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String again;
        do {
            int diff = getDiff(scan);
            int arith = getType(scan);
            double pCorrect = 0;

            for(int i = 0; i < 10; i++) {
                SecureRandom rand = new SecureRandom(diff);
                double ans = genQuestions(rand, arith);
                System.out.print("What is your answer?: ");
                int response = scan.nextInt();
                boolean isCorrect = (response == ans);
                respond(isCorrect);
                if(isCorrect)
                    pCorrect++;
            }
            pCorrect /= 10;
            if(pCorrect < .75)
                System.out.println("Please ask your teacher for extra help.");
            else
                System.out.println("Congratulations, you are ready to go to the next level!");

            System.out.println("\n");
            System.out.println("Press 'q' to quit or any other key to continue.");
            again = scan.next();
        } while(!again.equals("q"));

    }
}
