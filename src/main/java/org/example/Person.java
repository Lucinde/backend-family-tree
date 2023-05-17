package org.example;

import java.util.ArrayList;

public class Person {
    /* variabelen */
    private String name;
    private String middleName;
    private String lastName;
    private char sex;
    private int age;
    Person mother;
    Person father;
    ArrayList<Person> siblings = new ArrayList<>();
    ArrayList<Person> children = new ArrayList<>();
    ArrayList<Pet> pets = new ArrayList<>();

    /* constructor */
    public Person(String name, String lastName, char sex, int age) {
        this.name = name;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
    }

    public Person(String name, String middleName, String lastName, char sex, int age) {
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
    }

    /* methodes */
    public void addParents(Person mother, Person father) {
        setMother(mother);
        setFather(father);
        father.addChild(this, mother);
    }

    //this moet altijd de vader zijn
    public void addChild(Person child, Person mother){
        children.add(child);
        mother.setChildren(children);
        child.setFather(this);
        child.setMother(mother);
    }

    public void addPet(Pet pet){
        pets.add(pet);
        pet.setOwner(this);
    }

    public void addSibling(Person person, Person sibling){
        if(person.getSiblings() != null){
            for (Person people : person.getSiblings()) {
                siblings.add(people);
            }
        }
        siblings.add(sibling);
        person.setSiblings(siblings);
    }

    public ArrayList<Person> getGrandChildren() {
        ArrayList<Person> grandchildren = new ArrayList<>();

        for (Person child : children) {
            grandchildren.addAll(child.children);
        }

        return grandchildren;
    }

    public ArrayList<Pet> getPetGrandchildren() {
        ArrayList<Pet> petGrandchildren = new ArrayList<>();
        for (Person grandchild : getGrandChildren()) {
            petGrandchildren.addAll(grandchild.getPets());
        }
        return petGrandchildren;
    }

    /* getters & setters */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public ArrayList<Person> getSiblings() {
        return siblings;
    }

    public void setSiblings(ArrayList<Person> siblings) {
        this.siblings = siblings;
    }

    public ArrayList<Person> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Person> children) {
        this.children = children;
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }

}
