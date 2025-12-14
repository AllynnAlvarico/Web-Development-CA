package alvarico.allynn.model;

public class BidModel {
    private int bidId;
    private int bidItemId;
    private int bidderUserId;
    private double amount;

    public int getBidId() { return bidId; }
    public void setBidId(int bidId) { this.bidId = bidId; }

    public int getBidItemId() { return bidItemId; }
    public void setBidItemId(int bidItemId) { this.bidItemId = bidItemId; }

    public int getBidderUserId() { return bidderUserId; }
    public void setBidderUserId(int bidderUserId) { this.bidderUserId = bidderUserId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}

