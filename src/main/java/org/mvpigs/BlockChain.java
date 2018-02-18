package org.mvpigs;

import java.util.ArrayList;

public class BlockChain {
    private ArrayList<Transaction> blockChain;

    public BlockChain(){
        this.blockChain = new ArrayList<Transaction>();
    }

    public ArrayList<Transaction> getBlockChain() {
        return blockChain;
    }

    public void setBlockChain(ArrayList<Transaction> blockChain) {
        this.blockChain = blockChain;
    }

    public void addOrigin(Transaction newBillet){
        this.blockChain.add(newBillet);
    }

    public void summarize(){
        for (int n=0; n< this.blockChain.size(); n++){
            System.out.println(this.blockChain.get(n).toString());
        }
    }
    public void summarize(int index){
        System.out.println(this.blockChain.get(index).toString());
        }

}


