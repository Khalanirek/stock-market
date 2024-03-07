package com.khalanirek.stockmarket.common;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
public abstract class BaseEntity <T extends com.khalanirek.stockmarket.common.Id> {

    @ToString.Include
    @Id
    protected UUID id;

    @Version
    protected long version;

    protected BaseEntity(UUID id) {
        this.id = id;
    }

    protected abstract T id();

}
