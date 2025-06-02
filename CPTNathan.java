import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class CPTNathan{
	public static void main(String[] args){
		Console con = new Console("Guess The Word", 1280, 720);
		
		// Guess the Word
		
		String strmenu;
		boolean boolquit = false;
		
		
		BufferedImage logo = con.loadImage("logos.jpg");
		
		while(boolquit == false){
			
			con.setDrawColor(Color.WHITE);
			con.fillRect(0,0,1280,720);
			
			con.setDrawColor(new Color(255,0,0));
			con.drawString("Press one of the following keys:", 445, 100);
			con.drawString("Press P to play", 545, 120);
			con.drawString("Press V to view leaderboards", 465, 140);
			con.drawString("Press A to add a theme", 495, 160);
			con.drawString("Press Q to quit game", 505, 180);
			
			con.drawImage(logo, 495, 400);
		
			strmenu = con.readLine();
		
			if(strmenu.length() >= 2){
				con.println("Only type one character.");
			}else if(!(strmenu.equalsIgnoreCase("P") || strmenu.equalsIgnoreCase("V") || strmenu.equalsIgnoreCase("A")  || strmenu.equalsIgnoreCase("Q"))){
				con.println("That is not an option.");
			}else if(strmenu.equalsIgnoreCase("P")){
				TextInputFile themes = new TextInputFile("themes.txt");
			
				themes.close();
			}
			
			con.repaint();
			con.sleep(30);
			
		}
	}
}
