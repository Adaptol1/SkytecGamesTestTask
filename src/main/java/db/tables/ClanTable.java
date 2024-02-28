package db.tables;

import db.DB;
import dto.Clan;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.atomic.AtomicInteger;

public class ClanTable extends AbstractTable
{
    public String name = "clans";

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

    public long add(Clan clan)
    {
        var sql = "INSERT INTO " + name + "(name, gold) VALUES(?,?)";


        try (var conn =  DB.connect();
             var pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {

            pstmt.setString(1, clan.getName());
            pstmt.setInt(2, clan.getGold().get());

            int insertedRow = pstmt.executeUpdate();
            if (insertedRow > 0) {
                var rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getLong(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;

    }

    public Clan findById(long id)
    {
        var sql = "SELECT id, name, gold FROM " + name + " WHERE id=?";
        try (var conn =  DB.connect();
             var pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, id);
            var rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Clan(
                        rs.getLong("id"),
                        rs.getString("name"),
                        new AtomicInteger(rs.getInt("gold"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(long id, String name, AtomicInteger gold)
    {
        String sql  = "UPDATE " + this.name
                    + " SET name = ?, gold = ?"
                    + " WHERE id = ?";

        try (var conn  = DB.connect();
             var pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, name);
            pstmt.setInt(2, gold.intValue());
            pstmt.setLong(3, id);
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
