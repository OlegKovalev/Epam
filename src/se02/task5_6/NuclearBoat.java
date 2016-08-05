package se02.task5_6;

public class NuclearBoat {

    private String nameOfBoat;

    public NuclearBoat() {
    }

    public NuclearBoat(String nameOfBoat) {
        this.nameOfBoat = nameOfBoat;
    }

    public String getNameOfBoat() {
        return nameOfBoat;
    }

    public void setNameOfBoat(String nameOfBoat) {
        this.nameOfBoat = nameOfBoat;
    }

    public void setsSail(){
        EngineOfNuclearBoat engine = new EngineOfNuclearBoat();
        engine.go();
    }

    public class EngineOfNuclearBoat {

        public void go() {
            System.out.println("Nuclear boat " + nameOfBoat + " sets sail!");
        }
    }
}
