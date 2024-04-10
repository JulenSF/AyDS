package A3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import A1.BlockChainNetwork;
import A1.CommonUtils;
import A1.MiningNode;
import A1.Node;
import A1.Subnet;
import A1.TesterMainExercise1;
import A1.Transaction;
import A1.Wallet;

class TesterMainExercise1Test {


    public void buildNetwork(){
       Wallet wallet1, wallet2, wallet3;
       MiningNode miningNode, miningNode2;
       Node node;
       Subnet subnet;
       BlockChainNetwork network;
    // Create wallets
        wallet1 = new Wallet("Bob", CommonUtils.sha1("PK-Bob"), 10);
        wallet2 = new Wallet("Alice", CommonUtils.sha1("PK-Alice"), 100);
        wallet3 = new Wallet("Paul", CommonUtils.sha1("PK-Paul"), 777);

        // Create the nodes with the wallets
        node = new Node(wallet1);
        miningNode = new MiningNode(wallet2, 10000);

        // Create a subnet inside a network
        miningNode2 = new MiningNode(wallet3, 10000);
        subnet = new Subnet(miningNode2); // We could pass more nodes here

        // Create the network and connect the elements
        network = new BlockChainNetwork("ADSOF blockchain");
        network.connect(node)
               .connect(subnet)
               .connect(miningNode);

        // Create example transaction, which transfers 10 coins from wallet1 to wallet2
        new Transaction(wallet1, wallet2, 10);
    }

 
	@Test
	void testMain() {
        TesterMainExercise1 tme = new TesterMainExercise1();
        tme.buildNetwork();
        System.out.println(tme.network);
        System.out.println(tme.node.fullname()); // prints the name of the node
        System.out.println("End of party!");
		fail("Not yet implemented");
	}

}
