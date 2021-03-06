/* Ocean.java */

/**
 *  The Ocean class defines an object that models an ocean full of sharks and
 *  fish.  Descriptions of the methods you must implement appear below.  They
 *  include a constructor of the form
 *
 *      public Ocean(int i, int j, int starveTime);
 *
 *  that creates an empty ocean having width i and height j, in which sharks
 *  starve after starveTime timesteps.
 *
 *  See the README file accompanying this project for additional details.
 */

public class Ocean {

  /**
   *  Do not rename these constants.  WARNING:  if you change the numbers, you
   *  will need to recompile Test4.java.  Failure to do so will give you a very
   *  hard-to-find bug.
   */

  public final static int EMPTY = 0;
  public final static int SHARK = 1;
  public final static int FISH = 2;

  /**
   *  Define any variables associated with an Ocean object here.  These
   *  variables MUST be private.
   */
private int Height;
private int Width;
private int StarveTime;
private int[][] OceanGrid;

/**
 * This is a helper function for wrapping around.
 */
  
  public void Wrap(int x, int y) {
    x = x % Width;
    y = y % Height;
        }
  
  public int WrapWidth(int x) {
    if (x < 0) {
      x = Width + x%Width;
    } else {
      x = x % Width;
    }
    return x;
  }
  
  public int WrapHeight(int y) {
    if (y < 0) {
      y = Height + y%Height;
    } else {
      y = y % Height;
    }
    return y;
  }
  
  /**
   * This is a helper function for finding neighbors.
   */
  
  public int getAdjFish(int y, int x) {
    int numFish = 0;
    if (OceanGrid[WrapHeight(y+1)][WrapWidth(x-1)] == -1) {
      numFish++;}
    if (OceanGrid[WrapHeight(y+1)][WrapWidth(x)] == -1) {
      numFish++;}
    if (OceanGrid[WrapHeight(y+1)][WrapWidth(x+1)] == -1) {
      numFish++;}
    if (OceanGrid[WrapHeight(y)][WrapWidth(x-1)] == -1) {
      numFish++;}
 
    if (OceanGrid[WrapHeight(y)][WrapWidth(x+1)] == -1) {
      numFish++;}
    if (OceanGrid[WrapHeight(y-1)][WrapWidth(x-1)] == -1) {
      numFish++;}
    if (OceanGrid[WrapHeight(y-1)][WrapWidth(x)] == -1) {
      numFish++;}
    if (OceanGrid[WrapHeight(y-1)][WrapWidth(x+1)] == -1) {
      numFish++;}
    return numFish;
  }

  public int getAdjShark(int y, int x) {
    int numShark = 0;
    if (OceanGrid[WrapHeight(y+1)][WrapWidth(x-1)]  > 0 ) {
      numShark++;}
    if (OceanGrid[WrapHeight(y+1)][WrapWidth(x)] > 0) {
      numShark++;}
    if (OceanGrid[WrapHeight(y+1)][WrapWidth(x+1)] > 0) {
      numShark++;}
    if (OceanGrid[WrapHeight(y)][WrapWidth(x-1)] > 0) {
      numShark++;}

    if (OceanGrid[WrapHeight(y)][WrapWidth(x+1)] > 0) {
    numShark++;}
    if (OceanGrid[WrapHeight(y-1)][WrapWidth(x-1)] > 0) {
      numShark++;}
    if (OceanGrid[WrapHeight(y-1)][WrapWidth(x)] > 0) {
      numShark++;}
    if (OceanGrid[WrapHeight(y-1)][WrapWidth(x+1)] > 0) {
      numShark++;}
    return numShark;
  }

  /**
   *  The following methods are required for Part I.
   */

  /**
   *  Ocean() is a constructor that creates an empty ocean having width i and
   *  height j, in which sharks starve after starveTime timesteps.
   *  @param i is the width of the ocean.
   *  @param j is the height of the ocean.
   *  @param starveTime is the number of timesteps sharks survive without food.
   */

