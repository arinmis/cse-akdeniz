import csv
import os
import sys
from queue import PriorityQueue


class CityNotFoundError(Exception):
    def __init__(self, city):
        print("%s does not exist" % city)


# Implement this function to read data into an appropriate data structure.
def build_graph(path):
    if not os.path.exists(path):
        raise FileNotFoundError("given file not found: {0}" .format(path))
    # build graph as adjacency list, store as weighted undirected graph
    graph = {}
    with open(path, 'r') as csvfile:
        reader = csv.reader(csvfile)
        next(reader) # skip first row
        for row in reader:
            # graph is undirected
            new_node_1 = [row[1], int(row[2])]
            new_node_2 = [row[0], int(row[2])]
            if not row[0] in graph:
                graph[row[0]] = [new_node_1] 
            else: 
                graph[row[0]].append(new_node_1)

            if not row[1] in graph:
                graph[row[1]] = [new_node_2] 
            else: 
                graph[row[1]].append(new_node_2)

    return graph


def uniform_cost_search(graph, start, end):
    # check start and end is the same
    if start == end:
        return format_path([(start, end)]), 0 
    # Create a priority queue to store nodes and their cumulative costs
    priority_queue = PriorityQueue()
    
    # Create a dictionary to store the cumulative costs of visited nodes
    cumulative_costs = {start: 0}
    
    # Create a dictionary to store the path from the start node to each node
    paths = {start: []}
    
    # Add the start node to the priority queue
    priority_queue.put((0, start))  # (cumulative cost, node)
    
    while not priority_queue.empty():
        # Pop the node with the minimum cumulative cost from the priority queue
        cumulative_cost, current_node = priority_queue.get()
        
        # Check if the current node is the goal node
        if current_node == end:
            # Return the path and the total cost from the start node to the goal node
            return paths[current_node], cumulative_cost
        
        # Iterate through the neighbors of the current node
        for neighbor, edge_cost in graph[current_node]:
            # Calculate the new cumulative cost to reach the neighbor node
            new_cost = cumulative_cost + edge_cost
            
            # Check if the neighbor node has not been visited or the new cost is lower
            if neighbor not in cumulative_costs or new_cost < cumulative_costs[neighbor]:
                # Update the cumulative cost of the neighbor node
                cumulative_costs[neighbor] = new_cost
                
                # Create a new path from the start node to the neighbor node
                new_path = paths[current_node] + [(current_node, neighbor)]
                
                # Update the path to the neighbor node
                paths[neighbor] = new_path
                
                # Add the neighbor node to the priority queue with the new cumulative cost
                priority_queue.put((new_cost, neighbor))
    
    # If there is no path from the start node to the goal node, return None
    return None, 0


# format road with arrow
def format_path(path):
    result = ""
    for i in range(len(path)):
        result += str(path[i]) + " -> "
    return result + str(path[-1])

# Implement main to call functions with appropriate try-except blocks
if __name__ == "__main__":

    # build the graph from csv
    try:
        road_map_path = input("Enter road map file path: ").strip()
        graph = build_graph(road_map_path)
        print(graph)
    except Exception as e:
        print("file not found:", road_map_path)
        sys.exit()

    # read start and end city and find shortest path
    try: 
        start = input("Enter starting city: ").strip()
        end = input("Enter ending city: ").strip()

        if not start in graph:
            raise CityNotFoundError(start)
        if not end in graph:
            raise CityNotFoundError(end)

        path, cost = uniform_cost_search(graph, start, end)

        # print the result   
        print()
        print('Path:', format_path(path))
        print('Cost:', cost)
    except Exception as e:
        print(e)

        


