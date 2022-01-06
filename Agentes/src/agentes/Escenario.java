/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agentes;
//escenario es la clase mas significativa
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;

/**
 *
 * @author macario
 */
public class Escenario extends JFrame
{
    
    private JLabel[][] tablero; //Matrices objetos de 2 dimensiones  
    private int[][] matrix; //Matrices de enteros 
    private final int dim = 15; //dimension de la Matriz, Es cuadrada para no tener limites diferentes 
//figuras del escenario 
    private ImageIcon robot1; 
    private ImageIcon robot2;
    private ImageIcon obstacleIcon;
    private ImageIcon sampleIcon; 
    private ImageIcon actualIcon; //Para que el usuario seleccione el icono actual
    private ImageIcon motherIcon; 
 
//Clases de tipo agente   
    private Agente wallE;
    private Agente eva;
   
    private final BackGroundPanel fondo = new BackGroundPanel(new ImageIcon("imagenes/surface.jpg"));
    
    private final JMenu settings = new JMenu("Settigs"); //Variable distancia "settings" se desabilita para que el usuario no agregue mas obstaculos
    private final JRadioButtonMenuItem obstacle = new JRadioButtonMenuItem("Obstacle"); //opciones del menu son RadioButton para que el usuario indique el objeto que quiere poner
    private final JRadioButtonMenuItem sample = new JRadioButtonMenuItem("Sample");
    private final JRadioButtonMenuItem motherShip = new JRadioButtonMenuItem("MotherShip");
    
    public Escenario()
    {
        this.setContentPane(fondo);
        this.setTitle("Agentes");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setBounds(50,50,dim*50+35,dim*50+85);
        initComponents();
    }
        
    private void initComponents()
    {
        ButtonGroup settingsOptions = new ButtonGroup(); //los Item de Menu tienen que agruparse 
        settingsOptions.add(sample);
        settingsOptions.add(obstacle);       
        settingsOptions.add(motherShip);
//Es comodo para seleccionar las opciones, bota, obstaculo, nave nodrisa
        JMenuBar barraMenus = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem run  = new JMenuItem("Run");
        
        JMenuItem exit   = new JMenuItem("Exit");
              
        this.setJMenuBar(barraMenus);
        barraMenus.add(file);
        barraMenus.add(settings);
        file.add(run);
        file.add(exit);
        settings.add(motherShip);
        settings.add(obstacle);
        settings.add(sample);
            
        robot1 = new ImageIcon("imagenes/wall-e.png"); //Se carga la imagen
        robot1 = new ImageIcon(robot1.getImage().getScaledInstance(50,50,  java.awt.Image.SCALE_SMOOTH)); //Se escala la imagen 
        
        robot2 = new ImageIcon("imagenes/eva.png");
        robot2 = new ImageIcon(robot2.getImage().getScaledInstance(50,50,  java.awt.Image.SCALE_SMOOTH));
        
        obstacleIcon = new ImageIcon("imagenes/bomb.png");
        obstacleIcon = new ImageIcon(obstacleIcon.getImage().getScaledInstance(50,50,  java.awt.Image.SCALE_SMOOTH));
        
        sampleIcon = new ImageIcon("imagenes/sample.png");
        sampleIcon = new ImageIcon(sampleIcon.getImage().getScaledInstance(50,50,  java.awt.Image.SCALE_SMOOTH));
        
        motherIcon = new ImageIcon("imagenes/mothership.png");
        motherIcon = new ImageIcon(motherIcon.getImage().getScaledInstance(50,50,  java.awt.Image.SCALE_SMOOTH));
        
        this.setLayout(null);
        formaPlano(); //Se coloca la rejilla 
        //Gestion de eventos para cada RadioButton
        exit.addActionListener(evt -> gestionaSalir(evt));
        run.addActionListener(evt -> gestionaRun(evt));
        obstacle.addItemListener(evt -> gestionaObstacle(evt));
        sample.addItemListener(evt -> gestionaSample(evt));
        motherShip.addItemListener(evt -> gestionaMotherShip(evt)); //cuando haga clik sobre la rejilla, aparece el icono correspondiente 

              
       //Despedida al cerrar la interfaz de Usuario     
        class MyWindowAdapter extends WindowAdapter
        {
            public void windowClosing(WindowEvent eventObject)
            {
		goodBye();
            }
        }
        addWindowListener(new MyWindowAdapter());
        
        // Crea 2 agentes los cuales tienen acceso a la misma matriz 
        //instancias "Agente"
        wallE = new Agente("Wall-E",robot1, matrix, tablero);  //nombre, imagen
        eva = new Agente("Eva",robot2, matrix, tablero); 
        
    }
        
