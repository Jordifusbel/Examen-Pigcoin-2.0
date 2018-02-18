package org.mvpigs;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;

public class Wallet {
    private PublicKey address;
    private PrivateKey SK;
    private Double total_Input = 0.0;
    private Double total_Output = 0.0;
    private Double balance = total_Input - total_Output;
    private ArrayList<Transaction> inputTransactions;
    private ArrayList<Transaction> outputTransactions;


    public Wallet(){
        this.inputTransactions = new ArrayList<Transaction>();
        this.outputTransactions = new ArrayList<Transaction>();
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

    public void setBalance() {
        this.balance = this.getTotal_Input() - this.getTotal_Output();
    }

    public ArrayList<Transaction> getInputTransactions() {
        return inputTransactions;
    }

    public ArrayList<Transaction> getOutputTransactions() {
        return outputTransactions;
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

    public void loadCoins(BlockChain hist){
        PublicKey llave = this.getAddress();
        for (int n=0; n<hist.getBlockChain().size(); n++){
            if (llave == hist.getBlockChain().get(n).getpKey_recipient()){
                Double recibido = this.getTotal_Input();
                recibido = recibido + hist.getBlockChain().get(n).getPigcoins();
                this.setTotal_Input(recibido);
                this.setBalance();
            }else if (llave == hist.getBlockChain().get(n).getpKey_sender()){
                Double enviado = this.getTotal_Output();
                enviado = enviado + hist.getBlockChain().get(n).getPigcoins();
                this.setTotal_Output(enviado);
                this.setBalance();
            }
        }
    }
    public void loadInputTransactions(BlockChain hist) {
        PublicKey llave = this.getAddress();
        for (int n = 0; n < hist.getBlockChain().size(); n++) {
            if (llave == hist.getBlockChain().get(n).getpKey_recipient()) {
                this.inputTransactions.add(hist.getBlockChain().get(n));
            }

        }
    }
    public void loadOutputTransactions(BlockChain hist) {
        PublicKey llave = this.getAddress();
        for (int n = 0; n < hist.getBlockChain().size(); n++) {
            if (llave == hist.getBlockChain().get(n).getpKey_sender()) {
                this.outputTransactions.add(hist.getBlockChain().get(n));
            }

        }
    }
}
