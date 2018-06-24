package com.demir.blacklist.boundary;

import com.demir.blacklist.Ip;
import com.demir.blacklist.control.BlackListRepository;
import com.demir.blacklist.entity.IpAddress;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * User: muratdemir
 * Date: 24.06.2018
 * Time: 11:47
 */

@CrossOrigin
@RestController
@RequestMapping("black-list")
public class BlackListResource {

    @Inject
    BlackListRepository repository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> create(@Validated @RequestBody @Ip @NotNull String ip) {
        repository.persist(new IpAddress(ip));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<String> findAll() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{ip}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    IpAddress find(@PathVariable("ip") @Ip String ip) {
        return repository.findByIp(ip);
    }

    @RequestMapping(value = "/{ip}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    void delete(@PathVariable("ip") @Ip String ip) {
        repository.delete(ip);
    }

    @RequestMapping(value = "/check/{ip}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Boolean isBanned(@Validated @PathVariable("ip") @Ip String ip) {
        return repository.isIpInBlackList(ip);
    }


}
