public class problem_2 {

    private static double annualInterestRate;

    public static class SavingsAccount {
        private double savingsBalance;

        public SavingsAccount(){
            savingsBalance = 0;
        }

        public SavingsAccount(double amt){
            savingsBalance = amt;
        }
    }

    public static double calculateMonthlyInterest(SavingsAccount acct) {
        return acct.savingsBalance * annualInterestRate / 12;
    }

    public static void modifyInterestRate(double rate) {
        annualInterestRate = rate;
    }
    public static void main(String[] args) {
        SavingsAccount saver1 = new SavingsAccount(2000.0);
        SavingsAccount saver2 = new SavingsAccount(3000.0);

        modifyInterestRate(.04);

        saver1.savingsBalance += calculateMonthlyInterest(saver1);
        saver2.savingsBalance += calculateMonthlyInterest(saver2);

        System.out.printf("Saver 1 new balance: %.2f\n", saver1.savingsBalance);
        System.out.printf("Saver 2 new balance: %.2f\n", saver2.savingsBalance);

        modifyInterestRate(.05);

        saver1.savingsBalance += calculateMonthlyInterest(saver1);
        saver2.savingsBalance += calculateMonthlyInterest(saver2);

        System.out.printf("Saver 1 new balance: %.2f\n", saver1.savingsBalance);
        System.out.printf("Saver 2 new balance: %.2f\n", saver2.savingsBalance);
    }
}
