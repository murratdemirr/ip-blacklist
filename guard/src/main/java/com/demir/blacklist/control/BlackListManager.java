package com.demir.blacklist.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * User: muratdemir
 * Date: 24.06.2018
 * Time: 11:48
 */

@Service
public class BlackListManager {

    @Autowired
    BlackListRepository repository;


    public boolean checkIpAddress(final String ip) {
        return repository.isIpInBlackList(ip);
    }

}
