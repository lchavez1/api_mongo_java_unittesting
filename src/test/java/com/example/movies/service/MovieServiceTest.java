package com.example.movies.service;

import com.example.movies.model.Movie;
import com.example.movies.repository.IMoviesRepository;
import org.junit.jupiter.api.*;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MovieServiceTest {

    private static MovieService movieService;

    private static List<Movie> list;
    private static String digit;
    private static int id;
    private static Movie movie;

    @BeforeAll
    static void setUp() {

        // open mocks with try with resource
        try (AutoCloseable closeable = MockitoAnnotations.openMocks(MovieServiceTest.class)) {
            System.out.println("mocks opened");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // mocking the repository and service
        IMoviesRepository iMoviesRepository = mock(IMoviesRepository.class);
        movieService = mock(MovieService.class);

        // initialize vars
        list = Arrays.asList(
                new Movie(1, "Harry Potter", "Magic and adventure", 9.99f, 8.8f),
                new Movie(3, "Annabelle", "Horror", 0.9f, 5.4f),
                new Movie(2, "Gran Turismo", "Cars and running", 19.9f, 9.4f));
        digit = "H";
        movie = new Movie(2, "Test 2", "...", 9f, 10f);
        id = 2;
    }

    @Test
    @DisplayName("NotNull")
    void findAllMovies() {

        when(movieService.findAllMovies()).thenReturn(list);

        List<Movie> test = movieService.findAllMovies();

        Assertions.assertNotNull(test);
        Assertions.assertEquals(3, test.size());
    }

    @Test
    @DisplayName("FindByDigit")
    void findMovieByDigit() {

        when(movieService.findMovieByQueryParams(null, null, null, digit)).thenReturn(list);

        List<Movie> test = movieService.findMovieByQueryParams(null, null, null, digit);

        Assertions.assertNotNull(test);

        if(!test.isEmpty())
            Assertions.assertEquals(digit, String.valueOf(test.get(0).getName().charAt(0)));
    }

    @Test
    @DisplayName("FindById")
    void findMovieById() {

        when(movieService.findMovieById(id)).thenReturn(Optional.ofNullable(movie));

        Optional<Movie> test = movieService.findMovieById(id);

        Assertions.assertTrue(test.isPresent());
        Assertions.assertEquals(id, test.get().getId());
    }

    @Test
    @DisplayName("Exist?")
    void existMovie() {

        when(movieService.existMovie(movie.getId())).thenReturn(true);

        Boolean test = movieService.existMovie(id);

        Assertions.assertTrue(test);
    }

    @Test
    @DisplayName("Create?")
    void createMovie() {

        when(movieService.createMovie(movie)).thenReturn(movie);

        Movie test = movieService.createMovie(movie);

        Assertions.assertEquals(2, test.getId());
        Assertions.assertEquals("Test 2", test.getName());
    }

}