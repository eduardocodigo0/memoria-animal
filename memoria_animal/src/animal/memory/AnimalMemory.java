//author: Eduardo Cavalcanti Batista da Silva

package animal.memory;

import java.io.File;
import java.io.IOException;
import javax.swing.SwingUtilities;

public class AnimalMemory {
    
    public static long dificuldade = 120;
    public static MusicPlayer default_player;
    
    public static void main(String[] args) {
 
         //Arquivo rank criador
         try{
            File rank = new File("src/Recordes/rank.txt");
            if(!(rank.exists())){
                 rank.createNewFile();
            }
            
         }catch(IOException e){}
               
            
        SwingUtilities.invokeLater(new Runnable(){
        
            public void run(){
            
                MenuPrincipal menu = new MenuPrincipal();
                menu.setLocationRelativeTo(null);
                menu.setVisible(true);
       
                MusicPlayer player = new MusicPlayer();
               
                
                
                ///Animal Memory/src/Som
                player.setMusica("/src/Som/acousticbreeze.wav");
                
                player.playMusicLoop();
                default_player = player;
                
                
            }
    });
       
    }
}
