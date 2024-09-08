package com.boot_camp2.serviceimpl;

import com.boot_camp2.Dao.MovieResponse;
import com.boot_camp2.entity.Movie;
import com.boot_camp2.repository.MovieRepo;
import com.boot_camp2.service.MovieService;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

import org.h2.command.dml.MergeUsing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;;import java.util.Optional;

@SpringBootTest
class MovieServiceImplTest {

    @Mock
    private MovieRepo movieRepo;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private MovieServiceImpl movieServiceImpl;

    Movie movie;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

    }

    @Test
    void findByIdTest() {
      when(movieRepo.findById(1)).thenReturn(createStubMovie());
        Movie returnedMovie=movieServiceImpl.findById(1);
        assertEquals(returnedMovie.getHero(),"Yash");

    }
     private Optional<Movie> createStubMovie(){
                Movie stubMovie=Movie.builder().id(1).movieName("KGF").hero("Yash").director("Prasanthneel").build();
                return Optional.of(stubMovie);
     }
}

