package Chain;

import Chain.Nodes.Agent;
import Transactions.Transaction;

import java.util.ArrayList;

public class AgentManager {

    Chain blockchain;
    ArrayList<Agent> agents = new ArrayList<>();

    //初始化Demo Peers
    private static String host = "127.0.0.1";
    private static int[] port = {8080, 3000, 8888};
    public void testInit() {
        blockchain = new Chain();
        blockchain.createChain();
        System.out.println("test initializing...");
        blockchain.verifyChain();
        for (int i = 0; i < port.length; i++) {
            Chain copy = blockchain.copy();
            agents.add(new Agent("Agent No." + i, host, port[i], copy));
        }

        agents.forEach(agent -> agent.setAgents(agents));
    }

    public void performTransaction(Transaction trans) {
        agents.get(0).emitTransaction(trans);
    }


}
