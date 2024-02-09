# Method

1. Clear noises with Gaussian Blur
It is necessary to use  noise reduction improve image quality, enhance visual interpretation, enable accurate analysis. 

2. Detect edges with Canny edge detector 
With edge detection we will be able to identiy edges of coins. 

3. Contour the coins 
Before detecting coins curves should joining all the continuous points (along the boundary), and having same color or intensity. 

4. Recognizing coins:
These steps includes couple of other tecqniues to recognize the values of the coins, such as
    * feature extraction
    * size estimation,
    * pattern matching with known coin templates that provided in our dataset.

# Run test
```
python count_coin.py tests/coins.jpg
```

# Resource
[Youtube](https://www.youtube.com/watch?v=rRcwuQGDFOA)
