package se04.task4;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;


public class FilmCollectionTest {
    
    FilmCollection films;
    
    @Before
    public void setUp() throws Exception {
        films = new FilmCollection();
        
        films.addFilm(new Film("Now You See Me", new Actor("Mark","Ruffalo"), new Actor("Woody","Harrelson"), new Actor("Isla","Fisher")));
        films.addFilm(new Film("Lock, Stock and Two Smoking Barrels", new Actor("Jason","Flemyng"), new Actor("Dexter","Fletcher"), new Actor("Nick","Moran")));
        films.addFilm(new Film("Snatch", new Actor("Benicio","del Toro"), new Actor("Dennis","Farina"), new Actor("Alan","Ford")));
        assertEquals(3,films.getFilmsList().size());
    }

    @Test
    public void saveFilmCollection() throws Exception {
        films.saveFilmCollection();
    }

    @Test
    public void restoreFilmCollection() throws Exception {

    }

    @Test
    public void getFilmsList() throws Exception {

    }

    @Test
    public void setFilmsList() throws Exception {

    }

}