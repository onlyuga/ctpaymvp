package com.ifs.ctpay.model.entity;

/**
 * Created by Quangminhs on 7/15/2015.
 */
public class Account {
    public int Account_Id;
    public Boolean Active;
    public Double Balance;
    public Double Hold_Balance;
    public Boolean Independent;
    public Double Interest_Rate;
    public String Account_Type;
    public int Client_Id;
    public String Created_Date;


    public int getAccount_Id() {
        return Account_Id;
    }

    public void setAccount_Id(int account_Id) {
        Account_Id = account_Id;
    }

    public Boolean getActive() {
        return Active;
    }

    public void setActive(Boolean active) {
        Active = active;
    }

    public Double getBalance() {
        return Balance;
    }

    public void setBalance(Double balance) {
        Balance = balance;
    }

    public Double getHold_Balance() {
        return Hold_Balance;
    }

    public void setHold_Balance(Double hold_Balance) {
        Hold_Balance = hold_Balance;
    }

    public Boolean getIndependent() {
        return Independent;
    }

    public void setIndependent(Boolean independent) {
        Independent = independent;
    }

    public Double getInterest_Rate() {
        return Interest_Rate;
    }

    public void setInterest_Rate(Double interest_Rate) {
        Interest_Rate = interest_Rate;
    }

    public String getAccount_Type() {
        return Account_Type;
    }

    public void setAccount_Type(String account_Type) {
        Account_Type = account_Type;
    }

    public int getClient_Id() {
        return Client_Id;
    }

    public void setClient_Id(int client_Id) {
        Client_Id = client_Id;
    }

    public String getCreated_Date() {
        return Created_Date;
    }

    public void setCreated_Date(String created_Date) {
        Created_Date = created_Date;
    }
}
