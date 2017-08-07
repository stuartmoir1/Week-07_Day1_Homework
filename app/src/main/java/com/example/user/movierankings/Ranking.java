package com.example.user.movierankings;

/**
 * Created by user on 07/08/2017.
 */

public class Ranking {

    private Movie[] movies;

    public Ranking(Movie[] movies){
        this.movies = movies;
    }

    public Movie getMovieByRank(int ranking){
        return movies[ranking];
    }

    public void setMovie(Movie movie){
        movies[movie.getRanking() - 1] = movie;
    }

    public Movie getMovieByTitle(String title){
        for(Movie movie : movies){
            if(movie.getTitle() == title){
                return movie;
            }
        }
        return null;
    }

    public void changeMovieRanking(Movie movie, int change){
        if( (change > 0) && (movie.getRanking() - change > 0) ){
            movie.setRanking(movie.getRanking() - change);
        } else if ( (change < 0) && (movie.getRanking() + change < 10) ){
            movie.setRanking(movie.getRanking() - change);
        } else {
            // Do nothing.
        }
    }
}
