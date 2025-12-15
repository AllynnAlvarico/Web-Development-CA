package alvarico.allynn.strut;

import alvarico.allynn.dao.BidDAO;
import alvarico.allynn.model.BidModel;
import alvarico.allynn.service.BidSystemService;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

public class BidSystemAction implements SessionAware {
    private int itemId, bidderUserId;
    private double amount;
    private BidModel bidModel;
    BidSystemService bidService = new BidSystemService();
    private List<BidModel> bids;
    private Map<String, Object> session;

    public BidSystemAction() {
        System.out.println("BidSystemAction instantiated");
        System.out.println(this.getClass().getName() + ": Initialized BidSystemAction");
        System.out.println("Session map initialized: " + session);
        System.out.println("Session contents: " + session.get("userId"));
    }

    public String placeBid() {
        System.out.println(this.getClass().getName() +" Method placeBid called");
        System.out.println("Created new BidModel instance");
        bidModel = new BidModel();
        System.out.println(this.getClass().getName() +" Setting BidModel properties");
        bidModel.setBidItemId(this.itemId);
        System.out.println(this.getClass().getName() +" Bid item ID set to: " + this.itemId);
        System.out.println(this.getClass().getName() + "Getting the user in session");
        System.out.println(this.getClass().getName() +" Session contents: " + session.toString());
        int userId = (int) session.get("userId");
        System.out.println("converted userId from session: " + userId);
        bidModel.setBidderUserId(userId);
        System.out.println("setting bidder user ID to: " + userId);
        bidModel.setAmount(this.amount);
        System.out.println("Bid item ID: " + this.itemId);
        System.out.println(this.getClass().getName() +" Bidder user ID: " + this.bidderUserId);

        return "success";
    }

    public String viewMyBids() {
        Integer bidderUserId = (Integer) session.get("userId");
        if (bidderUserId == null) {
            return "ERROR";
        }
        bids = bidService.getAllbids();
        return "SUCCESS";
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setBidderUserId(int bidderUserId) {
        this.bidderUserId = bidderUserId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setBids(List<BidModel> bids) {
        this.bids = bids;
    }

    public int getItemId() {
        return itemId;
    }

    public int getBidderUserId() {
        return bidderUserId;
    }
    public double getAmount() {
        return amount;
    }

    public List<BidModel> getBids() {
        return bids;
    }

    @Override
    public void setSession(Map map) {
        this.session = map;
    }
}
