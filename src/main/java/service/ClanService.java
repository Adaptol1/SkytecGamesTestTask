package service;

import dto.Clan;
import dto.GoldSource;

public interface ClanService {

    Clan getClan (long clanId);

    void changeGoldCount (long clanId, GoldSource goldSource, long sourceId, int goldDifference);
}
