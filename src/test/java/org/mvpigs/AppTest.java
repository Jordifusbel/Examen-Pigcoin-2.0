package org.mvpigs;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;


import java.security.KeyPair;

/**
 * Unit test for simple App.
 */
public class AppTest{
    @org.junit.Test
    public void test1(){
        Wallet wallet_1 = new Wallet();
        KeyPair pair = GenSig.generateKeyPair();
        wallet_1.setSK(pair.getPrivate());
        wallet_1.setAddress(pair.getPublic());
        Assert.assertNotNull(wallet_1.getAddress());

    }
    @org.junit.Test
    public void test2(){
        Wallet wallet_1 = new Wallet();
        wallet_1.generateKeyPair();
        Assert.assertNotNull(wallet_1.getAddress());
        Assert.assertNotNull(wallet_1.getSK());
    }

//    @org.junit.Test  Para hacer este caso test, deberimos poder saber cual sera la clave publica para poder compararla
//    public void test3(){
//        Wallet wallet_1 = new Wallet();
//        wallet_1.generateKeyPair();
//        Assert.assertEquals("Wallet : '%%%%%%%'\n" +
//                "Total Input : 0.0\n" +
//                "Total Output : 0.0\n" +
//                "Balance : 0.0\n", wallet_1.toString());
//    }
    @org.junit.Test
    public void test4(){
        Wallet wallet_1 = new Wallet();
        wallet_1.generateKeyPair();
        Wallet wallet_2 = new Wallet();
        wallet_2.generateKeyPair();
        Transaction trx = new Transaction("hash_1", "0", wallet_1.getAddress(), wallet_2.getAddress(), 20.0, "a flying pig!");

        Assert.assertNotNull(trx.getpKey_recipient());
        Assert.assertNotNull(trx.getpKey_sender());
}
    @org.junit.Test
    public void test5(){
        Wallet origin = new Wallet();
        origin.generateKeyPair();
        Wallet wallet_1 = new Wallet();
        wallet_1.generateKeyPair();
        Wallet wallet_2 = new Wallet();
        wallet_2.generateKeyPair();

        BlockChain bChain = new BlockChain();
        Transaction trx = new Transaction("hash_1", "0", origin.getAddress(), wallet_1.getAddress(), 20.0, "bacon eggs");
        bChain.addOrigin(trx);
        trx = new Transaction("hash_2", "1", origin.getAddress(), wallet_2.getAddress(), 10.0, "spam spam spam");
        bChain.addOrigin(trx);
        trx = new Transaction("hash_3", "hash_1", wallet_1.getAddress(), wallet_2.getAddress(), 20.0, "a flying pig!");
        bChain.addOrigin(trx);

        Assert.assertNotNull(bChain.getBlockChain().get(2));

    }



}
