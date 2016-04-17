package ru.kpfu.bookstore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.bookstore.models.PublishingHouse;

@Repository
public interface PublishingHouseRepository  extends CrudRepository<PublishingHouse, Integer>{}
