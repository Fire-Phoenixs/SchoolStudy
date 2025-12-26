package Test;

class Pet {
    protected String name;
    public Pet(String name, int age) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name + " eat...");
    }

    public void drink() {
        System.out.println(name + " drink...");
    }

    public void shout() {
        System.out.println(name + " shout...");
    }
}

class Cat extends Pet {
    public Cat(String name, int age) {
        super(name, age);
    }

    public void climbTrees() {
        System.out.println(name + "climbTrees...");
    }
}

class Dog extends Pet {
    public Dog(String name, int age) {
        super(name, age);
    }

    public void policeWork() {
        System.out.println(name + "policeWork...");
    }
}
public class PET {

}
