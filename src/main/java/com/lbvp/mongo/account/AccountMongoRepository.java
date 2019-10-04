package com.lbvp.mongo.account;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AccountMongoRepository  extends ReactiveMongoRepository<Account, String> {
}
