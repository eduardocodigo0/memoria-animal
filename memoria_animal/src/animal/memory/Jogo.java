package animal.memory;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;




public class Jogo extends JFrame {
    
    public static long tempo;
    private long tempo_conta;
    
    int points = 0;
    public static Card carta1 = new Card(0);
    public static Card carta2 = new Card(0);

    private boolean podeClicar = true;
    Color niagara = new Color(42, 187, 155);
    Color salem = new Color(30, 130, 76);

    JLabel lbltemp1 = new JLabel("Tempo: ");
    JLabel lbltemp2 = new JLabel("000");

    List<Integer> numeros = new ArrayList();
    
    ArrayList<Card> cartas = new ArrayList();
    
    MusicPlayer player = new MusicPlayer();
    
    JFrame tela;
    
    
    private SwingWorker worker;


    public Jogo() {
        
        tela = this;
        
        //Evento ao fechar
        
        tela.addWindowListener(new WindowAdapter() {
            
            @Override
            public void windowClosing(WindowEvent e){
                
                MenuPrincipal.jogoIsActive = false;
                cronometro.stop();
                
                
            }
        
        });
        
        //Fim evento ao fechar
        
        
        tempo = AnimalMemory.dificuldade;
        tempo_conta = tempo;
        
        this.setLayout(null);
        this.setTitle("Jogo da memoria");
        this.setSize(800, 600);
        this.getContentPane().setBackground(salem);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        //Label Tempo;
        lbltemp1.setForeground(Color.WHITE);
        lbltemp1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        lbltemp1.setBounds(330, 10, 100, 20);

        lbltemp2.setForeground(Color.WHITE);
        lbltemp2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        lbltemp2.setBounds(400, 10, 100, 20);
        lbltemp2.setText(tempo+"sec");

        this.add(lbltemp1);
        this.add(lbltemp2);
        
        
        //Cor para JOptionPane
        UIManager.getDefaults().put("OptionPane.background", salem);
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("SANS_SERIF",Font.PLAIN,35)));
        UIManager.put("OptionPane.messageForeground", Color.WHITE);
        UIManager.put ("Panel.background", salem);
        
       
        
        int i = 0;
        
        //Geração de posição aleatoria.
        for(i = 0; i < 14; i++){
            numeros.add(i+1);   
        }
        for(i = 0; i < 14; i++){
            numeros.add(i+1);   
        }
        Collections.shuffle(numeros);
        

        //Coloca as cartas no vetor, Adiciona imagem do animal e Adiciona o evento do click
        
        for (int numero : numeros) {
            
            cartas.add(new Card(numero));
           
        }


        for (Card carta : cartas) {
            carta.setImagem(new ImageIcon(System.getProperty("user.dir") + "/src/Imagem/gameIMG/" + carta.getCode() + ".jpg"));
            
        }
        for(Card card : cartas){
            card.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if(podeClicar){
                    player.playMusic("EfeitoVirar.wav");
                    card.viraPraFrente();

                    if(carta1.getCode() == 0){
                        carta1 = card;
                    }else{
                        carta2 = card;
                        podeClicar = false;
                        if(carta2.getMostrandoFoto()){
                            
                            //verificador(carta1, carta2); 
                            
                            compara();
                            
                            //Fim do teste
                           
                            
                        }
                    }
                }
                }
                        
            });
        }
              
    //Coloca cartas na tela

        int j = 50;

        i = 1;
        for (Card carta : cartas) {
               
            carta.setBounds(i * 90, j, 71, 107);
            this.add(carta);
         
            i++;

            if ((i >= 8)) {
                j += 117;
                i = 1;
            }
        }
       SwingWorker worker2 = new SwingWorker(){
            @Override
            protected Object doInBackground() throws Exception {
                    
                    cronometro.start();
                    
                    return null;
                   
                } 
            };worker2.run();
        
    }
// ==== FIM DO METODO CONSTRUTOR =====
    
    
//Cronometro

Thread cronometro = new Thread(new Runnable(){
        public void run() {
               
            try {
                while(tempo > 0){
                        
                    Thread.sleep(1000);
                    tempo --; 
                    lbltemp2.setText(tempo+"sec");
                       
                }
                     
                JOptionPane.showMessageDialog(null, "Você perdeu! :(");
                MenuPrincipal.jogoIsActive = false;
                tela.dispose();
                    
            }catch (InterruptedException ex) {
                Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }

});    
    
    
//Funcoes
        
    //Comparador de cartas
private void compara(){
    worker = new SwingWorker(){


           @Override
           protected Void doInBackground() throws Exception {
               System.out.println("Carta1: "+carta1.getCode()+"\nCarta2: "+carta2.getCode());
               
               Thread.sleep(1500);
               
               if((carta1.getCode()) == (carta2.getCode()) && (!carta1.equals(carta2))){
                   
                   points ++;
                   carta1.setVisible(false);
                   carta2.setVisible(false);
               
               }else{
           
                   carta1.viraPraTras();
                   carta2.viraPraTras();
               
               }
               
               carta1 = new Card(0);
               carta2 = new Card(0);
               
               podeClicar = true;
               if(points >= 14){
                   
                   cronometro.stop();
                   
                   int sec = (int)(tempo_conta - tempo);
                   
                   JOptionPane.showMessageDialog(null, "Você Ganhou!");
                   pontuacao(sec);
                   
                   MenuPrincipal.jogoIsActive = false;
                   tela.dispose();
               }
               
               return null;
           }

    };
    worker.execute();

    }

// Varifica pontuação do jogador

    private void pontuacao(int sec){
        
        String[] dados_rank = {"","",""};
        try {
            //Abre arquivo para leitura
            FileReader arquivo = new FileReader("src/Recordes/rank.txt");
            BufferedReader leitor = new BufferedReader(arquivo);
            
            //Itera arquivo e coloca dados no vetor
            try {
                String linha = null;
                
                int i = 0;
                while((linha = leitor.readLine()) != null){
                    dados_rank[i] = linha;
                    i++;
                }
                
                arquivo.close();
                leitor.close();
            } catch (IOException ex) {}
        }catch (FileNotFoundException ex) {}
        
        //Coloca dados de cada jogador em um vetor
        
        String primeiro = dados_rank[0];
        String segundo = dados_rank[1];
        String terceiro = dados_rank[2];
        
        String[] p_dados = primeiro.split(" ");
        String[] s_dados = segundo.split(" ");
        String[] t_dados = terceiro.split(" ");
        
        
        if(sec < Integer.valueOf(p_dados[2])){
            terceiro = segundo;
            segundo = primeiro;
            primeiro = "1 "+JOptionPane.showInputDialog("Coloque seu nome")+" "+String.valueOf(sec);
        }else if(sec < Integer.valueOf(s_dados[2])){
            terceiro = segundo;
            segundo = "2 "+JOptionPane.showInputDialog("Coloque seu nome")+" "+ String.valueOf(sec);
        }else if(sec < Integer.valueOf(t_dados[2])){
            terceiro = "3 "+JOptionPane.showInputDialog("Coloque seu nome")+" "+ String.valueOf(sec);
        }
        
        //Escrevendo mudanças no arquivo Rank.txt
        
        
        try {
            File rank = new File("src/Recordes/rank.txt");
            BufferedWriter escritor = new BufferedWriter(new FileWriter(rank));
            escritor.write(primeiro);
            escritor.newLine();
            escritor.write(segundo);
            escritor.newLine();
            escritor.write(terceiro);
            escritor.flush();
            escritor.close();
  
        } catch (IOException ex) {
        }
        
    }

        
}
        
      
      
    




