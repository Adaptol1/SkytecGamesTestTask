package service.impl;

import db.tables.UserTable;
import dto.GoldSource;
import dto.User;
import service.ClanService;
import service.UserDonateService;

public class UserDonateServiceImpl implements UserDonateService
{
    private ClanService clanService;

    private UserTable userTable;

    @Override
    public User get(long userId)
    {
        return userTable.findById(userId);
    }
    @Override
    public void donateGoldToClan (long clanId, User user, int gold)
    {
        clanService.changeGoldCount(clanId, GoldSource.USER_DONATE, user.getId(), gold);
    }
}
