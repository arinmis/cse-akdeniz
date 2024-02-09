"""
import pandas as pd
import mplfinance as mpf


# read required columns
columns_to_load = ["Date", "Open", "High", "Low", "Close", "Volume"]
df = pd.read_csv("./data/HDFCBANK.csv", usecols=columns_to_load) 
df['Date'] = pd.to_datetime(df['Date'])
df.set_index('Date', inplace=True)


# candle stick of a month
start_date = '2020-01-01'
end_date = '2020-01-31'
filtered_data = df.loc[start_date:end_date]
mpf.plot(filtered_data, type='candle', style='yahoo', volume=True)
"""


import yfinance as yf
import plotly.graph_objects as go

# Download data from Yahoo Finance
stock_df = yf.download("ISCR.IS", period="3mo", interval="5m")

# Create a candlestick chart
candlestick = go.Candlestick(x=stock_df.index,
                              open=stock_df['Open'],
                              high=stock_df['High'],
                              low=stock_df['Low'],
                              close=stock_df['Close'])

# Create a figure with the candlestick data
fig = go.Figure(data=[candlestick])

# Set the x-axis type to category
fig.layout.xaxis.type = 'category'

# Show the figure
fig.show()

