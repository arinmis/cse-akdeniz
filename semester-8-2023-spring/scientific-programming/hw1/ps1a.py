###########################
# 6.0002 Problem Set 1a: Space Cows 
# Name:
# Collaborators:
# Time:

from ps1_partition import get_partitions
from time import time
from pprint import pprint

#================================
# Part A: Transporting Space Cows
#================================

# Problem 1
def load_cows(filename):
    """
    Read the contents of the given file.  Assumes the file contents contain
    data in the fjrm of comma-separated cow name, weight pairs, and return a
    dictionary containing cow names as keys and corresponding weights as values.

    Parameters:
    filename - the name of the data file as a string

    Returns:
    a dictionary of cow name (string), weight (int) pairs
    """
    # TODO: Your code here
    with open(filename, 'r') as file:
        content = file.read()
        return {
            line.split(",")[0]: int(line.split(",")[1]) 
            for line in file.read().split("\n")
        }

# Problem 2
def greedy_cow_transport(cows,limit=10):
    """
    Uses a greedy heuristic to determine an allocation of cows that attempts to
    minimize the number of spaceship trips needed to transport all the cows. The
    returned allocation of cows may or may not be optimal.
    The greedy heuristic should follow the following method:

    1. As long as the current trip can fit another cow, add the largest cow that will fit
        to the trip
    2. Once the trip is full, begin a new trip to transport the remaining cows

    Does not mutate the given dictionary of cows.

    Parameters:
    cows - a dictionary of name (string), weight (int) pairs
    limit - weight limit of the spaceship (an int)
    
    Returns:
    A list of lists, with each inner list containing the names of cows
    transported on a particular trip and the overall list containing all the
    trips
    """
    if limit < 10:
        raise Exception(f"Limit must be greater and equal to 10, current limit {limit}")
    # TODO: Your code here
    sorted_cows = {k: cows[k] for k in sorted(cows)}
    trips = []
    capacity = limit
    heaviest_cow = next(iter(sorted_cows))
    while not len(sorted_cows) == 0:
        shipped_cows = []
        while not heaviest_cow == None and capacity >= sorted_cows[heaviest_cow]:  
            shipped_cows.append(heaviest_cow)
            capacity -= sorted_cows[heaviest_cow]
            del sorted_cows[heaviest_cow] 
            heaviest_cow = next(iter(sorted_cows), None)
        trips.append(shipped_cows)
        capacity = limit
    return trips


# Problem 3
def brute_force_cow_transport(cows,limit=10):
    """
    Finds the allocation of cows that minimizes the number of spaceship trips
    via brute force.  The brute force algorithm should follow the following method:

    1. Enumerate all possible ways that the cows can be divided into separate trips 
        Use the given get_partitions function in ps1_partition.py to help you!
    2. Select the allocation that minimizes the number of trips without making any trip
        that does not obey the weight limitation
            
    Does not mutate the given dictionary of cows.

    Parameters:
    cows - a dictionary of name (string), weight (int) pairs
    limit - weight limit of the spaceship (an int)
    
    Returns:
    A list of lists, with each inner list containing the names of cows
    transported on a particular trip and the overall list containing all the
    trips
    """
    # TODO: Your code here

    trips = [t for t in get_partitions(cows.keys()) if is_valid_trip(cows, t, limit)]
    # pprint(trips)
    return min(trips, key=len)  

# Problem 4
def compare_cow_transport_algorithms():
    """
    Using the data from ps1_cow_data.txt and the specified weight limit, run your
    greedy_cow_transport and brute_force_cow_transport functions here. Use the
    default weight limits of 10 for both greedy_cow_transport and
    brute_force_cow_transport.
    
    Print out the number of trips returned by each method, and how long each
    method takes to run in seconds.

    Returns:
    Does not return anything.
    """
    # TODO: Your code here
    # cows = load_cows("ps1_cow_data.txt")
    test_cows = {'Jesse':6, 'Maybel': 3, 'Callie': 2, "Maggie": 5}
    greedy_trip, time_g = calc_time_elapsed(greedy_cow_transport, [test_cows])
    seperator = f"\n{'-' * 20}\n"
    print(seperator)
    print(f"greedy trip: {greedy_trip}\nelapsed time: {time_g}")
    brute_force_trip, time_bf = calc_time_elapsed(brute_force_cow_transport, [test_cows])
    print(seperator)
    print(f"brute force trip: {brute_force_trip}\nelapsed time: {time_bf}")
    print(seperator)


def is_valid_trip(cows, trip, limit):
    """
    Detemine whether given trip is valid or not
    """
    for ship in trip:
        # print(sum([cows[cow] for cow in ship]), sum([cows[cow] for cow in ship]) > limit, [cows[cow] for cow in ship], trip)
        if  sum([cows[cow] for cow in ship]) > limit:
                return False
    return True

"""
returns elapsed time and output of function 
called with list of given parameters
"""
def calc_time_elapsed(func, params):
    start_time = time()
    result = func(*params)
    end_time = time()
    return (result, end_time - start_time) 


if __name__ == "__main__":
    # cows = load_cows("ps1_cow_data.txt")
    """
    test_cows = {'Jesse':6, 'Maybel': 3, 'Callie': 2, "Maggie": 5}
    trip = greedy_cow_transport(test_cows)
    print(f"greedy trip: {trip}")
    brute_force_trip = brute_force_cow_transport(test_cows)
    print(f"brute force trip: {brute_force_trip}")
    """
    compare_cow_transport_algorithms()
