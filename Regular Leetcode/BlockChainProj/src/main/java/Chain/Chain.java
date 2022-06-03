package Chain;

import Transactions.Transaction;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Chain {


    private String previousHash;
    private String data; //our data will be a simple message.
    private long timeStamp; //as number of milliseconds since 1/1/1970.
    public ArrayList<Block> blockChain = new ArrayList<>();
    public static int difficulty = 2;
    private int initialChainSize = 10;

    public Chain copy() {
        Chain copy = new Chain();
        copy.previousHash = this.previousHash;
        for (Block block : this.blockChain)
            copy.addBlock(block);
        return copy;
    }

    public boolean verifyChain() {
        Block currentBlock = blockChain.get(1), previousBlock = blockChain.get(0);
        int currentIndex = 1;
        System.out.println("Chain verifying...");
        String hashTarget = new String(new char[difficulty]).replace('\0', '0');
        while(currentIndex < blockChain.size()) {
            if (!currentBlock.calculateHash().equals(currentBlock.getHash())) {
                System.out.println("Unmatched hash found, current chain invalid.");
                return false;
            }
            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                System.out.println("Expected:  " + previousBlock.getHash() + ", Got: " + currentBlock.getPreviousHash());
                System.out.println("Unmatched previous hash, current chain invalid");
                return false;
            }
            if(!currentBlock.getHash().substring( 0, difficulty).equals(hashTarget)) {
                System.out.println("Unmined block found, current chain invalid");
                return false;
            }
            currentIndex++;
            if (currentIndex < blockChain.size()) {
                currentBlock = blockChain.get(currentIndex);
                previousBlock = blockChain.get(currentIndex - 1);
            }
        }
        System.out.println("verification success.");
        return true;
    }


    public Block getLatestBlock() {
        return this.blockChain.get(this.blockChain.size() - 1);
    }
    public boolean isEmpty() {
        return this.blockChain.size() == 0;
    }

    public void printChain() {
        System.out.println("Chain info: ");
        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(blockChain));
    }

    public void createChain() {
        Block genesisBlock = new Block("Generate genesis block", "0");
        genesisBlock.mineBlock(difficulty);
        previousHash = genesisBlock.getHash();
        for (int i = 0; i < initialChainSize; i++) {
            Mine();
        }
    }

    public void addBlock(Block block) {
        blockChain.add(block);
        previousHash = block.getHash();
    }

    public void Mine() {
        Block nBlock = MineBlock();
        blockChain.add(nBlock);
        previousHash = nBlock.getHash();
    }

    public Block MineBlock() {
        Block nBlock = new Block("Block No." + (blockChain.size() + 1), previousHash);
        nBlock.mineBlock(difficulty);
        return nBlock;
    }


}
