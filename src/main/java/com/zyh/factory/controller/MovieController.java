package com.zyh.factory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zyh.factory.domain.Movie;
import com.zyh.factory.repositories.MovieRepository;

@RestController
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public Iterable<Movie> movies() {
        return movieRepository.findAll();
    }

    @RequestMapping(value = "/movies/{mlId}", method = RequestMethod.GET)
    public Movie movie(@PathVariable String mlId) {
        return movieRepository.findByMlId(mlId);
    }
}
