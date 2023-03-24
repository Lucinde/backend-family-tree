package org.example;

public class Main {
    public static void main(String[] args) {

        Person grandfather = new Person("Fosco", "Baggins", 'm', 67);
        Person grandmother = new Person("Ruby", "Bolger", 'v', 65);
        Person father = new Person("Drogo", "Baggins", 'm', 45);
        Person mother = new Person("Primula", "Brandybuck", 'v', 40);
        Person sister = new Person("Dora", "Baggins", 'v', 47);
        Person brother = new Person("Dudo", "Baggins", 'm', 41);
        Person child = new Person("Frodo", "Baggins", 'm', 16);
        Pet dog = new Pet("Bree", 5, "dog");
        Pet cat = new Pet("Erebor", 7, "cat");

        child.addParents(child, mother, father);
        System.out.println(child.getName() + " is een kind van " + child.getFather().getName() + " en " + child.getMother().getName());

        father.addPet(father, cat);
        System.out.println(father.getPets().get(0).getName() + " is een huisdier van " + father.getName());

    }
}