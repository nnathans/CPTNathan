import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

// ----------------------------------------
// CPT Assignment - Guess The Word
// ICS3U1
// Nathan Wong
// 23 May 2025
//
// This program allows the user to play a game of guess the word
// The user can play the game, view leaderboards, add themes, or quit
// 
// ----------------------------------------

public class CPTNathan{
	public static void main(String[] args){
		Console con = new Console("Guess The Word", 1280, 720);
		
		// Logo
		BufferedImage logos = con.loadImage("guesswhat.png");
		
		// meme images
		BufferedImage gru = con.loadImage("gru.jpg");
		BufferedImage troll = con.loadImage("troll.jpg");
		
		// troll movement
		int intx;
		
		// Guess the Word ---------------------------------------
		
		String strmenu;
		
		// Line reading
		int intnum = 1;
		int intnum2 = 1;
		
		// Themes
		String strthemepick;
		String strthemehold;
		String strthemeread;
		int intlinenum = 0;
		int inttagnum = 0;
		
		// UI
		boolean boolquit = false;
		boolean boolthemeselect = true;
		boolean boolleaderboard = true;
		boolean booladdtheme = true;
		String strname;
		
		// for loops
		int intcount;
		String strword;
		
		// Sorting
		int intcount2;
		
		String strwordtemp;
		String strnumtemp;
		
		
		// Taking themes
		
		// intwords = # of words in the theme, intrand = random number from 1-100
		int intwords;
		int intrand;
		String strtheme[][];
		
		
		
		
		while(boolquit == false){
			
			// Menu 
			
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
				
				// System.out.println("ITTTTTTT WOOOOORRRRKKKKKKKSSSSSSSS");
				
				while(boolthemeselect == true){
					con.setDrawColor(Color.BLACK);
					con.fillRect(0,0,1280,720);
					
					// Opens the themes list
					TextInputFile themes = new TextInputFile("themes.txt");
					
					// strtheme = new String[intwords][intrand];
					
					con.setDrawColor(Color.WHITE);
					con.drawString("Type the theme you want to play.", 445, 100);
					con.drawString("(Type exactly how it's displayed)", 437, 125);
					con.drawString("Objects", 597, 150);
					con.drawString("Animals", 597, 170);
					con.drawString("Gems", 615, 190);
					con.drawString("No Repeating Letters", 516, 210);
					con.drawString("Rare Words", 578, 230);
					
					// reads the theme
					strthemepick = con.readLine();
					
					// puts the theme into a temp variable for later
					strthemehold = strthemepick;
					
					
					// This creates the array for the words
					
					while(themes.eof() == false){
						
						// Reads 1 line from themes.txt
						strthemeread = themes.readLine();
						intlinenum = intlinenum + intnum;
						inttagnum = inttagnum + intnum2;
						
						// When theme is found it will stop the count for line the theme is on
						if(strthemepick.equalsIgnoreCase(strthemeread)){
							intnum = 0;
						}
						
						// When tag is found it will stop the count for line the tag is on
						if(strthemepick == "asdhjewkudfsdfgweujwewhewifwe"){
							intnum2 = 0;
						}
						
						// Checks if the line it read matches what the theme the user added is
						if(strthemepick.equalsIgnoreCase(strthemeread)){
							// System.out.println("ITTTTTTT WOOOOORRRRKKKKKKKSSSSSSSS");
							// System.out.println(intlinenum);
							
							// When the theme is found, it will change to a #
							
							strthemepick = "#";
							
							if(strthemepick.equalsIgnoreCase(strthemeread)){
								// System.out.println(inttagnum);
								
								// theme pick changed to random letters so it wont activate again
								strthemepick = "asdhjewkudfsdfgweujwewhewifwe";
							}
						}
						
						// System.out.println(inttagnum);
						
					}
					
					// System.out.println(inttagnum);
					
					// creates the array after picking a theme
					strtheme = new String[(inttagnum - intlinenum) - 2][2];
					
					// closes and opens themes.txt as a new name to reset .eof();
					themes.close();
					
					TextInputFile theme = new TextInputFile("themes.txt");
					
					
					
					// This puts the words into the array
					
					while(theme.eof() == false){
						
						strthemeread = theme.readLine();
						
						if(strthemehold.equalsIgnoreCase(strthemeread)){
							for(intcount = 0; intcount <= (inttagnum - intlinenum) - 3; intcount++){
								if(!(strthemeread.equalsIgnoreCase("#"))){
									
									strthemeread = theme.readLine();
								
									System.out.println(strthemeread);
									System.out.println(intcount);
								
									intrand = (int) (Math.random()*100);
									
									System.out.println(intrand);
								
									strtheme[intcount][0] = strthemeread;
									strtheme[intcount][1] = intrand + "";
								}
							}
						}		
					}
					
					// This sorts the array
					
					// System.out.println("Before Sorting");
					// for(intcount = 0; intcount < (inttagnum - intlinenum) - 3; intcount++){
						// System.out.println(strtheme[intcount][0] + " - " + strtheme[intcount][1]);
					// }
					
					for(intcount2 = 0; intcount2 < ((inttagnum - intlinenum) - 3) - 1; intcount2++){
						for(intcount = 0; intcount < ((inttagnum - intlinenum) - 3) - 1; intcount++){
							if(Integer.parseInt(strtheme[intcount][1]) > Integer.parseInt(strtheme[intcount+1][1])){
							
								// word swap
								strwordtemp = strtheme[intcount][0];
								strtheme[intcount][0] = strtheme[intcount+1][0];
								strtheme[intcount+1][0] = strwordtemp;
							
								// number swap
								strnumtemp = strtheme[intcount][1];
								strtheme[intcount][1] = strtheme[intcount+1][1];
								strtheme[intcount+1][1] = strnumtemp;
							
							
							}
						}
					}
					
					// System.out.println("After Sorting");
					// for(intcount = 0; intcount < (inttagnum - intlinenum) - 3; intcount++){
						// System.out.println(strtheme[intcount][0] + " - " + strtheme[intcount][1]);
					// }
					
					
					
					con.repaint();
					con.sleep(30);
				}
				
				
			
			}else if(strmenu.equalsIgnoreCase("V")){
				
				// If V is selected, it will cover the menu
				
				// System.out.println("ITTTTTTT WOOOOORRRRKKKKKKKSSSSSSSS");
				
				while(boolleaderboard == true){
					con.setDrawColor(Color.BLACK);
					con.fillRect(0,0,1280,720);
					
					con.repaint();
					con.sleep(30);
				}
				
				
			
			}else if(strmenu.equalsIgnoreCase("A")){
				
				// If A is selected, it will cover the menu
				
				// System.out.println("ITTTTTTT WOOOOORRRRKKKKKKKSSSSSSSS");
				
				while(booladdtheme == true){
					con.setDrawColor(Color.BLACK);
					con.fillRect(0,0,1280,720);
					
					con.repaint();
					con.sleep(30);
				}
				
				
			
			}else if(strmenu.equalsIgnoreCase("S")){
				
				// If S is selected, it will put image of gru on screen with joke
				
				// System.out.println("ITTTTTTT WOOOOORRRRKKKKKKKSSSSSSSS");
				
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
					con.drawString("y ciken cras road, 2 get 2 te otter sid", 840, 140);
					
					con.repaint();
					con.sleep(30);
				}
				
			}else if(strmenu.equalsIgnoreCase("Q")){
				
				// If Q is selected, it will close the console
				
				// System.out.println("bro why.");
				
				System.exit(0);
				
			}
			
			con.repaint();
			con.sleep(30);
			
		}
	}
}
