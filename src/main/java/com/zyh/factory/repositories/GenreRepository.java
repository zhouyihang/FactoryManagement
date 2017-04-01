package com.zyh.factory.repositories;

import org.springframework.data.repository.CrudRepository;

import com.zyh.factory.domain.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long> {
    Genre findByMlId(String mlId);
}
