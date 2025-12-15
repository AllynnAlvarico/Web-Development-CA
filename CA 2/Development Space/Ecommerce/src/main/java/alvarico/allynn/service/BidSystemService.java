package alvarico.allynn.service;

import alvarico.allynn.configuration.DatabaseConnection;
import alvarico.allynn.dao.BidDAO;
import alvarico.allynn.model.BidModel;

import java.util.List;

public class BidSystemService {
    private DatabaseConnection dbConfig = new DatabaseConnection();
    private BidDAO bidDAO = new BidDAO(dbConfig.getPcSchema());

    public String placeBid(int itemId, int bidderUserId, double amount) {
        try {
            BidModel bid = new BidModel();
            bid.setBidItemId(itemId);
            bid.setBidderUserId(bidderUserId);
            bid.setAmount(amount);
            bidDAO.placeBid(bid);
            return "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    public List<BidModel> getAllbids() {
        try {
            return bidDAO.getAllBids();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }
}
