package com.example.user.movierankings;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 07/08/2017.
 */

public class RankingTest {

    Movie[] movies;
    Movie movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10;

    @Before public void before(){
        movie1 = new Movie("The Shawshank Redemption", "Drama", 1);
        movie2 = new Movie("The Godfather", "Drama", 2);
        movie3 = new Movie("The Godfather (Part 2)", "Drama", 3);
        movie4 = new Movie("The Dark Knight", "Action", 4);
        movie5 = new Movie("12 Angry Men", "Drama", 5);
        movie6 = new Movie("Schindler's List", "Drama", 6);
        movie7 = new Movie("Pulp Fiction", "Drama", 7);
        movie8 = new Movie("The Lord of the Rings: Return of the King", "Fantasy", 8);
        movie9 = new Movie("The Good, The Bad and The Ugly", "Western", 9);
        movie10 = new Movie("Fight Club", "Drama", 10);
        movies = new Movie[]{movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8,
                movie9, movie10};
    }

    @Test public void testAllMoviesInArray(){
        Ranking rankings = new Ranking(movies);
        for (int i = 0; i < 10; i++){
            assertEquals(movies[i].toString(), rankings.getMovie(i).toString());
        }
    }

    @Test public void testAddNewMovieToEnd(){
        Ranking rankings = new Ranking(movies);
        Movie newMovie = new Movie("The Lord of the Rings: The Fellowship of the Ring",
                "Fantasy", 10);
        rankings.setMovie(newMovie);
        assertEquals(newMovie.toString(), rankings.getMovie(9).toString());
    }
}
