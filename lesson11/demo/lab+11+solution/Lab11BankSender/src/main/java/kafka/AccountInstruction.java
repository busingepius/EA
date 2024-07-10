package kafka;

public class AccountInstruction {
    private long accountNumber;
    private String action;
    private String customerName;
    private double amount;

    public AccountInstruction() {
    }


    public AccountInstruction(long accountNumber, String action, String customerName) {
        this.accountNumber = accountNumber;
        this.action = action;
        this.customerName = customerName;
    }

    public AccountInstruction(long accountNumber, String action, double amount) {
        this.accountNumber = accountNumber;
        this.action = action;
        this.amount = amount;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getAction() {
        return action;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }
}
