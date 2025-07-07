package System;

public abstract class Animal {
    public String name;
    public int age;
    public String breed;
    public String bloodType;
    public String favoriteActivity;

    @Override
    public String toString() {
        return "name: " + name + "\n" +
                "age: " + age + "\n" +
                "Breed: " + breed + "\n" +
                "blood Type: " + bloodType + "\n" +
                "favorite Activity: " + favoriteActivity;
    }
}
