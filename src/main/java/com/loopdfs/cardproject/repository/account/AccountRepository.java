package com.loopdfs.cardproject.repository.account;

import com.loopdfs.cardproject.dao.AccountDAO;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AccountRepository extends MongoRepository<AccountDAO, ObjectId> {
    Optional<AccountDAO> findAccountById(String id);
}
