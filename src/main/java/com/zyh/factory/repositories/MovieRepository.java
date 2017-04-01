package com.zyh.factory.repositories;

import org.springframework.data.repository.CrudRepository;

import com.zyh.factory.domain.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long> {
    public Movie findByMlId(String mlId);
}
