/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal.memory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cod23
 */
public class Recordes extends javax.swing.JFrame {

    /**
     * Creates new form Recordes
     */
    public Recordes() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_primeiro = new javax.swing.JLabel();
        lbl_segundo = new javax.swing.JLabel();
        lbl_terceiro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(30, 130, 76));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 177, 106));
        jLabel1.setFont(new java.awt.Font("SansSerif", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("   Recordes");
        jLabel1.setToolTipText("");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel1.setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(0, 177, 106));

        lbl_primeiro.setBackground(new java.awt.Color(30, 130, 76));
        lbl_primeiro.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_primeiro.setForeground(new java.awt.Color(255, 255, 255));
        lbl_primeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/primeiro.png"))); // NOI18N
        lbl_primeiro.setText(" . . .          ");
        lbl_primeiro.setName("lbl_primeiro"); // NOI18N
        lbl_primeiro.setOpaque(true);

        lbl_segundo.setBackground(new java.awt.Color(30, 130, 76));
        lbl_segundo.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_segundo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_segundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/segundo.png"))); // NOI18N
        lbl_segundo.setText(" . . .          ");
        lbl_segundo.setOpaque(true);

        lbl_terceiro.setBackground(new java.awt.Color(30, 130, 76));
        lbl_terceiro.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_terceiro.setForeground(new java.awt.Color(255, 255, 255));
        lbl_terceiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/terceiro.png"))); // NOI18N
        lbl_terceiro.setText(" . . .          ");
        lbl_terceiro.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 71, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_terceiro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                    .addComponent(lbl_segundo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_primeiro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(lbl_primeiro)
                .addGap(38, 38, 38)
                .addComponent(lbl_segundo)
                .addGap(38, 38, 38)
                .addComponent(lbl_terceiro)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        lbl_primeiro.getAccessibleContext().setAccessibleName("lbl_primeiro");
        lbl_segundo.getAccessibleContext().setAccessibleName("lbl_segundo");
        lbl_terceiro.getAccessibleContext().setAccessibleName("lbl_terceiro");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        MenuPrincipal.recordeIsActive = false;
    }//GEN-LAST:event_formWindowClosed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
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
            } catch (IOException ex) {}
            
       
        }catch (FileNotFoundException ex) {}
        
        String[] dados1 = dados_rank[0].split(" ");
        lbl_primeiro.setText(dados1[1] + "   TEMPO: "+ dados1[2]+" sec");
        
        String[] dados2 = dados_rank[1].split(" ");
        lbl_segundo.setText(dados2[1] + "   TEMPO: "+ dados2[2]+" sec");
        
        String[] dados3 = dados_rank[2].split(" ");
        lbl_terceiro.setText(dados3[1] + "   TEMPO: "+ dados3[2]+" sec");
        
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Recordes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Recordes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Recordes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Recordes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Recordes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_primeiro;
    private javax.swing.JLabel lbl_segundo;
    private javax.swing.JLabel lbl_terceiro;
    // End of variables declaration//GEN-END:variables
}
