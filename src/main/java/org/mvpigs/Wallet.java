package org.mvpigs;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Wallet {
    private PublicKey address;
    private PrivateKey SK;
    private Double total_Input = 0.0;
    private Double total_Output = 0.0;
    private Double balance = total_Input - total_Output;

    public Wallet(){

    }

    public PublicKey getAddress() {
        return address;
    }

    public void setAddress(PublicKey address) {
        this.address = address;
    }

    public PrivateKey getSK() {
        return SK;
    }

    public void setSK(PrivateKey sKey) {
        this.SK = sKey;
    }

    public Double getTotal_Input() {
        return total_Input;
    }

    public void setTotal_Input(Double total_Input) {
        this.total_Input = total_Input;
    }

    public Double getTotal_Output() {
        return total_Output;
    }

    public void setTotal_Output(Double total_Output) {
        this.total_Output = total_Output;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void generateKeyPair(){
        KeyPair pair = GenSig.generateKeyPair();
        this.setSK(pair.getPrivate());
        this.setAddress(pair.getPublic());

    }

    public String toString(){
        String cartera;
        return cartera = "Wallet = " + getAddress().hashCode() + "\n"
                + "Total Input = " + getTotal_Input() + "\n"
                + "Total Output = " + getTotal_Output() + "\n"
                + "Balance = " + getBalance() + "\n";
    }

}
