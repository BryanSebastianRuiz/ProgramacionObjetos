package banking.abstracts;

import banking.exceptions.AccountException;
import banking.interfaces.AccountInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public abstract class AbstractAccount implements AccountInterface {
    private static long accountCounter = 1000000000000000000L;

    private String accountNumber;
    private String name;
    private String email;
    private String phoneNumber;
    protected double balance;
    protected double accountLimit;
    protected double openingFee;
    protected double maintenanceFee;
    protected Map<String, Map<String, Object>> movements = new HashMap<>();

    public AbstractAccount() {
        this.accountNumber = String.valueOf(accountCounter++);
    }

    @Override
    public void createAccount(String name, String email, String phoneNumber, double initialBalance) throws AccountException {
        setName(name);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        if (initialBalance < 0) {
            throw new AccountException("Initial balance cannot be negative.");
        }
        this.balance = initialBalance - openingFee - maintenanceFee;
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public boolean setEmail(String email) throws AccountException {
        if (email == null || !Pattern.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", email)) {
            throw new AccountException("Invalid email format.");
        }
        this.email = email;
        return true;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public boolean setPhoneNumber(String phoneNumber) throws AccountException {
        if (phoneNumber == null || !Pattern.matches("^\\+?[0-9]{10,13}$", phoneNumber)) {
            throw new AccountException("Invalid phone number format.");
        }
        this.phoneNumber = phoneNumber;
        return true;
    }

    @Override
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public boolean setName(String name) throws AccountException {
        if (name == null || name.isEmpty()) {
            throw new AccountException("Name cannot be empty.");
        }
        this.name = name;
        return true;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public String queryTransaction(String id) throws AccountException {
        if (!movements.containsKey(id)) {
            throw new AccountException("Transaction not found.");
        }
        return movements.get(id).toString();
    }

    protected void addMovement(String type, String concept, double amount) {
        String id = String.valueOf(movements.size() + 1);
        Map<String, Object> movement = new HashMap<>();
        movement.put("type", type);
        movement.put("concept", concept);
        movement.put("amount", amount);
        movements.put(id, movement);
    }
}
