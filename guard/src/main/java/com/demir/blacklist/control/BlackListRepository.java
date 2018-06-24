package com.demir.blacklist.control;

import com.demir.blacklist.EntityAlreadyExistsException;
import com.demir.blacklist.EntityNotFoundException;
import com.demir.blacklist.entity.IpAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * User: muratdemir
 * Date: 24.06.2018
 * Time: 11:48
 */

@Service
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BlackListRepository {

    private static final Logger LOG = LoggerFactory.getLogger(BlackListRepository.class);

    private volatile ConcurrentHashMap<String, IpAddress> repositoryMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        repositoryMap.clear();
        LOG.info("Repository initialized as a singleton service");
    }

    public void delete(final String ip) throws EntityNotFoundException {
        if (!repositoryMap.containsKey(ip)) {
            throw new EntityNotFoundException();
        }
        repositoryMap.remove(ip);
    }

    public boolean isIpInBlackList(final String ip) {
        boolean result = false;
        if (repositoryMap.containsKey(ip)) {
            result = true;
        }
        return result;
    }


    public void persist(final IpAddress ipAddress) throws EntityAlreadyExistsException {
        if (repositoryMap.containsKey(ipAddress.getIp())) {
            throw new EntityAlreadyExistsException();
        }
        repositoryMap.put(ipAddress.getIp(), ipAddress);
    }

    public List<String> findAll() {
        List<String> result = new ArrayList<>();
        if (!repositoryMap.isEmpty()) {
            result = repositoryMap.values().stream().map(e -> e.getIp()).collect(Collectors.toList());
        }
        return result;
    }

    public IpAddress findByIp(final String ip) {
        IpAddress entity = null;
        if (repositoryMap.containsKey(ip)) {
            entity = repositoryMap.get(ip);
        }
        return entity;
    }

}
