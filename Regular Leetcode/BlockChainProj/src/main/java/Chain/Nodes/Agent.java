package Chain.Nodes;
import Chain.Block;
import Chain.Chain;
import Transactions.Transaction;
import sun.plugin2.message.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.List;
import java.util.Objects;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class Agent {

    private String name;
    private String address;
    private int port;
    private List<Agent> peers;
    private Chain blockchain = new Chain();

    //private ServerSocket serverSocket;
    //private ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10);

    public static int INFO_NEW_BLOCK = -1;
    public static int REQ_ALL_BLOCKS = 1;

    private boolean listening = true;

    public Agent(final String name, final String address, final int port, Chain blockchain) {
        this.name = name;
        this.address = address;
        this.port = port;
        this.blockchain = blockchain;
    }

    public void setAgents(List<Agent> agents) {
        this.peers = agents;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getPort() {
        return port;
    }

    public Chain getChain() {
        return this.blockchain;
    }

    Block createBlock(String transactionHash) {
        Block block = this.blockchain.MineBlock();
        broadcastNewBlock(block);
        return block;
    }

    /*
    void startHost() {
        executor.execute(() -> {
            try {
                serverSocket = new ServerSocket(port);
                listening = true;
                while (listening) {
                    final ASThread thread = new ASThread(Agent.this, serverSocket.accept());
                    thread.start();
                }
                serverSocket.close();
            } catch (IOException e) {

            }
        });
        broadcast(REQ_ALL_BLOCKS, null);
    }

    void stopHost() {
        listening = false;
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    private Block getLatestBlock() {
        if (blockchain.isEmpty()) {
            return null;
        }
        return blockchain.getLatestBlock();
    }


    private void broadcastNewBlock(final Block block) {
        peers.forEach(peer -> sendNBlockMessage(peer, this.getAddress(), this.getPort(), block));
    }

    public void onReceiveNBlockMessage(String host, int port, Block block) {
        String msg = "Message receive from Peer(host: " + host + "/" + port + "), new block(hash: " + block.getHash() + ") created.";
        this.blockchain.addBlock(block);
        System.out.println(msg);
    }

    private void sendTransactionMessage(Agent target, String host, int port, Transaction trans) {
        target.onReceiveTransactionMessage(this, host, port, trans);
    }


    private void sendNBlockMessage(Agent target, String host, int port, Block block) {
        target.onReceiveNBlockMessage(host, port, block);
    }


    public void onReceiveTransactionMessage(Agent messenger, String host, int port, Transaction trans) {
        if (!messenger.getChain().verifyChain())
            System.out.println("Chain verification failure, reject transaction");
        else {
            createBlock(trans.getTransID());
        }
    }

    public void emitTransaction(Transaction trans) {
        peers.forEach(peer -> sendTransactionMessage(peer, this.getAddress(), this.getPort(), trans));
    }

}