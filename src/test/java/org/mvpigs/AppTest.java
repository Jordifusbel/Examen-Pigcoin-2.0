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

}
