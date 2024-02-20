package service.impl;

import dto.Clan;
import service.ClanService;

public class ClanServiceImpl implements ClanService
{
    @Override
    public Clan get (long clanId)
    {
        Clan clan = new Clan();
        return clan;
    }
}
