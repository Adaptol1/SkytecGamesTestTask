package db.tables;

import db.DB;
import dto.User;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserTable extends AbstractTable
{
    public String name = "users";

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

    public long add(User user)
    {
        String sql = "INSERT INTO " + name + "(clan_id) VALUES(?)";
        try (var conn =  DB.connect();
             var pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            pstmt.setLong(1, user.getClanId());

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

    public User findById(long id)
    {
        String sql = "SELECT id, clanId FROM " + name + " WHERE id=?";
        try (var conn =  DB.connect();
             var pstmt = conn.prepareStatement(sql))
        {
            pstmt.setLong(1, id);
            var rs = pstmt.executeQuery();

            if (rs.next())
                return new User(rs.getInt("clan_id"));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> findAll()
    {
        var users = new ArrayList<User>();

        var sql = "SELECT id, clan_id FROM " + name + " ORDER BY id";

        try (var conn =  DB.connect();
             var stmt = conn.createStatement()) {

            var rs = stmt.executeQuery(sql);

            while (rs.next()) {
                var user = new User(
                        rs.getLong("id"),
                        rs.getLong("clan_id")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
