package atm;

public class CheckingAccount extends Account {
    private double overdraftLimit; // example: 1000.0

    public CheckingAccount(String accountNumber, String ownerName,
                           double openingBalance, double overdraftLimit) {
        // TODO 1: super(...) first, then store overdraftLimit
        super(accountNumber, ownerName, openingBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public String getAccountType() {
        // TODO 2: return "CHECKING";
        return "CHECKING";
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        // TODO 3: reject amounts that are zero or negative first.
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        //
        // A checking account MAY go negative, but never past the overdraft
        // limit. So refuse the withdrawal when:
        // (getBalance() - amount) < -overdraftLimit
        // and throw a new InsufficientFundsException with the shortfall.
        if ((getBalance() - amount) < -overdraftLimit) {
            double shortfall = amount - (getBalance() + overdraftLimit);
            throw new InsufficientFundsException(shortfall);
        }
        //
        // Otherwise call the protected helper you wrote in Task 1:
        // applyWithdrawal(amount);
        //
        // NOTE: do NOT call super.withdraw(amount) here -- the parent
        // version refuses any negative balance, which is exactly the
        // rule this account is meant to relax.
        applyWithdrawal(amount);
    }
}
