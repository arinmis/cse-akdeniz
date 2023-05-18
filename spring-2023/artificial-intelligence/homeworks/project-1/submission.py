import csv
import os
from queue import PriorityQueue


class CityNotFoundError(Exception):
    def __init__(self, city):
        print("%s does not exist" % city)


# Implement this function to read data into an appropriate data structure.
def build_graph(path):
    graph = {}
    with open(path, 'r') as csvfile:
        reader = csv.reader(csvfile)
        next(reader) # skip first row
        for row in reader:
            graph[row[0]] = {row[1]: int(row[2])}
    return graph


# Implement this function to perform uniform cost search on the graph.
def uniform_cost_search(graph, start, end):
    pass


# Implement main to call functions with appropriate try-except blocks
if __name__ == "__main__":

    is_file_read = False
    while not is_file_read:  
        road_map_path = input("enter road map file path: ").strip()
        print("hrere", road_map_path)
        try:
           graph = build_graph(road_map_path)
           is_file_read = True
        except :
            print("file not found:", road_map_path)
    print("graph: ", graph)

    starting_city = input("Enter starting city: ")
    destination_city = input("Enter destination city: ")
    print("road map is loading...")
