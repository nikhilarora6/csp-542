/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author NIK
 */
public class InputFile extends javax.swing.JFrame {
public String locate;
public String locateabs;
    /**
     * Creates new form InputFile
     */
    public InputFile() {
       
        initComponents();
        }
    
    public static  void short_path(int src1)
	{
		int p;
		int q;
		int r=0;
		int count;
		int min;
		int[] check = new int[50];
                
                
                for (p = 0; p < m; p++)
		{
			shortpath[p] = 99; //Initializing the Short Path Matrix to 99(Infiniti cost)
                       
                }
		for (p = 0; p < m; p++)
		{
			check[p] = 0;
			InputFile.shortDst[p] = inputcost[src1][p]; //Initializing the min cost Matrix
                     
                }
		count = 1;
		
		/*Logic to calculate the path and find the min cost from the Source Router*/
		while (count < m)
		{
			min = 99;
			for (q = 0; q < m; q++)
			{
			if (shortDst[q] < min && check[q] == 0)
			{
				min = shortDst[q];
				r = q;
			}
			}
			check[r] = 1;
			count++;
			for (q = 0; q < m; q++)
			{
			if ((shortDst[r] + inputcost[r][q] < shortDst[q]) && check[q] == 0)
			{
				shortDst[q] = shortDst[r] + inputcost[r][q];
				shortpath[q] = r;
			}
			}
		}
	}

    public static void connection_table(int src1)
	{
		
                short_path(src1);
               
                jTextArea1.append("\n\n");
                jTextArea1.append("Router " + src1 + " Connection Table");
                jTextArea1.append("\n");
		
                jTextArea1.append("\n");
                jTextArea1.append("Destination              Interface");
                jTextArea1.append("\n");
                jTextArea1.append("=================================");
                jTextArea1.append("\n\n");
                
		
		/*Logic to fill the print the nearest interface providing the shorest path*/
               
                for (int i = 0; i < m; i++)
		{
			if (i == src1)
			{
                            
                                jTextArea1.append("         "+ (i+1)+ "         -   ");
                                jTextArea1.append("     \n      ");
                                
			}
                        else{
                        if (shortpath[i] != 99)
				{
                                    
                                    jTextArea1.append("         "+ (i+1)+ "         " + (shortpath[i] + 1));
                                    jTextArea1.append("     \n      ");
                                    
				}
                        
                        else
                                {
                                    
                                    jTextArea1.append("         "+ (i+1)+ "         " + (i+1));
                                    jTextArea1.append("     \n      ");
                                    
				}
                        }
		}
	}
    
