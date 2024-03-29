package db.tables;

import db.DB;
import dto.Task;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TaskTable extends AbstractTable
{
    public String name = "tasks";

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

    public long add(Task task)
    {
        String sql = "INSERT INTO " + name + "(gold) VALUES(?)";
        try (var conn =  DB.connect();
             var pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            pstmt.setInt(1, task.getGold());

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

    public Task findById(long id)
    {
        String sql = "SELECT id, gold FROM " + name + " WHERE id=?";
        try (var conn =  DB.connect();
             var pstmt = conn.prepareStatement(sql))
        {
            pstmt.setLong(1, id);
            var rs = pstmt.executeQuery();

            if (rs.next())
                return new Task(rs.getInt("gold"));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public List<Task> findAll()
    {
        var tasks = new ArrayList<Task>();

        var sql = "SELECT id, gold FROM " + name + " ORDER BY id";

        try (var conn =  DB.connect();
             var stmt = conn.createStatement()) {

            var rs = stmt.executeQuery(sql);

            while (rs.next()) {
                var task = new Task(
                        rs.getLong("id"),
                        rs.getInt("gold")
                        );
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }
}
