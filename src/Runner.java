public class Runner {

    public static void main(String[] args){

        Player mbappe = new Player();
        Dealer dealer = new Dealer();
        baccaratEngine engine = new baccaratEngine();

        System.out.println("Dealing player---------------");
        dealer.dealCardsToPlayer(mbappe);
        dealer.dealCardsToPlayer(mbappe);

        System.out.println("\nDealing dealer-------------");
        dealer.dealCardsToDealer();
        dealer.dealCardsToDealer();
        
        System.out.println("\nassignValuePlayer---------------");
        engine.assignValueToPlayer(mbappe);
        System.out.println("assignValueDealer---------------");
        engine.assignValueToDealer(dealer);
        System.out.println(engine.playerValueList);
        System.out.println(engine.dealerValueList);
        
        System.out.println("\ncalculatePlayerHand---------------");
        engine.calculatePlayerHand();
        System.out.println("calculateDealerHand---------------");
        engine.calculateDealerHand();
        System.out.println("Sum of Player---------------" + engine.getSumPlayer());
        System.out.println("Sum of Dealer---------------" + engine.getSumDealer());

        System.out.println("\nRunning evaluateInitialPlayerHand---------------");
        engine.evaluateInitialPlayerHand();

        System.out.println("\nplayerFollowUp---------------");
        engine.playerFollowUp(dealer, mbappe);

        System.out.println("\nsumPlayerAfterFollowUp---------------" + engine.getSumPlayer());

        System.out.println("\ndealerDecision---------------");
        engine.dealerDecision();
        engine.getDealerState();

        System.out.println("\ndealerFollowUp---------------");
        engine.dealerFollowUp(dealer);
 
        System.out.println("\nsnapShotResult---------------");
        engine.snapshotResult();
    }

}