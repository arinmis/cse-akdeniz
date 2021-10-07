import pandas as pd
import matplotlib.pyplot as plt

# read data
times = pd.read_csv('times.csv', index_col=0)

# plot data
for i in range(3):
    plt.plot(times.iloc[i, :], '--', label=times.index[i]);
plt.title('String Concatenation')
plt.xlabel('Number of Input')
plt.ylabel('Concatenation Time in Millisecond')
plt.legend()
plt.margins(x=2, y=0)
plt.show()


