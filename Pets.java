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
    return (this.age > other.age);
  }
    
    // -> Person
    //To produce this new person with no pet or a pet that has perished
    //TEMPLATE
    /*Fields:
     * ...this.name... --String
     * ...this.age... --int
     * ...this.pet... - IPet
     * 
     * Methods:
     * ...this.perish... --Person
     */
    
  Person perish(IPet none) {
  	return new Person(this.name, none, this.age);
  }
}

// to represent a pet
interface IPet { 
  boolean sameNamePet(String name);
}

//to represent no pet
class NoPet implements IPet {
	NoPet() {}
	
	public boolean sameNamePet(String name) {
		return false;
	}
}

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
    
//TEMPLATE
/* Fields: 
* ...this.name... -- String
* 
* Methods:
* ...this.sameNamePet(String that)... -- boolean
* 
*/
    
  public boolean sameNamePet(String name) {
  	return this.name == name;
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
    
//TEMPLATE
/* Fields: 
* ...this.name... -- String
* 
* Methods:
* ...this.sameNamePet(String that)... -- boolean
* 
*/
    
  public boolean sameNamePet(String name) {
   return this.name == name;
  }
}

//Examples and tests for IPets and Persons
class ExamplesIPet {
  ExamplesIPet () {}
    
    //Examples of pets
	IPet none  = new NoPet();
  IPet bella = new Dog("Bella", "dalmatian", false);
  IPet bart = new Dog("Bartolome", "shih tzu", true);
  IPet momon = new Cat("Salmon", "siamese", false);
  IPet nigell = new Cat("Nigell", "siberian", true);
   
    //Examples of persons
  Person one = new Person("Alyssa", bart, 19);
  Person two = new Person("Candace", bella, 24);
  Person three = new Person("Jezza", momon, 18);
  Person four = new Person("Chaelle", nigell, 26);
  Person five = new Person("Deboy", none, 45);
  Person six = new Person("Timothy", none, 34);
    
    
    //test the method isOlder for the class Person
  boolean testIsOlder(Tester t) {
   	return
    	t.checkExpect(this.one.isOlder(two), false) &&
 	    t.checkExpect(this.two.isOlder(one), true) &&
      t.checkExpect(this.three.isOlder(two), false) &&
      t.checkExpect(this.four.isOlder(one), true) &&
      t.checkExpect(this.one.isOlder(three), true);
  }
    
  boolean testSameNamePet(Tester t) {
  	return
  		t.checkExpect(this.nigell.sameNamePet("Nigell"), true) &&
   	  t.checkExpect(this.bella.sameNamePet("Bell"), false);
  }
    
  Person three2 = new Person("Jezza", none, 18);
  Person four2 = new Person("Chaelle", none, 26);
    
  boolean testPerish(Tester t) {
  	return
   	  t.checkExpect(this.three.perish(none), three2) &&
  		t.checkExpect(this.four.perish(none), four2);
  }
}


