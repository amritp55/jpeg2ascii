import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class main {
	static ArrayList<String> pixel = new ArrayList<String>();
	static String ascii = " .,:;irXAs253hMHGS#9B&@";
	 
	public static void main(String[] args) {
		prepAscii(ascii);
		System.out.println(pixel);
		System.out.println(pixel.get(5));

		try{
			File file1 = new File("C:\\lol.jpg");
			BufferedImage image1 = ImageIO.read(file1);
			double greyscale ;
			String character = null;
			
			FileWriter fstream = new FileWriter ("C:\\pixlog.txt");
			BufferedWriter out = new BufferedWriter(fstream);
			for (int j =0;j<image1.getHeight();j++){
				out.newLine();
				for (int k=0;k<image1.getWidth();k++){
					int rgb= image1.getRGB(k, j);
					
					Color color = new Color (rgb);
					greyscale = toGreyscale(color.getRed(),color.getGreen(),color.getBlue());
					out.write(greyscaleToString(greyscale));
				}
			}
		}catch (IOException e){
			e.printStackTrace();
		}

	}
	
	public static double toGreyscale(int r, int g, int b){
		double tot = r+g+b;
		return tot/3.0;
		
	}
	
	public static String greyscaleToString(double grey){
		int spot;
		spot = (int) Math.round(grey/11.59);
		if (spot == 22){
			spot = 21;
		}

		return pixel.get(21-spot);
	}
	
	public static void prepAscii(String a){
		for (int i = 1; i <a.length();i++){
			pixel.add(a.substring(i-1, i));
		}
	}
}
