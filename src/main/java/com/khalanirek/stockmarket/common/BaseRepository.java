package com.khalanirek.stockmarket.common;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BaseRepository<T extends BaseEntity> extends CrudRepository<T, UUID> {
}
