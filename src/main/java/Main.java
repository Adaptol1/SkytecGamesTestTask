import db.DB;
import db.DatabaseConfig;
import db.tables.ClanTable;
import db.tables.GoldTransactionTable;
import dto.Clan;
import dto.GoldSource;
import dto.GoldTransaction;

import java.sql.Connection;
import java.util.concurrent.atomic.AtomicInteger;

public class Main
{
    public static void main(String[] args)
    {
        GoldTransaction transaction = new GoldTransaction(123, GoldSource.USER_DONATE, 321, 24, 24);
        GoldTransactionTable table = new GoldTransactionTable();
        table.create();
        table.add(transaction);
        GoldTransaction trst = table.findById(1);
        System.out.println(trst.getTotalGold());
    }
}
