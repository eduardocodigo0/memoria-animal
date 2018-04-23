//author: Eduardo Cavalcanti Batista da Silva

package animal.memory;

import javax.swing.SwingUtilities;

public class AnimalMemory {
    
    public static long dificuldade = 120;
    
    public static void main(String[] args) {
 
        
        SwingUtilities.invokeLater(new Runnable(){
        
            public void run(){
            
                MenuPrincipal menu = new MenuPrincipal();
                menu.setLocationRelativeTo(null);
                menu.setVisible(true);
       
                MusicPlayer player = new MusicPlayer();
                ///Animal Memory/src/Som
                player.setMusica("/src/Som/acousticbreeze.wav");
                player.playMusicLoop();
            }
    });
       
    }
}
