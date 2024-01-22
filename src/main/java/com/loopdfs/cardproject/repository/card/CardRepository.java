package com.loopdfs.cardproject.repository.card;

import com.loopdfs.cardproject.dao.CardDAO;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CardRepository extends MongoRepository<CardDAO, ObjectId> {
    Optional<CardDAO> getCardsByAccountId(Long accountId);
}
