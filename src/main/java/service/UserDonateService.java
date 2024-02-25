package service;

import dto.User;

public interface UserDonateService
{
    User get (long userId);
    void donateGoldToClan (long clanId, User user, int gold);
}
