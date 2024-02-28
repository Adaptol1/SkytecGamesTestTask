package service;

import dto.User;

public interface UserDonateService
{
    User get (long userId);
    void donateGoldToClan (User user, int gold);
}
