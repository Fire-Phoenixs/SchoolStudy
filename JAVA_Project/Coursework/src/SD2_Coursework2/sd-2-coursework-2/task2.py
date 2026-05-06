class PizzaQueue:
    def __init__(self, hunger_list, slices):
        self.hunger_list = sorted(hunger_list, key = lambda x: x[1])
        self.slices = slices

        self.currentIndex = 0
        self.sliceCount = 1

    def eat(self, n):
        name, hunger = self.hunger_list[n]
        self.hunger_list[n] = (name, hunger - 1)

        numberOfStudents = len(self.hunger_list)
        next_n = (n + 1) % numberOfStudents

        for _ in range(numberOfStudents):
            if self.hunger_list[next_n][1] > 0:
                return next_n
            elif self.hunger_list[next_n][1] == 0:
                next_n = (next_n + 1) % numberOfStudents
        return None

    def __iter__(self):
        return self

    def __next__(self):
        if self.slices <= 0 or self.currentIndex is None:
            raise StopIteration
        sliceToGive = self.sliceCount
        currentName = self.hunger_list[self.currentIndex][0]
        self.currentIndex = self.eat(self.currentIndex)
        self.sliceCount += 1
        self.slices -= 1
        return (currentName, sliceToGive)

# Test
hunger_list = [ ("Bart",   5)
              , ("Lisa",   2)
              , ("Homer",  9)
              , ("Marge",  3)
              , ("Maggie", 2)
              ]

pq1 = PizzaQueue(hunger_list, 30)

for x in pq1:
    print(x)

print("-----")

pq2 = PizzaQueue(hunger_list, 10)

for x in pq2:
    print(x)
