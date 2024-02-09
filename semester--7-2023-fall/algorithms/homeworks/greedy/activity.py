def select_activities(activites):
    selecteds = [activites[0]]
    for i in range(1, len(activites)):
        if activites[i][0] >= selecteds[-1][1]:
            selecteds.append(activites[i])
    return selecteds

S = [(1, 3), (5, 7), (2, 8), (3, 11), (8, 15), (13, 18)]
print(S)
print(select_activities(S))

