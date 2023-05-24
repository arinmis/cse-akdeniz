import cv2
import numpy as np
import matplotlib.pyplot as plt

image = cv2.imread('coins.jpg')
gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
plt.imshow(gray, cmap='gray');

# 1. make it blur
blur = cv2.GaussianBlur(gray, (11,11), 0)
plt.imshow(blur, cmap='gray')
plt.show()

# 2. apply edge detection
canny = cv2.Canny(blur, 30, 150, 3)
# plt.imshow(canny, cmap='gray')

# make edges clear
dilated = cv2.dilate(canny, (1,1), iterations = 2)
plt.imshow(dilated, cmap='gray')
plt.show()

# 3. Contour the coins
(cnt, heirarchy) = cv2.findContours(dilated.copy(), cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_NONE)
rgb = cv2.cvtColor(image, cv2.COLOR_BGR2RGB)
cv2.drawContours(rgb, cnt, -1, (255, 0,0), 2) #   

print('Coins in the image: ', len(cnt))
plt.imshow(rgb)
plt.show()
