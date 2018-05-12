package animal.memory;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.plaf.FontUIResource;




public class JogoMult extends JFrame {
    int points = 0;
    int pointsP1 = 0;
    int pointsP2 = 0;
    
    boolean vez = true;
    
    public static Card carta1 = new Card(0);
    public static Card carta2 = new Card(0);

    private boolean podeClicar = true;
    Color niagara = new Color(42, 187, 155);
    Color salem = new Color(30, 130, 76);
    
    JLabel p1 = new JLabel(" 1º Jogador: 0pt");
    JLabel p2 = new JLabel(" 2º Jogador: 0pt");
    JLabel lblVez = new JLabel(" Vez do 1ºJogador");
    
    List<Integer> numeros = new ArrayList();
    
    ArrayList<Card> cartas = new ArrayList();
    
    MusicPlayer player = new MusicPlayer();
    
    JFrame tela;
    
    
    private SwingWorker worker;


    public JogoMult() {
        
        tela = this;
        
        //Evento ao fechar
        
        tela.addWindowListener(new WindowAdapter() {
            
            @Override
            public void windowClosing(WindowEvent e){
                
                MenuPrincipal.jogoMultIsActive = false;
                
                
                
            }
        
        });
        
        //Fim evento ao fechar
        
        
        
        
        this.setLayout(null);
        this.setTitle("Jogo da memoria");
        this.setSize(800, 600);
        this.getContentPane().setBackground(salem);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        //Label Playres;
        p1.setForeground(Color.BLUE);
        p1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        p1.setOpaque(true);
        p1.setBackground(niagara);
        p1.setBounds(100, 0, 250, 40);

        p2.setForeground(Color.RED);
        p2.setOpaque(true);
        p2.setBackground(niagara);
        p2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        p2.setBounds(440, 0, 250, 40);
        
        lblVez.setForeground(Color.BLUE);
        lblVez.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        lblVez.setBackground(niagara);
        lblVez.setOpaque(true);
        lblVez.setBounds(290, 525, 210, 30);
        

        this.add(p1);
        this.add(p2);
        this.add(lblVez);
        
        
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
        
    }
// ==== FIM DO METODO CONSTRUTOR =====
    
      
    
    
//Funcoes
        
    //Comparador de cartas
private void compara(){
    worker = new SwingWorker(){


           @Override
           protected Void doInBackground() throws Exception {
               System.out.println("Carta1: "+carta1.getCode()+"\nCarta2: "+carta2.getCode());
               
               Thread.sleep(1000);
               
               if((carta1.getCode()) == (carta2.getCode()) && (!carta1.equals(carta2))){
                   
                   points ++;
                   carta1.setVisible(false);
                   carta2.setVisible(false);
                   if(vez){
                       pointsP1 ++;
                       p1.setText(" 1º Jogador: "+pointsP1+"pt");
                   }else{
                       pointsP2 ++;
                       p2.setText(" 2º Jogador: "+pointsP2+"pt");
                   }
               
               }else{
           
                   carta1.viraPraTras();
                   carta2.viraPraTras();
                   
                   vez = !vez;
               
               }
               
               carta1 = new Card(0);
               carta2 = new Card(0);
               
               if(vez){
                   lblVez.setText(" Vez do 1ºJogador");
                   lblVez.setForeground(Color.BLUE);
               }else{
                   lblVez.setText(" Vez do 2ºJogador");
                   lblVez.setForeground(Color.RED);
               }
               
               podeClicar = true;
               if(points >= 14){
                   

                   
                   
                   
                   //JOptionPane.showMessageDialog(null, "Você Ganhou!");
                   pontuacao(pointsP1,pointsP2);
                   
                   MenuPrincipal.jogoMultIsActive = false;
                   tela.dispose();
               }
               
               return null;
           }

    };
    worker.execute();

    }

// Varifica pontuação do jogador

    private void pontuacao(int p1, int p2){
        UIManager.getDefaults().put("OptionPane.background", niagara);
        if(p1 > p2){
            UIManager.put("OptionPane.messageForeground", Color.BLUE);
            JOptionPane.showMessageDialog(null, "1º Jogador GANHOU!");
        }else{
            UIManager.put("OptionPane.messageForeground", Color.RED);
            JOptionPane.showMessageDialog(null, "2º Jogador GANHOU!");
        }
        
    }

        
}
        
      
      
    




