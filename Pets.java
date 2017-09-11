import tester.Tester;

// to represent a pet owner
class Person {
    String name;
    IPet pet;
    int age;

    Person(String name, IPet pet, int age) {
        this.name = name;
        this.pet = pet;
        this.age = age;
    }
    
    
    //  -> boolean
    //Return true if this Person is older than the given person.
    
    // TEMPLATE
    /*
     * Fields:
     *   ...this.age... -- int
     *   
     * Methods:
     *   ...this.isOlder(Person other)... --boolean
     *   
     */
    boolean isOlder(Person other) {
      if (this.age > other.age) {
      	return true;
      } else {
      	return false;
      }
    }
}

// to represent a pet
interface IPet { }

// to represent a pet cat
class Cat implements IPet {
    String name;
    String kind;
    boolean longhaired;

    Cat(String name, String kind, boolean longhaired) {
        this.name = name;
        this.kind = kind;
        this.longhaired = longhaired;
    }
}

// to represent a pet dog
class Dog implements IPet {
    String name;
    String kind;
    boolean male;

    Dog(String name, String kind, boolean male) {
        this.name = name;
        this.kind = kind;
        this.male = male;
    }
}

//Examples and tests for IPets and Persons
class ExamplesIPet {
  ExamplesIPet () {}
    
    //Examples of pets
    IPet bella = new Dog("Bella", "dalmatian", false);
    IPet bart = new Dog("Bartolome", "shih tzu", true);
    IPet momon = new Cat("Salmon", "siamese", false);
    IPet nigell = new Cat("Nigell", "siberian", true);
    
    //Examples of persons
    Person one = new Person("Alyssa", bart, 19);
    Person two = new Person("Candace", bella, 24);
    Person three = new Person("Jezza", momon, 18);
    Person four = new Person("Chaelle", nigell, 26);
    
    //test the method isOlder for the class Person
    boolean testIsOlder(Tester t) {
    	return
    		t.checkExpect(this.one.isOlder(two), false) &&
    	    t.checkExpect(this.two.isOlder(one), true) &&
    	    t.checkExpect(this.three.isOlder(two), false) &&
    	    t.checkExpect(this.four.isOlder(one), true) &&
    	    t.checkExpect(this.one.isOlder(three), true);
    }
}


