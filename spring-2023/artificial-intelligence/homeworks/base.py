import plotly.express as px

# Do not modify the line below.
countries = ["Argentina", "Bolivia", "Brazil", "Chile", "Colombia", "Ecuador", "Falkland Islands", "Guyana", "Paraguay", "Peru", "Suriname", "Uruguay", "Venezuela"]

# Do not modify the line below.
colors = ["blue", "green", "red", "yellow"]


# Write your code here
neighbours_list = [
    ["Argentina", ["Bolivia", "Brazil", "Chile", "Paraguay", "Uruguay"]],
    ["Bolivia", ["Argentina", "Brazil", "Chile", "Paraguay", "Peru"]],
    ["Brazil", ["Argentina", "Bolivia", "Colombia", "Guyana", "Paraguay", "Peru", "Suriname", "Uruguay", "Venezuela"]],
    ["Chile", ["Argentina", "Bolivia"]],
    ["Colombia", ["Bolivia", "Brazil", "Ecuador", "Peru"]],
    ["Ecuador", ["Brazil", "Colombia", "Peru"]],
    ["Falkland Islands", []],
    ["Guyana", ["Brazil", "Suriname", "Venezuela"]],
    ["Paraguay", ["Argentina", "Bolivia", "Brazil"]],
    ["Peru", ["Argentina", "Bolivia", "Brazil", "Colombia", "Ecuador"]],
    ["Suriname", ["Guyana", "Brazil"]],
    ["Uruguay", ["Argentina", "Brazil"]],
    ["Venezuela", ["Brazil", "Guyana"]]
]

# create valid colour map out of neighbour list  
def find_color_map(neighbours_list, i, colour_map, colors): 
    if i == len(neigbours_list):
        return colour_map
    




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


    # coloring test
    colormap_test = {"Argentina": "blue", "Bolivia": "red", "Brazil": "yellow", "Chile": "yellow", "Colombia": "red",
                     "Ecuador": "yellow", "Falkland Islands": "yellow", "Guyana": "red", "Paraguay": "green",
                     "Peru": "green", "Suriname": "green", "Uruguay": "red", "Venezuela": "green"}

    plot_choropleth(colormap=colormap_test)

