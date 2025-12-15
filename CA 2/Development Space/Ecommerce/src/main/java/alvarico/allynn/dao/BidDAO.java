package alvarico.allynn.dao;

import alvarico.allynn.configuration.DatabaseConnection;
import alvarico.allynn.model.BidModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BidDAO {
//    Tutorial used as reference:
//    https://www.youtube.com/watch?v=xF2WvGuI5Ww

    private DatabaseConnection dbConfig = new DatabaseConnection();
    private String schemaName;

    public BidDAO(String schemaName) {
        this.schemaName = schemaName;
    }

    private Connection getConnection() throws SQLException {
        dbConfig.setSchema(this.schemaName);
        return dbConfig.getDesktopConnection();
    }

    public void placeBid(BidModel bid) throws SQLException {
        String sql = "INSERT INTO bid_table (bid_item_id, bidder_user_id, amount) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, bid.getBidItemId());
            ps.setInt(2, bid.getBidderUserId());
            ps.setDouble(3, bid.getAmount());
            ps.executeUpdate();
        }
    }

    public List<BidModel> getAllBids() throws SQLException {
        return getBids(-1);
    }

    private List<BidModel> getBids(int condition) throws SQLException {
        List<BidModel> bids = new ArrayList<>();
        String sql;

        if (condition == -1) {
            sql = "SELECT * FROM bid_table ORDER BY bid_item_id, amount";
        } else {
            sql = "SELECT * FROM bid_table WHERE bid_item_id = ? ORDER BY amount";
        }

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            if (condition != -1) {
                ps.setInt(1, condition);
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    BidModel b = new BidModel();
                    b.setBidId(rs.getInt("bid_id"));
                    b.setBidItemId(rs.getInt("bid_item_id"));
                    b.setBidderUserId(rs.getInt("bidder_user_id"));
                    b.setAmount(rs.getDouble("amount"));
                    bids.add(b);
                }
            }
        }
        return bids;
    }


}

