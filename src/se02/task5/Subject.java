package se02.task5;

public enum Subject {
    MATH("Math", Double.class),
    HISTORY("History", Integer.class),
    GEOGRAPHY("Geography", Integer.class),
    ENGLISH("English", Double.class);

    private String nameOfSubject;
    private Class<?> classType;

    Subject(String name, Class<?> classType) {
        this.nameOfSubject = name;
        this.classType = classType;
    }

    public Class<?> getClassType() {
        return classType;
    }

    public String getNameOfSubject(){
        return nameOfSubject;
    }
}
