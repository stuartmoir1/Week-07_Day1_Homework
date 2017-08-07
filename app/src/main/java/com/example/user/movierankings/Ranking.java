package com.example.user.movierankings;

/**
 * Created by user on 07/08/2017.
 */

public class Ranking {

    private Movie[] movies;

    public Ranking(Movie[] movies){
        this.movies = movies;
    }

    public Movie getMovie(int ranking){
        return movies[ranking];
    }

    public void setMovie(Movie movie){
        movies[movie.getRanking() - 1] = movie;
    }
}
