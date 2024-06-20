import matplotlib.pyplot as plt
import math
import numpy as np


def plotRobotPositions(arrows):
    plt.xlim(-72, 72)
    plt.ylim(-72, 72)
    pic = plt.imread("src/main/python/centerstage.png")

    plt.imshow(pic, extent=[-72, 72, -72, 72])
    readLogFile("src/main/python/robotPosition.txt")
    if arrows:
        for i in range(len(xCoords)):
            plt.arrow(xCoords[i], yCoords[i], 5 * math.sin(headings[i]), 5 * math.cos(float(headings[i])), width=0.75)
    else:
        x = xCoords[:-1].copy()
        y = np.array(yCoords)[:-1].copy()
        plt.plot(x, y)
    plt.show()


def readLogFile(filename):
    global xCoords, yCoords, headings

    xCoords = []
    yCoords = []
    headings = []

    with open(filename, "r") as f:
        coords = f.readlines()
    for i in range(len(coords)):
        xCoords.append(float(coords[i].split(",")[0].split("\n")[0]))
        yCoords.append(float(coords[i].split(",")[1].split("\n")[0]))
        headings.append(float(coords[i].split(",")[2].split("\n")[0]))


if __name__ == "__main__":
    plotRobotPositions(False)
