package carro;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 *
 * @author USER
 */
public class Applic extends JFrame{
    
    public Applic(){
    add(new Maina());
    }

    public class Maina extends JPanel {
    JButton Detener=new JButton("Detener");
    JButton Continuar=new JButton("Continuar");
    Carro carro=new Carro();

        public Maina() {
        
        JPanel panel = new JPanel();
        panel.add(Detener);
        panel.add(Continuar);
        
        carro.setBorder(new javax.swing.border.LineBorder(Color.BLUE));
        setLayout(new BorderLayout());
        add(panel,BorderLayout.SOUTH);
        add(carro,BorderLayout.CENTER);
        
        Detener.addActionListener(new Carro());
        Continuar.addActionListener(new Carro());
        
      
        }
    public class Carro extends JPanel implements ActionListener,KeyListener {
    private int x,y,v;
    private int dx,dy,dv;
    private Timer timer;
    
    public Carro(){
        this.x=20;
        this.y=20;
        this.setFocusable(true);
        this.addKeyListener(this);
        this.timer=new Timer(20,this);
        this.timer.start();
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(this.x, this.y, 15,15);
        g.fillOval(this.x+60, this.y, 15,15);
        g.setColor(Color.BLACK);
        g.fillRect(this.x-10, this.y-10, 100, 10);
        g.setColor(Color.BLUE);
        Polygon poligono=new Polygon();
        poligono.addPoint(this.x+10, this.y-10);
        poligono.addPoint(this.x+20, this.y-20);
        poligono.addPoint(this.x+60, this.y-20);
        poligono.addPoint(this.x+70, this.y-10);
        g.fillPolygon(poligono);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Detener)
            carro.Detener();
        else if(e.getSource()==Continuar)
            carro.Continuar();
        else{
        this.y=20;
        this.x+=dv;
        
        if(this.x>1000)
           this.x=20;
        else if(this.x<0)
           this.x=880;
        repaint();
        } 
       
    }
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("me oprimieron"); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void keyPressed(KeyEvent e) {
        
         switch(e.getKeyCode()){
            case KeyEvent.VK_DOWN:
                 dv+= -10;  
                 break;
            case KeyEvent.VK_UP:
                dv += 10;
                break;
            
           
          } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        switch(e.getKeyCode()){
        
            case KeyEvent.VK_SPACE:
                timer.stop();
                break;
            case KeyEvent.VK_ENTER:
                timer.start();
                break;
          
                
            }
        }
    public void Detener(){
        timer.stop();
    }
    public void Continuar(){
        timer.start();
    }
    
    }
    }
  
     
    
    public static void main(String[] args) {
      JOptionPane.showMessageDialog(null, "Oprime Space para detener \n Oprime Enter para continuar");
   
        JFrame frame=new Applic();
        frame.setSize(new Dimension(250,250));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        }
}