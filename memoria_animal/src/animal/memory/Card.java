package animal.memory;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Card extends JLabel{
    
    private Icon imagem;
    private int code;
    private final Icon capa =new ImageIcon(System.getProperty("user.dir")+"/src/Imagem/gameIMG/CardBack.png");
   private boolean mostrandoFoto = false;
    
    
//Getters e Setters
    public void setImagem(Icon imagem){ 
        this.imagem = imagem;
    }
    public Icon getImagem(){
        return this.imagem;
    }
    
    public void setCode(int code){
        this.code = code;
    }
    public int getCode(){
        return this.code;
    }
    public Icon getCapa(){
        return this.capa;
    }
    public boolean getMostrandoFoto(){
        return this.mostrandoFoto;
    }
    

//Construtor
    
public Card(){
    this.setText("");
    this.setIcon(capa);
   
}
public Card( int codigo){
    
    this.setCode(codigo);
    this.setText("");
    this.setIcon(capa);
    
}
//metodos 

public  void viraPraFrente(){
  
   this.setIcon(imagem);
   mostrandoFoto = true;
  
}

public void viraPraTras(){
    
    this.setIcon(capa);
    mostrandoFoto = false;
    
}



    
}
