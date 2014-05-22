How to Use:
1.Press "..." button to navigate to a jpeg/png picture
2. Confirm and in the main UI press OK to build Acsii pic
3. Navigate to picture location on in Windows exploerer and a text file with the same name as the picture will be there


How it works:
-Converts RGB -> Greyscale
-Using obtained greyscale value, appropriate letter if found and written to a text file

Kinks to work out:
-Implement weighted mean method for better accuracy when Converting to greyscale
-Right now each pixel is converted to greyscale, and each pixel is given a character. This becomes a problem with HD pics
as you would need to zoom out alot to see the picture. Solution would be to take a block of pixels and represent it with a single character. 
(Bigger the block -> more detail lost in ascii picture) 
-When selecting file, all files currently appear. Needs to show only supported format files (jpeg, png) 


Developed by:
Amrit Parmar
a5parmar@uwaterloo.ca
 
