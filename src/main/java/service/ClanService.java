package service;

import dto.Clan;
import dto.GoldSource;

public interface ClanService {
    Clan getClan (long clanId);

    int changeGoldCount (long clanId, GoldSource goldSource, long sourceId, int goldDifference);
}
