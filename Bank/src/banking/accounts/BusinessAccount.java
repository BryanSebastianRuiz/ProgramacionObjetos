package banking.accounts;

import banking.abstracts.AbstractAccount;
import banking.enums.TransactionCategory;
import banking.exceptions.AccountException;

public class BusinessAccount extends AbstractAccount {
    private static final double MIN_BALANCE = 5000;
    private static final double OPENING_FEE = 100;
    private static final double MAINTENANCE_FEE = 50;

    public BusinessAccount() {
        super();
        this.openingFee = OPENING_FEE;
        this.maintenanceFee = MAINTENANCE_FEE;
    }

    @Override
    public double withdraw(double amount) throws AccountException {
        if (this.balance - amount < MIN_BAL
