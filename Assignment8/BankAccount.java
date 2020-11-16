public class BankAccount {
     private volatile double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(int amount) {
        this.balance += amount;
    }

    public synchronized void withdraw(int amount) {
        this.balance -= amount;
    }

    public double getBalance() {
        return this.balance;
    }

    public static void main(String[] args)  {
        BankAccount bankAccount = new BankAccount(0);
        int threadNumber = 4;
        var array = new ThreadBankAccount[threadNumber];
        for (int i = 0; i < threadNumber; i++) {
            ThreadBankAccount threadBankAccount = new ThreadBankAccount(bankAccount);
            array[i] = threadBankAccount;
        }

        for (ThreadBankAccount threadBankAccount: array) {
            threadBankAccount.run();
        }
        System.out.printf("Final balance: %s", bankAccount.getBalance());
    }
}

class ThreadBankAccount implements Runnable{
    BankAccount bankAccount;

    public ThreadBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            this.bankAccount.deposit(100);
            this.bankAccount.withdraw(100);
            this.bankAccount.deposit(10000);
            this.bankAccount.withdraw(10000);
        }
        System.out.println(this.bankAccount.getBalance());
    }
}
