package org.mvpigs;

import java.lang.reflect.Array;
import java.security.PublicKey;

public class Transaction {
    private String hash;
    private String prev_hash;
    private PublicKey pKey_sender;
    private PublicKey pKey_recipient;
    private Double pigcoins;
    private String message;
    private byte[] signature;

    public Transaction(String hash, String prev_hash, PublicKey pKey_sender, PublicKey pKey_recipient, Double pigcoins, String message){
        this.setHash(hash);
        this.setPrev_hash(prev_hash);
        this.setpKey_sender(pKey_sender);
        this.setpKey_recipient(pKey_recipient);
        this.setPigcoins(pigcoins);
        this.setMessage(message);
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPrev_hash() {
        return prev_hash;
    }

    public void setPrev_hash(String prev_hash) {
        this.prev_hash = prev_hash;
    }

    public PublicKey getpKey_sender() {
        return pKey_sender;
    }

    public void setpKey_sender(PublicKey pKey_sender) {
        this.pKey_sender = pKey_sender;
    }

    public PublicKey getpKey_recipient() {
        return pKey_recipient;
    }

    public void setpKey_recipient(PublicKey pKey_recipient) {
        this.pKey_recipient = pKey_recipient;
    }

    public Double getPigcoins() {
        return pigcoins;
    }

    public void setPigcoins(Double pigcoins) {
        this.pigcoins = pigcoins;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public byte[] getSignature() {
        return signature;
    }

    public void setSignature(byte[] signature) {
        this.signature = signature;
    }

    public String toString(){
        String transaction;
        return transaction = "Hash = " + getHash() + "\n"
                + "Previous Hash = " + getPrev_hash() + "\n"
                + "Sender Public Key = " + getpKey_sender().hashCode() + "\n"
                + "Recipient Public Key = " + getpKey_recipient().hashCode() + "\n"
                + "Pigcoins = " + getPigcoins() + "\n"
                + "Message = " + getMessage() + "\n";
    }
}
