package service.impl;

import dto.Clan;
import service.ClanService;

import java.util.concurrent.atomic.AtomicInteger;

public class ClanServiceImpl implements ClanService
{
    @Override
    public Clan getClan (long clanId)
    {
        Clan clan = new Clan(clanId, "123", new AtomicInteger(123));
        return clan;
    }
}
