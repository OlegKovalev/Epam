package se04.task4;

import java.io.*;
import java.util.ArrayList;

public class FilmCollection {

    public static final String fileName = "./src/se04/task4/resource/films.ser";


    private ArrayList<Film> filmsList = new ArrayList<>();

    public void saveFilmCollection() {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            File file = new File(fileName);
            if (file.createNewFile()) {
                oos.writeObject(filmsList);
            }
        } catch (IOException exc) {
            System.out.println("Write file exception!");
        }
    }

    public void restoreFilmCollection() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            filmsList = (ArrayList<Film>) ois.readObject();
        } catch (ClassNotFoundException exc) {
            System.out.println("File not found!");
        } catch (IOException exc) {
            System.out.println("Write file exception!");
        }
    }

    public ArrayList<Film> getFilmsList() {
        return filmsList;
    }

    public void setFilmsList(ArrayList<Film> filmsList) {
        if (filmsList.size() > 0) {
            this.filmsList = filmsList;
        }
    }

    public void addFilm(Film film) {
        filmsList.add(film);
    }
}
