package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person grandfather;
    Person grandmother;
    Person father;
    Person mother;
    Person sister;
    Person brother;
    Person child;
    Pet dog;
    Pet cat;

    @BeforeEach
    void setUp() {
        grandfather = new Person("Fosco", "Baggins", 'm', 67);
        grandmother = new Person("Ruby", "Bolger", 'v', 65);
        father = new Person("Drogo", "Baggins", 'm', 45);
        mother = new Person("Primula", "Brandybuck", 'v', 40);
        sister = new Person("Dora", "Baggins", 'v', 47);
        brother = new Person("Dudo", "Baggins", 'm', 41);
        child = new Person("Frodo", "Baggins", 'm', 16);
        dog = new Pet("Bree", 5, "dog");
        cat = new Pet("Erebor", 7, "cat");
    }

    @Test
    void addParents() {
        //arrange
        //alle gegevens voor de arrange zijn al gezet in de variabelen en setup, deze kan dus leeg blijven bij veel methodes, om wel de goede opzet te onthouden heb ik hem er wel telkens tussen gezet

        //act
        child.addParents(mother, father);

        //assert
        assertEquals("Primula", child.getMother().getName());
        assertEquals("Drogo", child.getFather().getName());
    }

    @Test
    void addChild() {
        //arrange

        //act
        father.addChild(child, father);

        //assert
        assertEquals("Frodo", father.getChildren().get(0).getName());
    }

    @Test
    void addPet() {
        //arrange

        //act
        father.addPet(cat);
        //assert
        assertEquals("Erebor", father.getPets().get(0).getName());
        assertEquals("Drogo", cat.owner.getName());

    }

    @Test
    void addSibling() {
        //arrange

        //act
        father.addSibling(father, sister);

        //assert
        assertEquals("Dora", father.getSiblings().get(0).getName());
    }

    @Test
    void getGrandChildren() {
        //arrange
        Person child2 = new Person("Bilbo", "Baggins", 'm', 16);
        child.addParents(mother, father);
        child2.addParents(mother, father);
        grandfather.addChild(father, grandmother);

        //act
        grandfather.getGrandChildren();
        ArrayList<Person> listGrandchildren = grandfather.getGrandChildren();

        //assert
        assertEquals("Frodo", listGrandchildren.get(0).getName());
        assertEquals("Bilbo", listGrandchildren.get(1).getName());
    }

    @Test
    void getName() {
        //arrange

        //act
        String name = father.getName();

        //assert
        assertEquals("Drogo", name);
    }

    @Test
    void setName() {
        //arrange

        //act
        father.setName("Draco"); //andere naam dan in de setup om zeker te weten dat hij niet de naam uit de setup blijft houden

        //assert
        assertEquals("Draco", father.getName());
    }

    @Test
    void getMiddleName() {
        //arrange
        child.setMiddleName("Bilbo");

        //act
        String output = child.getMiddleName();

        //assert
        assertEquals("Bilbo", output);
    }

    @Test
    void setMiddleName() {
        //arrange

        //act
        child.setMiddleName("Bilbo");

        //assert
        assertEquals("Bilbo", child.getMiddleName());
    }

    @Test
    void getLastName() {
        //arrange

        //act
        String output = child.getLastName();

        //assert
        assertEquals("Baggins", output);
    }

    @Test
    void setLastName() {
        //arrange

        //act
        father.setLastName("Took"); //andere naam dan in de setup om zeker te weten dat hij niet de naam uit de setup blijft houden

        //assert
        assertEquals("Took", father.getLastName());

    }

    @Test
    void getSex() {
        //arrange

        //act
        char output = child.getSex();

        //assert
        assertEquals('m', output);
    }

    @Test
    void setSex() {
        //arrange

        //act
        child.setSex('v'); //anders dan in de setup om zeker te weten dat hij niet de naam uit de setup blijft houden

        //assert
        assertEquals('v', child.getSex());
    }

    @Test
    void getAge() {
        //arrange

        //act
        int output = child.getAge();

        //assert
        assertEquals(16, output);
    }

    @Test
    void setAge() {
        //arrange

        //act
        father.setAge(52); //anders dan in de setup om zeker te weten dat hij niet de naam uit de setup blijft houden

        //assert
        assertEquals(52, father.getAge());
    }

    @Test
    void getMother() {
        //arrange
        child.addParents(mother, father);

        //act
        String output = child.getMother().getName();

        //assert
        assertEquals("Primula", output);
    }

    @Test
    void setMother() {
        //arrange

        //act
        child.setMother(mother);

        //assert
        assertEquals("Primula", child.getMother().getName());
    }

    @Test
    void getFather() {
        //arrange
        child.addParents(mother, father);

        //act
        String output = child.getFather().getName();

        //assert
        assertEquals("Drogo", output);
    }

    @Test
    void setFather() {
        //arrange

        //act
        child.setFather(father);

        //assert
        assertEquals("Drogo", child.getFather().getName());
    }

    @Test
    void getSiblings() {
        //arrange
        father.addSibling(father, sister);

        //act
        String output = father.getSiblings().get(0).getName();

        //assert
        assertEquals("Dora", output);
    }

    @Test
    void setSiblings() {
        //arrange
        ArrayList<Person> siblings = new ArrayList<>();
        siblings.add(sister);

        //act
        father.setSiblings(siblings);

        //assert
        assertEquals("Dora", father.getSiblings().get(0).getName());
    }

    @Test
    void getChildren() {
        //arrange
        child.addParents(mother, father);

        //act
        String output = father.getChildren().get(0).getName();

        //assert
        assertEquals("Frodo", output);
    }

    @Test
    void setChildren() {
        //arrange
        ArrayList<Person> children = new ArrayList<>();
        children.add(child);

        //act
        father.setChildren(children);

        //assert
        assertEquals("Frodo", father.getChildren().get(0).getName());
    }

    @Test
    void getPets() {
        //arrange
        father.addPet(cat);

        //act
        String output = father.getPets().get(0).getName();

        //assert
        assertEquals("Erebor", output);
    }

    @Test
    void setPets() {
        //arrange
        ArrayList<Pet> pets = new ArrayList<>();
        pets.add(cat);

        //act
        father.setPets(pets);

        //assert
        assertEquals("Erebor", father.getPets().get(0).getName());
    }
}