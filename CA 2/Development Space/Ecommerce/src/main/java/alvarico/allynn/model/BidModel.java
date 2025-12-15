package alvarico.allynn.model;

public class BidModel {
    private int bidId;
    private int bidItemId;
    private String bidderUsername;
    private double amount;

    public int getBidId() { return bidId; }
    public void setBidId(int bidId) { this.bidId = bidId; }

    public int getBidItemId() { return bidItemId; }
    public void setBidItemId(int bidItemId) { this.bidItemId = bidItemId; }

    public String getBidderUsername() { return bidderUsername; }
    public void setBidderUsername(String bidderUserId) { this.bidderUsername = bidderUserId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}

