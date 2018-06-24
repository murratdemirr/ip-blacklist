package com.demir.blacklist.boundary;

import com.demir.blacklist.control.BlackListManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

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
    BlackListManager manager;



}
