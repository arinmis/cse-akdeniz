def createDeck(): 
    suits = ['c', 'd', 'h', 's']
    cards = []
    for suit in suits:
        for i in range(1, 14):
            cards.append(suit + str(i))
    return cards

# make 7 bit format
def format(binStr):
    binStr = binStr[2:]
    return getZeros(7 - len(binStr)) + binStr 

# create leading zeros
def getZeros(n):
    zeros = ''
    for i in range(n):
        zeros += "0"
    return zeros

deck = createDeck()
for i in range(len(deck)):
    print(deck[i]  + " -> " + format(bin(i)))

