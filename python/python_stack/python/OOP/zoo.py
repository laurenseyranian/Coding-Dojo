class Animal:
    def init(self, name, age):
        self.health = 200
        self.happiness = 100
        self.name = name
        self.age = age

    def display_info(self):
        print(f"Name: {self.name}, Age: {self.age}, Health: {self.health}, Happiness: {self.happiness}")

def feed(self):
    self.health += 10
    self.happiness += 10
    self.display_info()
class Lion(Animal):
    pass

class Tiger(Animal):
    pass

class Bear(Animal):
    def init(self,name, age):
        self.hibernate = 200
        super().init(name, age)

def display_info(self):
    print(f"Name: {self.name},Age: {self.age}, Health: {self.health}, Happiness: {self.happiness}, Hibernate: {self.hibernate}")
class Zoo:
    def init(self, zoo_name):
        self.animals = {}
        self.name = zoo_name
    def add_lion(self, name, age):
        self.animals[name] = Lion(name, age)
    def add_tiger(self, name, age):
        self.animals[name] = Tiger(name, age)
    def add_bear(self, name, age):
        self.animals[name] = Bear(name, age)
    def print_all_info(self):
        print("-"30, self.name, "-"30)
        for key in self.animals:
            self.animals[key].display_info()

zoo1 = Zoo("John's Zoo")
zoo1.add_lion("Nala", 4)
zoo1.add_lion("Simba", 3)
zoo1.add_tiger("Rajah", 23)
zoo1.add_tiger("Shere Khan", 31)
zoo1.add_bear('Baloo', 8)
zoo1.print_all_info()
zoo1.animals['Nala'].feed()
zoo1.animals['Baloo'].feed()