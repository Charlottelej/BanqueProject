package fr.banque;

import java.time.LocalDate;

public class Movement {
    private int movementNumber;
    private Account recipientAccount;
    private Account originalAccount;
    private double amount;
    private LocalDate executionDate;

    public Movement(int movementNumber, Account recipientAccount, Account originalAccount, double amount, LocalDate executionDate) {
        this.movementNumber = movementNumber;
        this.recipientAccount = recipientAccount;
        this.originalAccount = originalAccount;
        this.amount = amount;
        this.executionDate = executionDate;
    }

    public int getMovementNumber() {
        return movementNumber;
    }

    public void setMovementNumber(int movementNumber) {
        this.movementNumber = movementNumber;
    }

    public Account getRecipientAccount() {
        return recipientAccount;
    }

    public void setRecipientAccount(Account recipientAccount) {
        this.recipientAccount = recipientAccount;
    }

    public Account getOriginalAccount() {
        return originalAccount;
    }

    public void setOriginalAccount(Account originalAccount) {
        this.originalAccount = originalAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(LocalDate executionDate) {
        this.executionDate = executionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movement movement = (Movement) o;

        if (movementNumber != movement.movementNumber) return false;
        if (Double.compare(movement.amount, amount) != 0) return false;
        if (recipientAccount != null ? !recipientAccount.equals(movement.recipientAccount) : movement.recipientAccount != null)
            return false;
        if (originalAccount != null ? !originalAccount.equals(movement.originalAccount) : movement.originalAccount != null)
            return false;
        return executionDate != null ? executionDate.equals(movement.executionDate) : movement.executionDate == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = movementNumber;
        result = 31 * result + (recipientAccount != null ? recipientAccount.hashCode() : 0);
        result = 31 * result + (originalAccount != null ? originalAccount.hashCode() : 0);
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (executionDate != null ? executionDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Movement{" +
                "movementNumber=" + movementNumber +
                ", recipientAccount=" + recipientAccount +
                ", originalAccount=" + originalAccount +
                ", amount=" + amount +
                ", executionDate=" + executionDate +
                '}';
    }
}
