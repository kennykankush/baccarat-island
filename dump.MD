public void determinePlayerState(){

    if 

    

//     if ((sumPlayer >= 0 && sumPlayer<=5)){
//         setPlayerState("Draw");
//         setDealerHasAccessToThirdCard(true);
//     } else if ((sumPlayer == 6 || sumPlayer == 7)){
//         setPlayerState("Stand");
//         setDealerHasAccessToThirdCard(true);

//     } else {
//         setPlayerState("Natural");
//         setDealerHasAccessToThirdCard(false);
        
//     }   
}

public void dealerConditions(){

    // if(dealerHasAccessToThirdCard){

    //     if (sumDealer >= 0 && sumDealer <=2){
    //         setDealerState("Draw");
    //     } else if (sumDealer == 7){
    //         setDealerState("Stand");
    //     } else if (sumDealer == 8 || sumDealer == 9){
    //         setDealerState("Natural");
    //     }
        

    //     if (playerHasThirdCard){
    //         if (sumDealer == 3 && ((playerValueList.get(2) >= 1) && (playerValueList.get(2) <= 7) || playerValueList.get(2) == 9 || playerValueList.get(2) == 10)){
    //             setDealerState("Draw");
                
    //         } else if (sumDealer == 4 && ((playerValueList.get(2) >= 2) && (playerValueList.get(2) <= 7))){
    //             setDealerState("Draw");
             
    //         } else if (sumDealer == 5 && ((playerValueList.get(2) >= 4) && (playerValueList.get(2) <= 7))){
    //             setDealerState("Draw");

    //         } else if (sumDealer == 6 && ((playerValueList.get(2) >= 6) && (playerValueList.get(2) <= 7))){
    //             setDealerState("Draw");
    //         } else {
    //             setDealerState("Stand");
    //         }

    //     }
    // }


}

public void nextMoveforPlayer(Player player, Dealer dealer){

    if (playerState.equals("Draw")){
        setPlayerHasThirdCard(true);
        System.out.println("Hit me");
        dealer.dealCardsToPlayer(player);
        assignValueToPlayer(player);
        calculatePlayerHand();
        
    }
}

public void nextMoveforDealer(Dealer dealer){
    
    if (dealerState.equals("Draw")){
        System.out.println("As a dealer, i am going to hit because the rules require me");
        dealer.dealCardsToDealer();
        assignValueToDealer(dealer);
        calculateDealerHand();
    }
}