    private void gestionaSalir(ActionEvent eventObject)
    {
        goodBye();
    }
        
    private void goodBye()
    {
        int respuesta = JOptionPane.showConfirmDialog(rootPane, "Desea salir?","Aviso",JOptionPane.YES_NO_OPTION);
        if(respuesta==JOptionPane.YES_OPTION) System.exit(0);
    }
  
    private void formaPlano()
    {
        tablero = new JLabel[dim][dim]; //Aqui se forma el tablero 
        matrix = new int[dim][dim]; //Se form la matriz
        
        int i, j;
        
        for(i=0;i<dim;i++) //Llenado de Matrices
            for(j=0;j<dim;j++)
            {
                matrix[i][j]=0; // la matriz de incio esta llena de 0´s
                tablero[i][j]=new JLabel();
                tablero[i][j].setBounds(j*50+10,i*50+10,50,50); //Se hace el calculo de la posicion con respecto a "i, j"
                tablero[i][j].setBorder(BorderFactory.createDashedBorder(Color.white)); //borde
                tablero[i][j].setOpaque(false);
                this.add(tablero[i][j]);//se agrega al tablero un Jlabel 
                
                tablero[i][j].addMouseListener(new MouseAdapter() // Este listener nos ayuda a agregar poner objetos en la rejilla
                    { //los listener tienen mas de un metodo se tiene qe hacer declarando una clase interna "MouseAdapter" -> tiene los metodos bacios
                        //adapter permite adaptar la funcion que va a tner addMouseListener
                        @Override
                        public void mousePressed(MouseEvent e) //Presionar el boton
                        {
                               insertaObjeto(e);
                        }   
                
                        @Override
                        public void mouseReleased(MouseEvent e) 
                        {
                                insertaObjeto(e);
                        }   
                
                    });
                                
            }
    }
        
    private void gestionaObstacle(ItemEvent eventObject) //Obstaculos
    {
        JRadioButtonMenuItem opt = (JRadioButtonMenuItem) eventObject.getSource();
        if(opt.isSelected())
           actualIcon = obstacleIcon;//indica que el icono 
        else actualIcon = null;        
    }
    
    private void gestionaSample(ItemEvent eventObject) //Botas
    {
        JRadioButtonMenuItem opt = (JRadioButtonMenuItem) eventObject.getSource();
        if(opt.isSelected())
           actualIcon = sampleIcon;
        else actualIcon = null;   
    }
    
    private void gestionaMotherShip(ItemEvent eventObject) //Nave
    {
        JRadioButtonMenuItem opt = (JRadioButtonMenuItem) eventObject.getSource();
        if(opt.isSelected())
           actualIcon = motherIcon;
        else actualIcon = null;   
    }
    private void gestionaRun(ActionEvent eventObject)
    {//con esta gestion arranca los 2 agentes
        if(!wallE.isAlive()) wallE.start(); //Si wallE isAlive = Corriendo -> entonces inicia
        if(!eva.isAlive()) eva.start();
        settings.setEnabled(false); //Es false para que no e puedan agregar mas obstaculos
    }  
    public void insertaObjeto(MouseEvent e) //MouseEvent e guarda una referencia la cual es el icono Actual
    {
        JLabel casilla = (JLabel) e.getSource();
        if(actualIcon!=null) casilla.setIcon(actualIcon); 
    }
}
