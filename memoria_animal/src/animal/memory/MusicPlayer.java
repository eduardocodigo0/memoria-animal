/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal.memory;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.JOptionPane;

public class MusicPlayer {
    
    private String musica;
    //Colocando alguns atributos para evitar criação de multiplos objetos
    private File music;
    private DataLine.Info info;
    
    
    
    public void setMusica(String musica){
        this.musica = musica;
    }
    
    public String getMusica(){
        return this.musica;
    }
    
   
    public void playMusic(String sound){
        try{
            music = new File(System.getProperty("user.dir") +"/src/Som/"+sound);
            AudioInputStream stream = AudioSystem.getAudioInputStream(music);
            AudioFormat format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            Clip clip;
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            clip.start();
             
        
        }catch(Exception e){
            
            
        }
    
    }
    public void playMusicLoop(){
        try{
            music = new File(System.getProperty("user.dir") +musica);
            AudioInputStream stream = AudioSystem.getAudioInputStream(music);
            AudioFormat format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            Clip clip;
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
             
                
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro na reprodução de audio");
        }
    
    
    
    
    
    
}}
