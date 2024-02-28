package service.impl;

import db.tables.UserTable;
import dto.GoldSource;
import dto.User;
import service.UserDonateService;

public class UserDonateServiceImpl implements UserDonateService
{
    private UserTable userTable = new UserTable();

    @Override
    public User get(long userId)
    {
        return userTable.findById(userId);
    }
    @Override
    public void donateGoldToClan (User user, int gold)
    {
        ClanServiceImpl clanService = ClanServiceImpl.getInstance();
        clanService.changeGoldCount(user.getClanId(), GoldSource.USER_DONATE, user.getId(), gold);
    }
}
