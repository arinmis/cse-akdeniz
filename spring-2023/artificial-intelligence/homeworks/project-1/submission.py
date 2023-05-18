import csv
from queue import PriorityQueue


class CityNotFoundError(Exception):
    def __init__(self, city):
        print("%s does not exist" % city)


# Implement this function to read data into an appropriate data structure.
def build_graph(path):
    pass


# Implement this function to perform uniform cost search on the graph.
def uniform_cost_search(graph, start, end):
    pass


# Implement main to call functions with appropriate try-except blocks
if __name__ == "__main__":
    pass
