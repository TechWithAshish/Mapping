package com.example.mapping.Entity.Account;

public class AccountFactory {
    public static Account getAccount(AccountType accountType){
        if(accountType == null) {
            return null;
        }
        return switch (accountType) {
            case SAVING -> new SavingAccount();
            case CURRENT -> new CurrentAccount();
            case JOINT -> new JointAccount();
            default -> null;
        };
    }
}
