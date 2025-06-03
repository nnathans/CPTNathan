import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class CPTNathan{
	public static void main(String[] args){
		Console con = new Console("Guess The Word", 1280, 720);
		
		// Logo
		BufferedImage logos = con.loadImage("guesswhat.png");
		
		// meme images
		BufferedImage gru = con.loadImage("gru.jpg");
		BufferedImage troll = con.loadImage("troll.jpg");
		
		int intx = 1500;
		
		// Guess the Word
		
		String strmenu;
		boolean boolquit = false;
		boolean boolthemeselect = true;
		boolean boolleaderboard = true;
		boolean booladdtheme = true;
		String strname;
		
		while(boolquit == false){
			
			// Menu ########################
			
			// Fill Background
			con.setDrawColor(Color.BLACK);
			con.fillRect(0,0,1280,720);
			
			// Options
			con.setDrawColor(Color.WHITE);
			con.drawString("Press one of the following keys:", 445, 100);
			con.drawString("Press P to play", 545, 120);
			con.drawString("Press V to view leaderboards", 465, 140);
			con.drawString("Press A to add a theme", 495, 160);
			con.drawString("Press Q to quit game", 505, 180);
			
			con.drawImage(logos,495,400);
			
			// User Input
		
			strmenu = con.readLine();
			
			// First two loops to check if user entered a valid option
		
			if(strmenu.length() >= 2){
				con.println("Only type one character.");
			}else if(!(strmenu.equalsIgnoreCase("P") || strmenu.equalsIgnoreCase("V") || strmenu.equalsIgnoreCase("A")  || strmenu.equalsIgnoreCase("Q") || strmenu.equalsIgnoreCase("S"))){
				con.println("That is not an option.");
			}else if(strmenu.equalsIgnoreCase("P")){
				
				// If P is selected, it will cover the menu
				
				while(boolthemeselect == true){
					con.setDrawColor(Color.BLACK);
					con.fillRect(0,0,1280,720);
					
					con.repaint();
					con.sleep(30);
				}
				
				
			
			}else if(strmenu.equalsIgnoreCase("V")){
				
				// If V is selected, it will cover the menu
				
				while(boolleaderboard == true){
					con.setDrawColor(Color.BLACK);
					con.fillRect(0,0,1280,720);
					
					con.repaint();
					con.sleep(30);
				}
				
				
			
			}else if(strmenu.equalsIgnoreCase("A")){
				
				// If A is selected, it will cover the menu
				
				while(booladdtheme == true){
					con.setDrawColor(Color.BLACK);
					con.fillRect(0,0,1280,720);
					
					con.repaint();
					con.sleep(30);
				}
				
				
			
			}else if(strmenu.equalsIgnoreCase("S")){
				
				// If S is selected, it will put image of gru on screen with joke
				
				intx = 1500;
				
				while(intx > 0){
					con.setDrawColor(Color.BLACK);
					con.fillRect(0,0,1280,720);
					
					con.drawImage(gru,0,0);
					con.drawImage(gru,730,370);
					con.drawImage(gru,350,185);
					
					con.drawImage(troll,intx,300);
					
					intx = intx - 3;
					
					con.setDrawColor(Color.WHITE);
					con.drawString("banana", 1000, 100);
					con.drawString("banana", 1004, 109);
					con.drawString("banana", 1013, 111);
					
					con.repaint();
					con.sleep(30);
				}
				
			}else if(strmenu.equalsIgnoreCase("Q")){
				
				// If Q is selected, it will close the console
				
				System.exit(0);
				
			}
			
			con.repaint();
			con.sleep(30);
			
		}
	}
}
