package System;

public class Dog extends Animal {
    public boolean barksALot;

    @Override
    public String toString() {
        return "Type: Dog\n" +
                super.toString() + "\n" +
                "Does the dog barks a lot: " + (barksALot ? "Yes" : "No");
    }
}

