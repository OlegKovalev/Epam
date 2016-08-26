package se04.task4;

import java.io.*;
import java.util.ArrayList;

public class FilmCollection implements Serializable {

//    public static final String fileName = "E:\\GitHub\\Epam\\src\\se04\\resources\\task4\\films.ser";
    public static final String fileName = "./src/se04/resources/task4/films.ser";


    private ArrayList<Film> filmsList = new ArrayList<>();

    public void saveFilmCollection() {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            File file = new File(fileName);
            oos.writeObject(filmsList);
            oos.flush();

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
            System.out.println("Read file exception!");
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

    public void removeAll() {
        filmsList.clear();
    }
}

/*available() returns an estimation of the number of bytes that can be read without blocking. 
            The base InputStream implementation always returns 0, because this is a valid estimation. 
            But whatever it returns, the fact that it returns 0 doesn't mean that there is nothing to read anymore. 
            Only that the stream can't guarantee that at least one byte can be read without blocking.*/
//            if (ois.available() > 0) {
//              ois.readObject();
//            }
