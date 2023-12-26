class Person:
    def __init__(self, name, age, gender):
        """Initialize a person."""
        self.name = name
        self.age = age
        self.gender = gender

    def info(self):
        """Information about person."""
        return f"Person name is {self.name}. Age: {self.age} years old. Gender: {self.gender}"
    

