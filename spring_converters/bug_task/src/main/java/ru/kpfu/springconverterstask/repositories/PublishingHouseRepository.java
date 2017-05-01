package ru.kpfu.springconverterstask.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.springconverterstask.models.PublishingHouse;

@Repository
public interface PublishingHouseRepository  extends CrudRepository<PublishingHouse, Integer>{}