  public Ocean(int i, int j, int starveTime) {
    // Your solution here.
	  Width = i;
	  Height = j;
	  StarveTime = starveTime;
	  OceanGrid = new int[Height][Width];
  }

  /**
   *  width() returns the width of an Ocean object.
   *  @return the width of the ocean.
   */

  public int width() {
    // Replace the following line with your solution.
    return Width;
  }

  /**
   *  height() returns the height of an Ocean object.
   *  @return the height of the ocean.
   */

  public int height() {
    // Replace the following line with your solution.
    return Height;
  }

  /**
   *  starveTime() returns the number of timesteps sharks survive without food.
   *  @return the number of timesteps sharks survive without food.
   */

  public int starveTime() {
    // Replace the following line with your solution.
    return StarveTime;
  }

  /**
   *  addFish() places a fish in cell (x, y) if the cell is empty.  If the
   *  cell is already occupied, leave the cell as it is.
   *  @param x is the x-coordinate of the cell to place a fish in.
   *  @param y is the y-coordinate of the cell to place a fish in.
   */

  public void addFish(int x, int y) {
    // Your solution here.
	  if (OceanGrid[WrapHeight(y)][WrapWidth(x)] != 0) {
		  System.out.println("You could not add FISH! This cell is already occupied!");
	  } else {
		  OceanGrid[WrapHeight(y)][WrapWidth(x)] = -1;
	  }
  }

  /**
   *  addShark() (with two parameters) places a newborn shark in cell (x, y) if
   *  the cell is empty.  A "newborn" shark is equivalent to a shark that has
   *  just eaten.  If the cell is already occupied, leave the cell as it is.
   *  @param x is the x-coordinate of the cell to place a shark in.
   *  @param y is the y-coordinate of the cell to place a shark in.
   */

  public void addShark(int x, int y) {
    // Your solution here.
	  if (OceanGrid[WrapHeight(y)][WrapWidth(x)] != 0) {
		  System.out.println("You could not add SHARK! This cell is already occupied!");
	  } else {
		  OceanGrid[WrapHeight(y)][WrapWidth(x)] = 1;
	  }
  }

  /**
   *  cellContents() returns EMPTY if cell (x, y) is empty, FISH if it contains
   *  a fish, and SHARK if it contains a shark.
   *  @param x is the x-coordinate of the cell whose contents are queried.
   *  @param y is the y-coordinate of the cell whose contents are queried.
   */

  public int cellContents(int x, int y) {
    // Replace the following line with your solution.
    if (OceanGrid[WrapHeight(y)][WrapWidth(x)] == 0) {
      return EMPTY;
    } else {
      if (OceanGrid[WrapHeight(y)][WrapWidth(x)] == -1) {
	return FISH;
      } else {
	return SHARK;
      }
    }
  }
  

  /**
   *  timeStep() performs a simulation timestep as described in README.
   *  @return an ocean representing the elapse of one timestep.
   */

