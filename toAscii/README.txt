How it works:
-Converts RGB -> Greyscale
-Using obtained greyscale value, appropriate letter if found and written to a text file

Kinks to work out:
-Needs a UI where user can choose file location
-RGB to greyscale conversion works by taking average of the 3 values. Would like to use weighted mean formula, found on wikipedia.
-Right now each pixel is converted to greyscale, and each pixel is given a character. This becomes a problem with large pictures, 
as you would need to zoom out alot to see the picture. Solution would be to take a block of pixels and represent it with a single character. 
(Bigger the block -> more detail lost in ascii picture) 


Developed by:
Amrit Parmar
a5parmar@uwaterloo.ca
 