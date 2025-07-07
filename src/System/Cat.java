package System;

public class Cat extends Animal {
    public boolean meowsALot;

    @Override
    public String toString() {
        return "Type: Cat\n" +
                super.toString() + "\n" +
                "Does the cat meow a lot: " + (meowsALot ? "Yes" : "No");
    }
}

