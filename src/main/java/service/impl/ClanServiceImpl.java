package service.impl;

import db.tables.ClanTable;
import dto.Clan;
import dto.GoldSource;
import dto.GoldTransaction;
import service.ClanService;
import service.GoldTransactionService;

public class ClanServiceImpl implements ClanService
{
    private ClanTable clanTable;

    private GoldTransactionService transactionService;

    @Override
    public Clan getClan (long clanId)
    {
        return clanTable.findById(clanId);
    }
    @Override
    public int changeGoldCount(long clanId, GoldSource goldSource, long sourceId, int goldDifference)
    {
        Clan clan = getClan(clanId);
        int goldCount = clan.getGold().addAndGet(goldDifference);
        clanTable.update(clanId, clan.getName(), goldCount);
        GoldTransaction transaction = new GoldTransaction(clanId, goldSource, sourceId, goldDifference, goldCount);
        transactionService.registerGoldTransaction(transaction);
        return goldCount;
    }

}
