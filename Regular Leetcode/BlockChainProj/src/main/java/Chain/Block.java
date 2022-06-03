package Chain;
import Transactions.Transaction;
import Util.StringUtil;

import java.util.Date;

public class Block {

    /*
    该项目根据个人理解实现了区块链功能，包括了挖矿、验证和存储；
    如果有条件使用Fabric建议使用Fabric搭建项目
     */
    private String hash;
    private int nonce;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    private String previousHash;
    private MerkleTree merkleTree;
    private long timeStamp;
    private String data;

    public Block(String data,String previousHash ) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    public String calculateHash() {
        String calculatedhash = StringUtil.applySha256(
                previousHash +
                        Long.toString(timeStamp) +
                        Integer.toString(nonce) +
                        data
        );
        return calculatedhash;
    }

    public boolean isValidBlock() {
        return this.calculateHash().equals(this.getHash());
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while(!hash.substring( 0, difficulty).equals(target)) {
            nonce ++;
            hash = calculateHash();
        }
        System.out.println("block mined, hash = " + hash);
    }


}