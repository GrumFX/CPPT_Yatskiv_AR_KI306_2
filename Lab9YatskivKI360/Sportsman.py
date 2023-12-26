from Person import Person
import random

class Sportsman(Person):
    def __init__(self, name, age, gender, sport, training_hours):
        """Initialize an athlete. Inherits from the Person class."""
        super().__init__(name, age, gender)
        self.sport = sport
        self.training_hours = training_hours

    def train(self, hours):
        """Simulate athlete training and increase training hours."""
        self.training_hours += hours
        return f"{self.name} trained for {hours} hours. Total training hours: {self.training_hours}"

    def compete(self):
        """Simulate athlete competing and decrease energy level."""
        """Introduce a random chance of winning based on training hours """
        chance_of_winning = min(0.5 + 0.1 * (self.training_hours // 10), 0.9)
        if random.random() < chance_of_winning:
            return f"{self.name} won the competition! Congratulation."
        else:
            return f"{self.name} lost the competition. Better luck next time."
