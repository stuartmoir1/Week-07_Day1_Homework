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

    @Before
    public void before() {
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

    // Initialise
    @Test
    public void testAllMoviesInArray() {
        Ranking rankings = new Ranking(movies);
        for (int i = 0; i < 10; i++) {
            assertEquals(movies[i].toString(), rankings.getMovieByRank(i + 1).toString());
        }
    }

    // Replace
    @Test
    public void testReplaceExistingMovie() {
        Ranking rankings = new Ranking(movies);
        int rank = 10;
        Movie newMovie = new Movie("The Lord of the Rings: The Fellowship of the Ring",
                "Fantasy", rank);
        rankings.setMovie(newMovie);
        assertEquals(newMovie.toString(), rankings.getMovieByRank(rank).toString());
    }

    // Find by title.
    @Test
    public void testFindMovieByTitle() {
        Ranking rankings = new Ranking(movies);
        String title = "Pulp Fiction";
        assertEquals(movie7.toString(), rankings.getMovieByTitle(title).toString());
    }

    // Change rank.

    // Increase

    @Test
    public void testIncreaseMovieRankingByOneNotTop() {
        Ranking rankings = new Ranking(movies);
        rankings.changeMovieRanking(movie4, 1);
        assertEquals("Title: The Dark Knight, Genre: Action, Ranking: 3",
                rankings.getMovieByRank(4).toString());
    }

    @Test
    public void testIncreaseMovieRankingByTwoNotTop() {
        Ranking rankings = new Ranking(movies);
        rankings.changeMovieRanking(movie4, 2);
        assertEquals("Title: The Dark Knight, Genre: Action, Ranking: 2",
                rankings.getMovieByRank(4).toString());
    }

    @Test
    public void testIncreaseMovieRankingByThreeTop() {
        Ranking rankings = new Ranking(movies);
        rankings.changeMovieRanking(movie4, 3);
        assertEquals("Title: The Dark Knight, Genre: Action, Ranking: 1",
                rankings.getMovieByRank(4).toString());
    }

    // Do nothing if change would put object 'below' index 0.
    @Test
    public void testIncreaseMovieRankingExceedTop() {
        Ranking rankings = new Ranking(movies);
        rankings.changeMovieRanking(movie4, 4);
        assertEquals(movie4.toString(), rankings.getMovieByRank(4).toString());
    }

    // Decrease

    @Test
    public void testDecreaseMovieRankingByOneNotBottom() {
        Ranking rankings = new Ranking(movies);
        rankings.changeMovieRanking(movie7, -1);
        assertEquals("Title: Pulp Fiction, Genre: Drama, Ranking: 8",
                rankings.getMovieByRank(7).toString());
    }

    @Test
    public void testDecreaseMovieRankingByTwoNotBottom() {
        Ranking rankings = new Ranking(movies);
        rankings.changeMovieRanking(movie7, -2);
        assertEquals("Title: Pulp Fiction, Genre: Drama, Ranking: 9",
                rankings.getMovieByRank(7).toString());
    }

    @Test
    public void testDecreaseMovieRankingByThreeBottom() {
        Ranking rankings = new Ranking(movies);
        rankings.changeMovieRanking(movie7, -3);
        assertEquals("Title: Pulp Fiction, Genre: Drama, Ranking: 10",
                rankings.getMovieByRank(7).toString());

    }

    // Do nothing if change would put object 'above' index 0.
    @Test
    public void testDecreaseMovieRankingByExceedBottom() {
        Ranking rankings = new Ranking(movies);
        rankings.changeMovieRanking(movie7, -4);
        assertEquals(movie7.toString(), rankings.getMovieByRank(7).toString());
    }

    @Test
    public void testSortMoviesInArray(){
        Movie[] mixedUpMovies = new Movie[]{movie3, movie7, movie9, movie4, movie6, movie10,
                movie1, movie5, movie2, movie8};
        Ranking rankings = new Ranking(mixedUpMovies);
        rankings.sortMoviesByRanking(mixedUpMovies);
        for (int i = 0; i < 10; i++) {
            assertEquals(movies[i].toString(), rankings.getMovieByRank(i + 1).toString());
        }
    }
}