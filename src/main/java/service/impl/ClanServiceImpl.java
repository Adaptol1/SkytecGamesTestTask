package service.impl;

import db.tables.ClanTable;
import dto.Clan;
import dto.GoldSource;
import dto.GoldTransaction;
import service.ClanService;
import service.GoldTransactionService;

import java.util.concurrent.atomic.AtomicInteger;

public class ClanServiceImpl implements ClanService
{
    private static ClanServiceImpl instance;
    private static ClanTable clanTable = new ClanTable();

    private static GoldTransactionService transactionService = new GoldTransactionServiceImpl();

    private ClanServiceImpl(){
    };

    public static ClanServiceImpl getInstance()
    {
        if(instance == null)
            instance = new ClanServiceImpl();

        return instance;
    }

    @Override
    public Clan getClan (long clanId)
    {
        return clanTable.findById(clanId);
    }

   @Override
   public synchronized void  changeGoldCount(long clanId, GoldSource goldSource,
                               long sourceId, int goldDifference)
    {
        Clan clan = getClan(clanId);
        AtomicInteger goldCount = new AtomicInteger(clan.getGold().addAndGet(goldDifference));
        clanTable.update(clanId, clan.getName(), goldCount);
        GoldTransaction transaction = new GoldTransaction(clanId, goldSource, sourceId, goldDifference, goldCount.intValue());
        transactionService.registerGoldTransaction(transaction);
    }

}
