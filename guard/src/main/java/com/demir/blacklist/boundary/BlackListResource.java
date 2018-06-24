package com.demir.blacklist.boundary;

import com.demir.blacklist.EntityAlreadyExistsException;
import com.demir.blacklist.ResourceNotFoundException;
import com.demir.blacklist.control.BlackListRepository;
import com.demir.blacklist.entity.IpAddress;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

/**
 * User: muratdemir
 * Date: 24.06.2018
 * Time: 11:47
 */

@CrossOrigin
@RestController
@RequestMapping("back-list")
public class BlackListResource {

    @Inject
    BlackListRepository repository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> create(@RequestBody String ip) {
        HttpStatus responseStatus;
        try {
            repository.persist(new IpAddress(ip));
            responseStatus = HttpStatus.CREATED;
        } catch (EntityAlreadyExistsException ex) {
            responseStatus = HttpStatus.CONFLICT;
        }
        return ResponseEntity.status(responseStatus).build();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<String> findAll() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{ip}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    IpAddress find(@PathVariable("ip") String ip) {
        IpAddress entity = repository.findByIp(ip);
        if (entity == null) {
            throw new ResourceNotFoundException("Entity not found");
        }
        return entity;
    }



}
