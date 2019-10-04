package com.lbvp.mongo.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.DateOperators;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.temporal.TemporalUnit;

@RestController("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public Mono<Account> saveAccount(@RequestBody Account account){
        return accountService.save(account);
    }

    @GetMapping(produces = "text/event-stream")
    public Flux<Account> findAllAccount(){
        /**
         * Obtiene 600.000 registro en 8 min con un Xmx de 128 mb
         */
        System.out.println("Count-----------------");
        return accountService.findAll();
    }


}
