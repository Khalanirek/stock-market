package com.khalanirek.stockmarket.common

class InMemoryBaseRepository<T extends BaseEntity> implements BaseRepository<T> {

    protected Map<UUID, T> store = new HashMap<>()

    @Override
    <S extends T> S save(S entity) {
        store.put(entity.id, entity)
        return entity
    }

    @Override
    <S extends T> Iterable<S> saveAll(Iterable<S> entities) {
        return entities.forEach { entity -> store.put(entity.id, entity)}
    }

    @Override
    Optional<T> findById(UUID id) {
        return Optional.ofNullable(store.get(id))
    }

    @Override
    boolean existsById(UUID id) {
        return store.get(id) != null
    }

    @Override
    Iterable<T> findAll() {
        return store.values()
    }

    @Override
    Iterable<T> findAllById(Iterable<UUID> ids) {
        return store.findAll {entry -> ids.contains(entry.key)}.collect()
    }

    @Override
    long count() {
        return store.values().size()
    }

    @Override
    void deleteById(UUID id) {
        store.remove(id)
    }

    @Override
    void delete(T entity) {
        store.remove(entity)
    }

    @Override
    void deleteAllById(Iterable<? extends UUID> uuids) {
        store.removeAll {entry -> uuids.contains(entry.key) }
    }

    @Override
    void deleteAll(Iterable<? extends T> entities) {
        def ids = entities.collect(it -> it.id)
        store.removeAll {entry -> ids.contains(entry.key) }
    }

    @Override
    void deleteAll() {
        store.clear()
    }

}
