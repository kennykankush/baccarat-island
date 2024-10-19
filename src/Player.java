import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;


public class Player {

    private String hostname = "Unknown";
    private double balance;
    public List<Card> playerHand = new ArrayList<>();

    public Player(){

        //https://stackoverflow.com/questions/7883542/getting-the-computer-name-in-java
        
        try
        {
            InetAddress addr;
            addr = InetAddress.getLocalHost();
            hostname = addr.getHostName();
        }
        catch (UnknownHostException ex)
        {
            System.out.println("Hostname can not be resolved");
        }

        this.balance = 10000;
    }

    public String getHostname() {
        return hostname;
    }

    public List<Card> getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(List<Card> playerHand) {
        this.playerHand = playerHand;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
}


