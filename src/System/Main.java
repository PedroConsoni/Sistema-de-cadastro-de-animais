package System;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Creating a fixed-size array of animals
        int maxNumber = 10;
        Animal[] animals = new Animal[maxNumber];

        // Counters
        int option = 0;
        int registeredAnimals = 0;

        // Main menu loop with all options
        while (option != 6) {
            System.out.println("============================================================================= MENU =============================================================================");
            System.out.println("1. Register animals");
            System.out.println("2. List registered animals");
            System.out.println("3. View animal information");
            System.out.println("4. Update animal information");
            System.out.println("5. Delete animals");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            // Reads the user's option
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {

                // Animal registration
                case 1:
                    System.out.print("Choose option A ( Cat ) or option B ( Dog ): ");
                    String animalChoice = scanner.nextLine();

                    // Checks if there is still space in the array and if the user chose option "A"
                    if (registeredAnimals < maxNumber && animalChoice.equalsIgnoreCase("A")) {
                        Cat newCat = new Cat();
                        System.out.print("Enter your cat's name: ");
                        newCat.name = scanner.nextLine();
                        System.out.print("Enter your cat's age: ");
                        newCat.age = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter your cat's breed: ");
                        newCat.breed = scanner.nextLine();
                        System.out.print("Enter your cat's blood type ( A / B / AB ): ");
                        newCat.bloodType = scanner.nextLine();
                        System.out.print("Enter your cat's favorite activity: ");
                        newCat.favoriteActivity = scanner.nextLine();
                        System.out.print("Does the cat meow a lot? ( Yes / No ) ");
                        String meowsAnswer = scanner.nextLine();
                        newCat.meowsALot = meowsAnswer.equalsIgnoreCase("Yes");

                        animals[registeredAnimals] = newCat;
                        registeredAnimals++;

                        // Checks if there is still space in the array and if the user chose option "B"
                    } else if (registeredAnimals < maxNumber && animalChoice.equalsIgnoreCase("B")) {
                        Dog newDog = new Dog();
                        System.out.print("Enter your dog's name: ");
                        newDog.name = scanner.nextLine();
                        System.out.print("Enter your dog's age: ");
                        newDog.age = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter your dog's breed: ");
                        newDog.breed = scanner.nextLine();
                        System.out.print("Enter your dog's blood type ( DEA 1.1 / DEA 1.2 / DEA 3 / DEA 4 / DEA 5 / DEA 6 / DEA 7 / DEA 8 ): ");
                        newDog.bloodType = scanner.nextLine();
                        System.out.print("Enter your dog's favorite activity: ");
                        newDog.favoriteActivity = scanner.nextLine();
                        System.out.print("Does the dog bark a lot? ( Yes / No ) ");
                        String barksAnswer = scanner.nextLine();
                        newDog.barksALot = barksAnswer.equalsIgnoreCase("Yes");

                        animals[registeredAnimals] = newDog;
                        registeredAnimals++;
                        break;
                    } else {
                        System.out.println("You entered an invalid option");
                    }
                    break;

                case 2:

                    // Asks the user if they want to view the list of option "A" (Cat) or "B" (Dog)
                    if (registeredAnimals != 0) {
                        System.out.print("Do you want to list option A ( Cat ) or option B ( Dog )? ");
                        String listType = scanner.nextLine();

                        boolean found = false;
                        System.out.println("================================================================== Registered Animal List =================================================================");
                        for (int i = 0; i < registeredAnimals; i++) {
                            if (listType.equalsIgnoreCase("A") && animals[i] instanceof Cat) {
                                System.out.println(animals[i].name);
                                found = true;
                            } else if (listType.equalsIgnoreCase("B") && animals[i] instanceof Dog) {
                                System.out.println(animals[i].name);
                                found = true;
                            }
                        }

                        if (!found) {
                            System.out.println("No animals of the selected type were found.");
                        }

                    } else {
                        System.out.println("The list is empty.");
                    }
                    break;

                case 3:

                    // Asks the user which animal's information they want to view
                    if (registeredAnimals != 0) {
                        System.out.print("Do you want to view information of option A ( Cat ) or option B ( Dog )? ");
                        String viewChoice = scanner.nextLine();

                        boolean found = false;

                        for (int i = 0; i < registeredAnimals; i++) {
                            if (viewChoice.equalsIgnoreCase("A") && animals[i] instanceof Cat) {
                                System.out.println((i + 1) + ". " + animals[i].name);
                                found = true;
                            } else if (viewChoice.equalsIgnoreCase("B") && animals[i] instanceof Dog) {
                                System.out.println((i + 1) + ". " + animals[i].name);
                                found = true;
                            }
                        }

                        if (!found) {
                            System.out.println("There are no animals of the selected type.");
                            break;
                        }

                        // Asks for the number of the animal whose information should be displayed
                        System.out.print("Enter the animal number to view information: ");
                        int selectedIndex = scanner.nextInt();
                        scanner.nextLine();

                        if (selectedIndex >= 1 && selectedIndex <= registeredAnimals) {
                            Animal selectedAnimal = animals[selectedIndex - 1];

                            if ((viewChoice.equalsIgnoreCase("A") && selectedAnimal instanceof Cat) ||
                                    (viewChoice.equalsIgnoreCase("B") && selectedAnimal instanceof Dog)) {

                                System.out.println("================================================================================================================================================================");
                                System.out.println(selectedAnimal);
                                System.out.println("================================================================================================================================================================");

                            } else {
                                System.out.println("The selected number does not match the selected animal type.");
                            }

                        } else {
                            System.out.println("Invalid number.");
                        }

                    } else {
                        System.out.println("No animals registered.");
                    }
                    break;

                case 4:

                    // Asks the user which animal they want to update
                    if (registeredAnimals != 0) {
                        System.out.print("Do you want to update option A ( Cat ) or option B ( Dog )? ");
                        String animalType = scanner.nextLine();

                        if (animalType.equalsIgnoreCase("A") || animalType.equalsIgnoreCase("B")) {
                            System.out.println("================================================================================================================================================================");
                            for (int i = 0; i < registeredAnimals; i++) {
                                if (animalType.equalsIgnoreCase("A") && animals[i] instanceof Cat) {
                                    System.out.println((i + 1) + ". " + animals[i].name);
                                } else if (animalType.equalsIgnoreCase("B") && animals[i] instanceof Dog) {
                                    System.out.println((i + 1) + ". " + animals[i].name);
                                }
                            }

                            System.out.print("Enter the number of the animal to update: ");
                            int updateIndex = scanner.nextInt();
                            scanner.nextLine();

                            if (updateIndex >= 1 && updateIndex <= registeredAnimals) {
                                Animal selectedAnimal = animals[updateIndex - 1];

                                if (animalType.equalsIgnoreCase("A") && selectedAnimal instanceof Cat) {
                                    Cat updatedCat = (Cat) selectedAnimal;

                                    System.out.println("Updating cat data: " + updatedCat.name);

                                    System.out.print("Enter the updated cat name: ");
                                    updatedCat.name = scanner.nextLine();

                                    System.out.print("Enter the updated cat age: ");
                                    updatedCat.age = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.print("Enter the updated cat breed: ");
                                    updatedCat.breed = scanner.nextLine();

                                    System.out.print("Enter the updated cat blood type: ");
                                    updatedCat.bloodType = scanner.nextLine();

                                    System.out.print("Enter the updated favorite activity of the cat: ");
                                    updatedCat.favoriteActivity = scanner.nextLine();

                                    System.out.print("Does the cat meow a lot? ( Yes / No ): ");
                                    String meowResponse = scanner.nextLine();
                                    updatedCat.meowsALot = meowResponse.equalsIgnoreCase("Yes");

                                    System.out.println("Cat information successfully updated");

                                } else if (animalType.equalsIgnoreCase("B") && selectedAnimal instanceof Dog) {
                                    Dog updatedDog = (Dog) selectedAnimal;

                                    System.out.println("Updating dog data: " + updatedDog.name);

                                    System.out.print("Enter the updated dog name: ");
                                    updatedDog.name = scanner.nextLine();

                                    System.out.print("Enter the updated dog age: ");
                                    updatedDog.age = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.print("Enter the updated dog breed: ");
                                    updatedDog.breed = scanner.nextLine();

                                    System.out.print("Enter the updated dog blood type: ");
                                    updatedDog.bloodType = scanner.nextLine();

                                    System.out.print("Enter the updated favorite activity of the dog: ");
                                    updatedDog.favoriteActivity = scanner.nextLine();

                                    System.out.print("Does the dog bark a lot? ( Yes / No ): ");
                                    String barkResponse = scanner.nextLine();
                                    updatedDog.barksALot = barkResponse.equalsIgnoreCase("Yes");

                                    System.out.println("Dog information successfully updated");

                                } else {
                                    System.out.println("The selected number does not correspond to the selected animal type");
                                }
                            } else {
                                System.out.println("Invalid number");
                            }
                        } else {
                            System.out.println("Invalid option");
                        }
                    } else {
                        System.out.println("No animals registered");
                    }
                    break;

                case 5:

                    // Asks the user what type of animal to delete
                    if (registeredAnimals != 0) {
                        System.out.print("Do you want to delete option A ( Cat ) or option B ( Dog )? ");
                        String deleteType = scanner.nextLine();

                        boolean found = false;
                        System.out.println("=================================================================== Animal List ===================================================================");
                        for (int i = 0; i < registeredAnimals; i++) {
                            if (deleteType.equalsIgnoreCase("A") && animals[i] instanceof Cat) {
                                System.out.println((i + 1) + ". " + animals[i].name);
                                found = true;
                            } else if (deleteType.equalsIgnoreCase("B") && animals[i] instanceof Dog) {
                                System.out.println((i + 1) + ". " + animals[i].name);
                                found = true;
                            }
                        }

                        if (!found) {
                            System.out.println("There are no animals of the selected type to delete.");
                            break;
                        }

                        System.out.print("Enter the number of the animal to delete: ");
                        int deleteIndex = scanner.nextInt();
                        scanner.nextLine();

                        if (deleteIndex >= 1 && deleteIndex <= registeredAnimals) {
                            Animal selectedAnimal = animals[deleteIndex - 1];

                            boolean typeMatches = (deleteType.equalsIgnoreCase("A") && selectedAnimal instanceof Cat)
                                    || (deleteType.equalsIgnoreCase("B") && selectedAnimal instanceof Dog);

                            if (typeMatches) {
                                for (int i = deleteIndex - 1; i < registeredAnimals - 1; i++) {
                                    animals[i] = animals[i + 1];
                                }

                                animals[registeredAnimals - 1] = null;
                                registeredAnimals--;

                                System.out.println("Animal successfully deleted.");
                            } else {
                                System.out.println("The selected number does not match the selected animal type.");
                            }
                        } else {
                            System.out.println("Invalid number.");
                        }
                    } else {
                        System.out.println("There are no animals to delete.");
                    }
                    break;

                case 6:

                    // Ends the program
                    System.out.println("Program ended");
                    break;

                default:
                    System.out.println("This option is invalid");
                    break;
            }
        }
        scanner.close();
    }
}