    public static void cost(int src1, int dest1)
	{
		int chk = 0;
		int value = dest1;
		int q = 1;
                //jTextArea1.setText("");
                jTextArea1.append("\n\n");
                jTextArea1.append("  The shortest path from source " + src + " to router " + dest + " is");
		
		InputFile.shortpathsd[0] = dest1;
               
		while (chk != 1)
		{
			for (int p = 0; p < m; p++)
			{
				if (p == value)
				{
					shortpathsd[q] = shortpath[p];
                                       
					value = shortpath[p];
					q++;
					if (value == 99)
					{
						chk = 1;
					}
					break;
				}
			}
		}
		for (int p = (q - 1); p >= 0; p--)
		{
                    
			if (shortpathsd[p] == 99)
			shortpathsd[p] = 0;                    
                        
                        jTextArea1.append(""+(shortpathsd[p] + 1));
                        //System.out.printf(" %d", shortpathsd[p] + 1);
			
                        if (p != 0)
			{
                            
                            jTextArea1.append("-------->");
				//System.out.print("------->");
			}
		}
                jTextArea1.append("\n");
                jTextArea1.append("\n");
                
                if(shortDst[dest1]>=99)
                {
                JOptionPane.showMessageDialog(null , "No connection exists!");
                }
                else{
                jTextArea1.append(" the total cost is " +shortDst[dest1]);
                }
	}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        text1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        sourceText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        desti = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));
        setFocusableWindowState(false);

        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        text1.setEditable(false);
        text1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text1ActionPerformed(evt);
            }
        });

        jLabel1.setText("File Name:");

        jButton2.setText("Upload");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Select Topology File(topology.txt):");

        jTextArea1.setBackground(new java.awt.Color(204, 204, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        jLabel3.setText("Build a connection table:");

        jButton3.setText("Build");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setText("Find Shortest Path To Destination Router:");

        jButton4.setText("Find");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Exit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Clear");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel5.setText("Source Router Provided By User");

        sourceText.setEditable(false);

        jLabel6.setText("Shortest Path to Destination Router with cost");

        desti.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(70, 70, 70))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(sourceText)
                            .addComponent(desti))))
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jButton3))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sourceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4)
                    .addComponent(jLabel4))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(desti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(159, 159, 159))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(356, 356, 356)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(text1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
 
        JFileChooser chooser = new JFileChooser();      //for getting input file through GUI
        int option = chooser.showSaveDialog(null);
                 if (option == JFileChooser.APPROVE_OPTION) {                  
                           locate = chooser.getSelectedFile().getPath();
                           locateabs=chooser.getSelectedFile().getAbsolutePath();
                           text1.setText(locate);
                            file=new File(locate);
                            
                            
                             }

                 if (option == JFileChooser.CANCEL_OPTION) {
                      JOptionPane.showMessageDialog(null,"task cancelled");// task cancelled by user
                            

                 }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void text1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                int i;
		int j;
                try{
                fileread=new FileReader(locateabs);
                    BufferedReader br=new BufferedReader(fileread);
                    jTextArea1.read(br, null);
                    br.close();
                    jTextArea1.requestFocus();
                    JOptionPane.showMessageDialog(null, "file uploaded successfully");//successfully uploaded
                
                /*catch(Exception E)
                {
                    JOptionPane.showMessageDialog(null, "please provide input file");
                }*/
                
                Scanner sc = new Scanner(file);
		Scanner sc1= new Scanner(file);
               co=0;
		while (sc.hasNextLine()) {
		co++;  
		str=sc.nextLine();
		
                }
		sc.close();
                InputFile.m=co;
               
		
                
                for (i = 0; i < m; i++)
		{
			for (j = 0; j < m; j++)
			{
                            
                                InputFile.ch=sc1.nextInt();
                                         
                                 if(ch == -1)                                
                                     InputFile.ch = 99;
                                 
                                                    InputFile.inputcost[i][j] = ch;
                                                                  
                        }}
                 sc1.close();
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, "please provide correct input file");//error if file contents are not acceptible
                
                
                }
               

// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
       
        src= Integer.parseInt(JOptionPane.showInputDialog(null, "please provide source router no:"));
        sourceText.setText("" +src);
        if (src <= m )
				
        {
	if(src==0)
        {
        JOptionPane.showMessageDialog(null, "please provide correct router");
        }
                                       
                                        InputFile.connection_table(src-1);
                                        
				}
				else
				{
		                 jTextArea1.setText("This Router number does not exist. Please try again!");
                                 JOptionPane.showMessageDialog(null, "please provide correct input ");
                                 sourceText.setText("");
                                 src=0;
                                }
    
    
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
dest= Integer.parseInt(JOptionPane.showInputDialog(null, "please provide destination router no:"));    
desti.setText("" +dest);
if(src==0)
{
JOptionPane.showMessageDialog(null, "please provide source router above");
}
else{
jTextArea1.append("\n  Selected Destination Router is " + dest);
                           
				InputFile.short_path(src - 1);
				InputFile.cost(src - 1, dest - 1);
        
}   
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    JOptionPane.showMessageDialog(null, "Exit Project! Good Bye");
        System.exit(0);
        
// TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
jTextArea1.setText("");
text1.setText("");// TODO add your handling code here:
desti.setText("");
sourceText.setText("");
locateabs="";
locate="";

    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(InputFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InputFile().setVisible(true);
            }
        });
    }
public File file;
public FileReader fileread;
public String build;
public int co=0;
public static int[][] inputcost = new int[50][50];
	public static int m;
	public static int n;
	public static int src = 0;
	public static int dest = 0;
	//public static int[][] connectionTable = new int[3][20];
	public static int[] shortDst = new int[50];
	public static int[] shortpath = new int[50];
	public static int[] shortpathsd = new int[50];
	public static int ch = 0;
        public String str="";
        
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField desti;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField sourceText;
    private javax.swing.JTextField text1;
    // End of variables declaration//GEN-END:variables
}