  public Ocean timeStep() {
    // Replace the following line with your solution.
	
    int[][] copyOcean = new int[Height][Width];
    for (int m = 0; m < Width; m++) {
    for (int n = 0; n < Height ; n++) {
		copyOcean[n][m] = OceanGrid[n][m];
      }
    }
	Ocean newOcean = new Ocean(Width, Height, StarveTime); 
	newOcean.OceanGrid = copyOcean;
    // System.out.println("copyOcean done!");
    
    for (int i = 0; i < Width; i++){
		for (int j = 0; j < Height; j++) {
			if (OceanGrid[WrapHeight(j)][WrapWidth(i)]  > 0) {
				if (getAdjFish(WrapHeight(j), WrapWidth(i)) > 0) {
					newOcean.OceanGrid[WrapHeight(j)][WrapWidth(i)] = StarveTime + 2;
				}
				if (getAdjFish(WrapHeight(j), WrapWidth(i)) == 0) {
					if (OceanGrid[WrapHeight(j)][WrapWidth(i)]  ==  2) {
						newOcean.OceanGrid[WrapHeight(j)][WrapWidth(i)] = 0;
					} else if (getAdjFish(WrapHeight(j), WrapWidth(i)) == 0) {
							newOcean.OceanGrid[WrapHeight(j)][WrapWidth(i)]--;
					} 
				} 
			}
			else if (OceanGrid[WrapHeight(j)][WrapWidth(i)]  == -1) {
				if (getAdjShark(WrapHeight(j), WrapWidth(i)) == 1) {
					newOcean.OceanGrid[WrapHeight(j)][WrapWidth(i)] = 0;
				}

				if (OceanGrid[WrapHeight(j)][WrapWidth(i)]  == -1 && getAdjShark(WrapHeight(j), WrapWidth(i)) > 1) {
					newOcean.OceanGrid[WrapHeight(j)][WrapWidth(i)] = StarveTime + 2;
				} 
				else {
						if (OceanGrid[WrapHeight(j)][WrapWidth(i)]  == 0) {
							if (getAdjFish(WrapHeight(j), WrapWidth(i)) > 1) {
								if (getAdjShark(WrapHeight(j), WrapWidth(i)) < 2) {
									newOcean.OceanGrid[WrapHeight(j)][WrapWidth(i)] = -1;
								} 
							}

							if (getAdjFish(WrapHeight(j), WrapWidth(i)) > 1) {
								if (getAdjShark(WrapHeight(j), WrapWidth(i)) > 1) {
								newOcean.OceanGrid[WrapHeight(j)][WrapWidth(i)] = StarveTime + 2;
							}
						} 
					}		
				} 
			}	
		} 	
	}
    return newOcean;
  }

  /**
   *  The following method is required for Part II.
   */

  /**
   *  addShark() (with three parameters) places a shark in cell (x, y) if the
   *  cell is empty.  The shark's hunger is represented by the third parameter.
   *  If the cell is already occupied, leave the cell as it is.  You will need
   *  this method to help convert run-length encodings to Oceans.
   *  @param x is the x-coordinate of the cell to place a shark in.
   *  @param y is the y-coordinate of the cell to place a shark in.
   *  @param feeding is an integer that indicates the shark's hunger.  You may
   *         encode it any way you want; for instance, "feeding" may be the
   *         last timestep the shark was fed, or the amount of time that has
   *         passed since the shark was last fed, or the amount of time left
   *         before the shark will starve.  It's up to you, but be consistent.
   */

  public void addShark(int x, int y, int feeding) {
    // Your solution here.
	  if (OceanGrid[WrapHeight(y)][WrapWidth(x)] != 0) {
		  System.out.println("You could not add SHARK! This cell is already occupied!");
	  } else {
		  OceanGrid[WrapHeight(y)][WrapWidth(x)] = 1 + feeding;
	  }
  }
  
  /**
   *  The following method is required for Part III.
   */

  /**
   *  sharkFeeding() returns an integer that indicates the hunger of the shark
   *  in cell (x, y), using the same "feeding" representation as the parameter
   *  to addShark() described above.  If cell (x, y) does not contain a shark,
   *  then its return value is undefined--that is, anything you want.
   *  Normally, this method should not be called if cell (x, y) does not
   *  contain a shark.  You will need this method to help convert Oceans to
   *  run-length encodings.
   *  @param x is the x-coordinate of the cell whose contents are queried.
   *  @param y is the y-coordinate of the cell whose contents are queried.
   */

  public int sharkFeeding(int x, int y) {
    // Replace the following line with your solution.
	  if (OceanGrid[WrapHeight(y)][WrapWidth(x)] < 1) {
		  System.out.println("This cell dose not contain a SHARK!!");
	  }
	  return OceanGrid[WrapHeight(y)][WrapWidth(x)];
  }
  
}
