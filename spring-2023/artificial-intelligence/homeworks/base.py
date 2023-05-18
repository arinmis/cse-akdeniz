import plotly.express as px
from random import randint

# Do not modify the line below.
countries = ["Argentina", "Bolivia", "Brazil", "Chile", "Colombia", "Ecuador", "Falkland Islands", "Guyana", "Paraguay", "Peru", "Suriname", "Uruguay", "Venezuela"]

# Do not modify the line below.
colors = ["blue", "green", "red", "yellow"]


# Write your code here
neighbours_list = [
    ["Argentina", ["Bolivia", "Brazil", "Chile", "Paraguay", "Uruguay"]],
    ["Bolivia", ["Argentina", "Brazil", "Chile", "Paraguay", "Peru"]],
    ["Brazil", ["Argentina", "Bolivia", "Colombia", "Guyana", "Paraguay", "Peru", "Suriname", "Uruguay", "Venezuela"]],
    ["Chile", ["Argentina", "Bolivia", "Peru"]],
    ["Colombia", ["Brazil", "Ecuador", "Peru", "Venezuela"]],
    ["Ecuador", ["Colombia", "Peru"]],
    ["Falkland Islands",  []],
    ["Guyana", ["Brazil", "Suriname", "Venezuela"]],
    ["Paraguay", ["Argentina", "Bolivia", "Brazil"]],
    ["Peru", ["Bolivia", "Brazil", "Chile", "Colombia", "Ecuador"]],
    ["Suriname", ["Brazil", "Guyana"]],
    ["Uruguay", ["Argentina", "Brazil"]],
    ["Venezuela", ["Brazil", "Colombia", "Guyana"]]
]

# validate color choice 
def is_valid_color(country, color_map, neighbours):
    for neighbour in neighbours:
        if neighbour in color_map and color_map[country] == color_map[neighbour]:
            return False
    return True

# create valid color map out of neighbour list  
def find_color_map(color_map, i, neighbours_list, colors, all_maps): 
    # base case: all countries has a color 
    if len(color_map) == len(neighbours_list):
        all_maps.append(color_map)
    else:
        country =  neighbours_list[i][0]
        neighbours =  neighbours_list[i][1]
        for color in colors:
            # make a decision: assign colour to a country
            color_map[country] = color
            # validate decision, and keep going  for search
            if is_valid_color(country, color_map, neighbours):
                find_color_map(color_map.copy(), i + 1, neighbours_list, colors, all_maps)       
            del color_map[country] # undo choice


# Do not modify this method, only call it with an appropriate argument.
# colormap should be a dictionary having countries as keys and colors as values.
def plot_choropleth(colormap):
    fig = px.choropleth(locationmode="country names",
                        locations=countries,
                        color=countries,
                        color_discrete_sequence=[colormap[c] for c in countries],
                        scope="south america")
    fig.show()


# Implement main to call necessary functions
if __name__ == "__main__":
    color_map = {}
    all_maps = []
    find_color_map(color_map, 0, neighbours_list,  colors, all_maps)

    """
    # coloring test
    # colormap_test = {"Argentina": "blue", "Bolivia": "red", "Brazil": "yellow", "Chile": "yellow", "Colombia": "red",
                     "Ecuador": "yellow", "Falkland Islands": "yellow", "Guyana": "red", "Paraguay": "green",
                     "Peru": "green", "Suriname": "green", "Uruguay": "red", "Venezuela": "green"}

    """
    selected_map = all_maps[randint(0, len(all_maps))]
    print(len(all_maps), "possible solution found")
    print("selected color map:\n", selected_map) 
    plot_choropleth(colormap=selected_map)
