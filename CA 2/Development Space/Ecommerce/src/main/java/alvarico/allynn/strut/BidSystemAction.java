package alvarico.allynn.strut;

import alvarico.allynn.model.BidModel;
import alvarico.allynn.service.BidSystemService;
import org.apache.struts2.interceptor.SessionAware;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BidSystemAction implements SessionAware {
    private int itemId;
    private String bidderUsername;
    private double amount;
    private BidModel bidModel;
    BidSystemService bidService = new BidSystemService();
    private List<BidModel> bids = new ArrayList<>();
    private Map<String, String> session;

    public BidSystemAction() {
        System.out.println("BidSystemAction instantiated");
        System.out.println(this.getClass().getName() + ": Initialized BidSystemAction");
//        System.out.println("Session map initialized: " + session);
//        System.out.println("Session contents: " + session.get("currentUser"));
    }

    public String placeBid() {
        System.out.println(this.getClass().getName() +" Method placeBid called");
        System.out.println(this.getClass().getName() +" Session to String: " + session.toString());
        // I have made a mistake here I was calling a key that does not exist in the session map
        // Therefore the userId was always null and will return as an error
        // The String or object content of the session is either currentUser, fullName, or email
        // There is no userId key in the session map
        if (session.get("currentUser") == null) {
            System.out.println("No user in session. Cannot place bid.");
            return "error";
        } else {
            System.out.println("Created new BidModel instance");
            bidModel = new BidModel();
            System.out.println(this.getClass().getName() + " Setting BidModel properties");
            bidModel.setBidItemId(this.itemId);
            System.out.println(this.getClass().getName() + " Bid item ID set to: " + this.itemId);
            System.out.println(this.getClass().getName() + " Getting the user in session");
            String bidUser = session.get("currentUser");
            System.out.println("getting current user from session: " + bidUser);
            bidModel.setBidderUsername(bidderUsername);
            System.out.println("setting bidder username to: " + bidUser);
            bidModel.setAmount(this.amount);
            System.out.println("Bid item ID: " + this.itemId);
            System.out.println(this.getClass().getName() +" Line 49: Bidder username: " + bidUser);
            // test out system print for viewing users bids!!!!
            // I hate struts now!
            System.out.println("Adding bid model to the bid List");
            bids.add(bidModel);
            String serviceResult = bidService.placeBid(this.itemId, bidUser, this.amount);
            System.out.println("Service result: " + serviceResult);
            System.out.println("Line 57 " + this.getClass().getName() + ": method placeBid");
            String result = viewMyBids();
            setBidderUsername(this.getClass().getName() + ": place method and result is " + result);
            return "success";
        }
    }

    public String viewMyBids() {
        String bUser = session.get("currentUser");
        System.out.println(this.getClass().getName() + ": viewMyBids called for user: " + bUser);
        if (bUser == null) {
            return "ERROR";
        }
        System.out.println("Getting all bids");
        bids = bidService.getAllbids();
        System.out.println(" Line 72 Bid size " + bids.size());
        for (BidModel bid : bids) {
            System.out.println(" Line 74 Bidder Username " + bid.getBidderUsername());
            if (bid.getBidderUsername().equals(bUser)) {
                System.out.println("Bid ID: " + bid.getBidId() +
                        ", Item ID: " + bid.getBidItemId() +
                        ", Amount: " + bid.getAmount());
            }
        }
        return "SUCCESS";
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setBidderUsername(String bidderUsername) {
        this.bidderUsername = bidderUsername;
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

    public String getBidderUsername() {
        return bidderUsername;
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
