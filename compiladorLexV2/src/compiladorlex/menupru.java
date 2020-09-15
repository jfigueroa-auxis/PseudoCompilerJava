package compiladorlex;

import Interpreter.Compilador;
import Interpreter.Token;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.List;

public class menupru extends JFrame implements ActionListener {
    private MenuBar menuBar;
    private Menu menuArc;
    private Menu menuEdi;
    private Menu menuAna;
    private Menu menuEje;
    private MenuItem menuArcAbr;
    private MenuItem menuArcSal;
    private MenuItem menuEdiCop;
    private MenuItem menuEdiCor;
    private MenuItem menuEdiPeg;
    private MenuItem menuEdiSel;
    private MenuItem menuAnaCom;
    private MenuItem menuEjeCor;
    
    private JPanel status;
    private JPanel panelpp;
	
    private JLabel statusMsg1;
    private JLabel statusMsg2;
    
    private JScrollPane parea1;
    private JScrollPane parea2;
    
    private JTextArea area1;
    private JTextArea area2;
    
    private JFileChooser chooser;
    private File selFile;
    
    private String[][] simbolos;
    private String[] var;
    private int [] tipo;
    private String [][] valor;
    private char [] oprd;
    private int contd;
    private int contt;
    private boolean valid;
    
    boolean essalvar = true;
    String nombre="simbolosPrograma.dat";
    String rutaArchivoFuente="D:\\capturaIngresoProg.dat";
    public static int cantidadpalabrasr=0;
    		
    public menupru() {
      setSize(new Dimension(1024, 768));
      getContentPane().setLayout(new BorderLayout());
      setBackground(Color.black);
      //Barra de menu
      menuBar = new MenuBar();
        
      //Menu Archivos
       menuArc = new Menu();
       menuArcSal = new MenuItem();
       menuArcAbr = new MenuItem();
       menuArc.setLabel("Archivo");
       menuArcAbr.setLabel("Abrir");
       menuArcSal.setLabel("Salir");
       menuArcSal.addActionListener(this);
       menuArcAbr.addActionListener(this);
       menuArc.add(menuArcAbr);
       menuArc.add(menuArcSal);
       menuArc.insertSeparator(2);
        
       //menu Editor
       menuEdi = new Menu();
       menuEdiCop = new MenuItem();
       menuEdiCor = new MenuItem();
       menuEdiPeg = new MenuItem();
       menuEdiSel = new MenuItem();
       menuEdi.setLabel("Editar");
       menuEdiCop.setLabel("Copiar");
       menuEdiCor.setLabel("Cortar");
       menuEdiPeg.setLabel("Pegar");
       menuEdiSel.setLabel("Seleccionar Todo");
       menuEdiCop.addActionListener(this);
       menuEdiCor.addActionListener(this);
       menuEdiPeg.addActionListener(this);
       menuEdiSel.addActionListener(this);
       menuEdi.add(menuEdiCop);
       menuEdi.add(menuEdiCor);
       menuEdi.add(menuEdiPeg);
       menuEdi.add(menuEdiSel);
       
       //menu Analizar
       menuAna = new Menu();
       menuAnaCom = new MenuItem();
       menuAna.setLabel("Analizar");
       menuAnaCom.setLabel("Revizar");
       menuAnaCom.addActionListener(this);
       menuAna.add(menuAnaCom);
       
       //menu Ejecutar
       menuEje = new Menu();
       menuEjeCor = new MenuItem();
       menuEje.setLabel("Ejecutar");
       menuEjeCor.setLabel("Correr");
       menuEjeCor.addActionListener(this);
       menuEje.add(menuEjeCor);
       
       //Agregar los elementos creados
       menuBar.add(menuArc);
       menuBar.add(menuEdi);
       menuBar.add(menuAna);
       menuBar.add(menuEje);
       
       //Panel de control
       status = new JPanel();
       status.setLayout(new BorderLayout());
       statusMsg1 = new JLabel("Estado: ");
       statusMsg2 = new JLabel();
       status.add(statusMsg1, BorderLayout.WEST);
       status.add(statusMsg2, BorderLayout.CENTER);
       getContentPane().add(status, BorderLayout.SOUTH);
		
       //Creacion area de textos
       area1 = new JTextArea();
       area2 = new JTextArea();
       area2.setEditable(false);
        
       //Creacion de las barras Scroll
       parea1 = new JScrollPane(area1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
       parea2 = new JScrollPane(area2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
       //Panel de pricipal
       panelpp = new JPanel();
       panelpp.setLayout(new GridLayout(1,1));        
       panelpp.add(parea1);
       panelpp.add(parea2);
        
       getContentPane().add(panelpp, BorderLayout.CENTER);
       
       setTitle("Editor Pre - Compilador");
       setMenuBar(menuBar);        
       setVisible(true);       
       
       addWindowListener(new WindowAdapter() {
	 public void WindowClosing(WindowEvent e) {
	   System.exit(0);
	 }
        });
       }
	
       public void actionPerformed(ActionEvent e) {
	 if(e.getSource()==menuArcAbr) {
           cargarDatos();    
         }		 			 	
	 if(e.getSource()==menuArcSal) {
           dispose();        
         }
	 if(e.getSource()==menuEdiCop) {
           area1.copy();     
         }
	 if(e.getSource()==menuEdiCor) {
           area1.cut();      
         }
	 if(e.getSource()==menuEdiPeg) {
           area1.paste();    
         }
	 if(e.getSource()==menuEdiSel) {
           area1.selectAll();
         }
	 if(e.getSource()==menuAnaCom) {
  	   statusMsg2.setText("Analizando");
	   analizar();
	   statusMsg2.setText("Analizado");
	   essalvar = false;
	 }
	 if(e.getSource()==menuEjeCor){
           ejecutar();    
         } 
      }
	
      public void cargarDatos() {
	chooser = new JFileChooser();
	int sel = chooser.showOpenDialog(area1);
	if (sel == chooser.APPROVE_OPTION) {
	   selFile = chooser.getSelectedFile();
  	   statusMsg2.setText("abriendo " + selFile.getAbsolutePath());
           rutaArchivoFuente = selFile.getAbsolutePath();
  	   String linea;
	   try {
	      FileReader fr = new FileReader(selFile.getAbsolutePath());
	      BufferedReader entArch = new BufferedReader(fr);
	      linea = entArch.readLine();
	      area1.setText("");
	      area2.setText("");
	      while (linea != null) {
	        area1.setText(area1.getText() + linea + "\n");
	        linea = entArch.readLine();
	      }
	      entArch.close ();
	   } catch (IOException e){}
	 }
      }
	
      public void analizar() {
        Compilador prog = new Compilador();
        List<Token> tokens = prog.tokenizar(area1.getText());
        prog.validar(tokens);
      }
      
      public void ejecutar() {
        Compilador prog = new Compilador();
        List<Token> tokens = prog.tokenizar(area1.getText());
        String resultado = prog.ejecutar(tokens);
        area2.setText(resultado); 
      }	

      public static void main (String [] args) {
        new menupru();   
    }
}
