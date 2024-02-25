package db.tables;

import db.DB;
import dto.Clan;
import dto.GoldSource;
import dto.GoldTransaction;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.atomic.AtomicInteger;

public class GoldTransactionTable extends AbstractTable
{
    public String name = "gold_transactions";

    @Override
    public void create() {
        super.name = this.name;
        super.create();
    }

    @Override
    public void drop()
    {
        super.name = this.name;
        super.drop();
    }

    public long add(GoldTransaction transaction)
    {
        String sql = "INSERT INTO " + name + "(clan_id, gold_source, source_id, transferred_gold, total_gold) " +
                  "VALUES(?,?,?,?,?)";

        try (var conn =  DB.connect();
             var pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            pstmt.setLong(1, transaction.getClanId());
            pstmt.setString(2, transaction.getGoldSource().getSource());
            pstmt.setLong(3, transaction.getSourceId());
            pstmt.setInt(4, transaction.getTransferredGold());
            pstmt.setInt(5, transaction.getTotalGold().get());

            int insertedRow = pstmt.executeUpdate();
            if (insertedRow > 0) {
                var rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getLong(1);
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return -1;
    }

    public GoldTransaction findById(long id)
    {
        String sql = "SELECT id, clan_id, gold_source, source_id, transferred_gold, total_gold " +
                     "FROM " + name + " WHERE id=?";

        try (var conn =  DB.connect();
             var pstmt = conn.prepareStatement(sql))
        {
            pstmt.setLong(1, id);
            var rs = pstmt.executeQuery();
            if (rs.next()) {
                GoldSource goldSource = GoldSource.UNKNOWN;
                switch (rs.getString("gold_source"))
                {
                    case("complete task"):
                        goldSource = GoldSource.COMPLETE_TASK;
                    case("user donate"):
                        goldSource = GoldSource.USER_DONATE;
                }

                return new GoldTransaction(
                        rs.getLong("id"),
                        rs.getLong("clan_id"),
                        goldSource,
                        rs.getLong("source_id"),
                        rs.getInt("transferred_gold"),
                        new AtomicInteger(rs.getInt("total_gold"))
                );
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
