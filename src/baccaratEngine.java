import java.util.ArrayList;
import java.util.List;

public class baccaratEngine{

    List<Integer> playerValueList;
    List<Integer> dealerValueList;
    private String playerState = "";
    private boolean playerThirdCard = false;
    private String dealerState = "";
    private boolean endGame = false;
    private int sumPlayer = 0;
    private int sumDealer = 0;

    public boolean isPlayerThirdCard() {
        return playerThirdCard;
    }

    public void setPlayerThirdCard(boolean playerThirdCard) {
        this.playerThirdCard = playerThirdCard;
    }
    
    public boolean isEndGame() {
        return endGame;
    }

    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }
    
    public String getDealerState() {
        return dealerState;
    }

    public void setDealerState(String dealerState) {
        this.dealerState = dealerState;
    }
    
    public String getPlayerState() {
        return playerState;
    }

    public void setPlayerState(String playerState) {
        this.playerState = playerState;
    }
    
    public int getSumPlayer() {
        return sumPlayer;
    }

    public void setSumPlayer(int sumPlayer) {
        this.sumPlayer = sumPlayer;
    }

    public int getSumDealer() {
        return sumDealer;
    }

    public void setSumDealer(int sumDealer) {
        this.sumDealer = sumDealer;
    }

    public int assignValue(Card card){

        int cardValue;
        
        if (card.getRank() == "A"){
            cardValue = 1;

        } else if (card.getRank() == "J" || card.getRank() == "Q" || card.getRank() == "K" || card.getRank() == "10"){
            cardValue = 0;
        } else {
            cardValue = Integer.parseInt(card.getRank());
        }

        return cardValue;

        
    }

    public void assignValueToPlayer(Player player){
        List<Card> placeholder = player.getPlayerHand();
        // System.out.println(player.getPlayerHand());
        playerValueList = new ArrayList<>();

        for (int i = 0; i < placeholder.size(); i++){
            int value = assignValue(placeholder.get(i));
            playerValueList.add(value);
        }

    }

    public void assignValueToDealer(Dealer dealer){
        List<Card> placeholder = dealer.getDealerHand();
        // System.out.println(dealer.getDealerHand());
        dealerValueList = new ArrayList<>();

        for (int i = 0; i < placeholder.size(); i++){
            int value = assignValue(placeholder.get(i));
            dealerValueList.add(value);
        }

    }
    
    public void calculatePlayerHand(){
        
        int sum = 0;

        for (int num : playerValueList){
            sum += num;
        }

        if (sum >= 10){
            int getSecondDigit = sum % 10;
            setSumPlayer(getSecondDigit);;
        } else {

        setSumPlayer(sum);
         }

    }
    
    public void calculateDealerHand(){
        
        int sum = 0;

        for (int num : dealerValueList){
            sum += num;
        }

        if (sum >= 10){
            int getSecondDigit = sum % 10;
            setSumDealer(getSecondDigit);
        } else {

        setSumDealer(sum);
        }

    }
    
    public void evaluateInitialPlayerHand(){
           
        if (getSumPlayer() == 8 || getSumPlayer() == 9){
            setPlayerState("Natural");
            System.out.println("I have a " + getPlayerState());
                   
        } else if (getSumDealer() == 8 || getSumPlayer() == 9){
            setDealerState("Natural");
            System.out.println("I have a " + getDealerState());
        
        } else if (getSumPlayer() == 6 || getSumPlayer() ==7 ){
            setPlayerState("Stand");
            System.out.println("I have a " + getPlayerState());
        } else {
            setPlayerState("Draw");
            setPlayerThirdCard(true);
            System.out.println("I have a " + getPlayerState());
        }

    }
    
    public void dealerDecision(){
        
        if (getPlayerState().equals("Natural")){
            setEndGame(true);  
            System.out.println("Oh know, i'm cucked coz you have a " + getPlayerState());                           
        } else if (getDealerState().equals("Natural")){
            setEndGame(true);            
            System.out.println("Hahahaha, you are cucked now because i have a " + getDealerState());             
        }

        if (!isPlayerThirdCard() && !endGame == true){
            if (getSumDealer() == 6 || getSumDealer() == 7){
                setDealerState("Stand"); 
                setEndGame(true); 
                System.out.println("Player has no third card and I will stand because i have a " + getSumDealer());
            } else {
                setDealerState("Draw");
                setEndGame(true); 
                System.out.println("Player has no third card and I will draw because i have a " + getSumDealer());
            }

        }

        if (isPlayerThirdCard() && !endGame == true){

            int playerThirdCard = playerValueList.get(2);
            if (getSumDealer() == 3){
                if ((playerThirdCard >= 0 && playerThirdCard <= 7) || playerThirdCard == 9){
                    setDealerState("Draw");
                    setEndGame(true); 
                    System.out.println("Player drew " + playerThirdCard + " and I will draw because i have a " + getSumDealer());
                } else {
                    setDealerState("Stand");
                    setEndGame(true); 
                    System.out.println("Player drew " + playerThirdCard + " and I will stand because i have a " + getSumDealer());
                }
            } else if (getSumDealer() == 4){
                if ((playerThirdCard >= 2 && playerThirdCard <= 7)){
                    setDealerState("Draw");
                    setEndGame(true); 
                    System.out.println("Player drew " + playerThirdCard + " and I will draw because i have a " + getSumDealer());
                } else {
                    setDealerState("Stand");
                    setEndGame(true); 
                    System.out.println("Player drew " + playerThirdCard + " and I will stand because i have a " + getSumDealer());

                }
            } else if (getSumDealer() == 5){
                if (playerThirdCard >= 4 && playerThirdCard <= 7){
                    setDealerState("Draw");
                    setEndGame(true); 
                    System.out.println("Player drew " + playerThirdCard + " and I will draw because i have a " + getSumDealer());
                } else {
                    setDealerState("Stand");
                    setEndGame(true); 
                    System.out.println("Player drew " + playerThirdCard + " and I will stand because i have a " + getSumDealer());
                }
            } else if (getSumDealer() == 6){
                if (playerThirdCard >= 6 && playerThirdCard <= 7){
                    setDealerState("Draw");
                    setEndGame(true); 
                    System.out.println("Player drew " + playerThirdCard + " and I will draw because i have a " + getSumDealer());
                } else {
                    setDealerState("Stand");
                    setEndGame(true); 
                    System.out.println("Player drew " + playerThirdCard + " and I will stand because i have a " + getSumDealer());
                }
            } else if (getSumDealer() >= 0 && getSumDealer() <= 2){
                setDealerState("Draw");
                setEndGame(true);
                System.out.println("Player drew " + playerThirdCard + " and I will draw because i have a " + getSumDealer());

            } else {
                setDealerState("Stand");
                setEndGame(true); 
                System.out.println("Player drew " + playerThirdCard + " and I will stand because i have a " + getSumDealer());
           }
        }


        }
    
    public void playerFollowUp(Dealer dealer, Player player){
        if (getPlayerState().equals("Draw")){
            dealer.dealCardsToPlayer(player);
            assignValueToPlayer(player);
            calculatePlayerHand();
        } else if (getPlayerState().equals("Natural")){
            System.out.println("No follow up, i have a " + getPlayerState());
        } else {
            System.out.println("No follow up, i " + getPlayerState());
        }
    }
    
    public void dealerFollowUp(Dealer dealer){
        if (getDealerState().equals("Draw")){
            dealer.dealCardsToDealer();
            assignValueToDealer(dealer);
            calculateDealerHand();
            System.out.println(dealerValueList);
        }
    }
    
    public void snapshotResult(){
        if (isEndGame()){
            System.out.println(determineWinner());
        } else {
            System.out.println("Game is not finalised");
        }
    }
    
    public String determineWinner(){

            String dealer_victory = "Dealer wins";
            String player_victory = "Player wins";
            String tie = "Tie";

            if (sumPlayer > sumDealer){
                return player_victory;
            }  else if (sumPlayer < sumDealer) {
                return dealer_victory;
            } else {
                return tie;
            }

    }


}
    