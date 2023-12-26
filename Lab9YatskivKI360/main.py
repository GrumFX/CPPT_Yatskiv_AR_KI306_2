from Person import Person
from Sportsman import Sportsman

if __name__ == "__main__":
    # Create a regular person
    person1 = Person("Ivan", 30, "Male")
    print(person1.info())

    # Create an Sportsman
    sportsman1 =  Sportsman("John Doe", 28, "Male", "Runner", 1250)
    sportsman2 =  Sportsman("David Blake", 23, "Male", "Swimmer", 760)
    print(f"{sportsman1.name} is a {sportsman1.sport}.")
    print(sportsman1.train(3))
    print(sportsman1.compete())

    #print(f"{sportsman2.name} is a {sportsman2.sport}.")
   # print(sportsman2.train(4))
    #print(sportsman2.compete())