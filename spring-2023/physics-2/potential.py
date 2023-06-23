from math import log  as ln 

k = 8.987551787 * (10 ** 9)  # Coulomb's constant

class Point:

    def __init__(self, x, y):
        self.x = x
        self.y = y

    def __repr__(self):
        return f"Point({self.x}, {self.y})"

class Charge:

    def __init__(self, x, y, magnitude):
        self.x = x
        self.y = y
        self.magnitude = magnitude

    def __repr__(self):
        return f"Charge(x: {self.x}, y: {self.y}, m: {self.magnitude})"

    def get_potential(self, point):
        """
        Calculates the electric potential at the point due to this charge.

        Args:
            point: The point.

        Returns:
            The electric potential at the point.
        """
        return k * self.magnitude / dist((point.x - self.x), (point.y - self.y)) 


"""
distributes given given charge, given amount of time equally space between -+L y axis, and returns charges
"""
def distribute_charges(magnitude, x, y, n):
    if n < 1:
        return [Charge(x, 0, magnitude)] 
    charges = []
    new_y = -y
    charges.append(Charge(x, new_y, magnitude / n))
    for i in range(1, n):
        new_y += (2 * y) / (n - 1)  # distance between charge
        charges.append(Charge(x, new_y, magnitude / n))
    return charges

"""
return total potential at given point which is produced by passed list of charges
"""
def total_potential(charges, point):
    total = 0
    for charge in charges: 
        total += charge.get_potential(point)
    return total

"""
finds euclidean distance
"""
def dist(x, y):
    return (x ** 2 + y ** 2) ** .5 

def get_rod_potential(q, a, x):
    d = dist(a, x)
    return k * q / (2 * a) * ln((d + a) / (d - a))

X = 1 # meter, x distance
Q = 10 ** -9 # charge in cloumb
L = 1 # meter, y distance

p = Point(X, 0) # represent point p

rod_potential = get_rod_potential(Q, L, X)
print(f"rod potential: {rod_potential}")

for n in range(0, 10, 2):
    charges = distribute_charges(Q, 0, L, n)
    # print(charges)
    v_point = total_potential(charges, p)
    print(f"distributed into {n} pieces: {v_point} V")

#
# very large value n
for i in range(2, 8):
    n = 10 ** i 
    charges = distribute_charges(Q, 0, L, n)
# print(charges)
    v_point = total_potential(charges, p)
    diff = abs(rod_potential - v_point)
    print(f"distributed into {n} pieces: {v_point} V, diff with rod: {diff}")

"""
When VN grows, electric potential converges to V0 wihch potential of the rod.
"""
