package fr.banque;

import java.time.LocalDate;

public class Movement {
    private String movementNumber;
    private Account recipientAccount;
    private Account originalAccount;
    private double amount;
    private LocalDate executionDate;
}
