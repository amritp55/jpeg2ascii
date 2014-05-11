import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class main extends JFrame {
  private JTextField filename = new JTextField(), dir = new JTextField();
  private JButton open = new JButton("..."), save = new JButton("Ok");
  static ArrayList<String> pixel = new ArrayList<String>();
  static String ascii = " .,:;irXAs253hMHGS#9B&@";

  public main() {
    JPanel p = new JPanel();
    open.addActionListener(new OpenL());
    p.add(open);
    save.addActionListener(new SaveL());
    p.add(save);
    Container cp = getContentPane();
    cp.add(p, BorderLayout.SOUTH);
    dir.setEditable(false);
    filename.setEditable(false);
    p = new JPanel();
    p.setLayout(new GridLayout(2, 1));
    p.add(filename);
    p.add(dir);
    cp.add(p, BorderLayout.NORTH);
  }

  class OpenL implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      JFileChooser c = new JFileChooser();
      // Demonstrate "Open" dialog:
      int rVal = c.showOpenDialog(main.this);
      if (rVal == JFileChooser.APPROVE_OPTION) {
        filename.setText(c.getSelectedFile().getName());
        dir.setText(c.getSelectedFile().getAbsolutePath());
      }
      if (rVal == JFileChooser.CANCEL_OPTION) {
        filename.setText("You pressed cancel");
        dir.setText("");
      }
    }
  }

  class SaveL implements ActionListener {
    public void actionPerformed(ActionEvent e) {
    	try{
    		File file1 = new File(dir.getText());
    		System.out.println(dir.getText());
    		returnPath(dir.getText());
    		BufferedImage image1 = ImageIO.read(file1);
    		double greyscale ;
    		String character = null;
    		
    		FileWriter fstream = new FileWriter (dir.getText().substring(0, dir.getText().length()-3)+"txt");
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
    	}catch (IOException e1){
    		e1.printStackTrace();
    	}

    }
  }

  public static void main(String[] args) {
    run(new main(), 250, 110);
	prepAscii(ascii);
	System.out.println(pixel);
	System.out.println(pixel.get(5));


  }

  public static void run(JFrame frame, int width, int height) {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(width, height);
    frame.setVisible(true);
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
	public static String returnPath(String path){
		System.out.println(path.substring(0, path.length()-3));
		return path;
	}
}