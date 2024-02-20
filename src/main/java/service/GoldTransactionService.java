package service;

public interface GoldTransactionService
{
    void registerGoldTransaction (long clanId, GoldSource goldSource, long sourceId, int gold);
}
