package projekt7;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class Okno extends JFrame implements ActionListener
{   
	private static final long serialVersionUID = 1L;
	
	
JTextField a00,a11,b00,b11,b22,c11,c22,d11,d22,ampl,czest,czassym,kroksym;
	JButton button;
	JLabel aa0,aa1,bb0,bb1,bb2,cc1,cc2,dd1,dd2,trans,sygnal,bledy,amplituda,czestotliwosc,czass,kroks,lead,lag,wyb;
	double a0,a1,b0,b1,b2,c1,c2,d1,d2,wyp,krok,amp,czas,czesto;
	private ButtonGroup bg,bg2;
	private JRadioButton harm,kwad,troj;
        private JRadioButton sym,ld,lg,tran;
	int rodzajsygnalu=0,rodzajsterownika=0;
	

	
public Okno()
{setSize(600,500);
setLocation(200,50);
setTitle("Projekt 7");
setLayout(null);
setResizable(false);

button = new JButton("Przeprowadź symulacje");  
add(button);
button.setBounds(350, 400,190, 30);	
button.addActionListener(this);

////////////////////////////////////////////////// Labele

trans=new JLabel(" G(s)=(LEAD*LAG*TRANSMITANCJA/1+LEAD*LAG*TRANSMITANCJA)");
trans.setBounds(100, 20, 700, 30);	
add(trans);

lead=new JLabel("LEAD");
lead.setBounds(390,50,100,30);
add(lead);

lag=new JLabel("LAG");
lag.setBounds(490,50,100,30);
add(lag);

aa0=new JLabel("a0=");
aa0.setBounds(60, 80, 100, 30);	
add(aa0);

aa1=new JLabel("a1=");
aa1.setBounds(60, 110, 100, 30);	
add(aa1);

bb0=new JLabel("b0=");
bb0.setBounds(160, 80, 100, 30);	
add(bb0);

bb1=new JLabel("b1=");
bb1.setBounds(160, 110, 100, 30);	
add(bb1);

bb2=new JLabel("b2=");
bb2.setBounds(260, 80, 100, 30);	
add(bb2);


cc1=new JLabel("c1=");
cc1.setBounds(360, 80, 100, 30);	
add(cc1);

cc2=new JLabel("c2=");
cc2.setBounds(360, 110, 100, 30);	
add(cc2);

dd1=new JLabel("d1=");
dd1.setBounds(460, 80, 100, 30);	
add(dd1);


dd2=new JLabel("d2=");
dd2.setBounds(460, 110, 100, 30);	
add(dd2);

sygnal=new JLabel("Sygnał: ");
sygnal.setBounds(60, 160, 100, 30);	
add(sygnal);

bledy=new JLabel("Błedy");
add(bledy);
bledy.setBounds(60,340,450, 30);	
bledy.setVisible(false);
bledy.setForeground(new java.awt.Color(255,0,0));

amplituda=new JLabel("Amplituda pobudzenia=");
amplituda.setBounds(60, 210, 150, 30);
add(amplituda);

czestotliwosc=new JLabel("Częstotliwość pobudzenia=");
czestotliwosc.setBounds(280, 210, 180, 30);
add(czestotliwosc);


czass=new JLabel("Czas Symulacji=");
czass.setBounds(60, 260, 100, 30);
add(czass);

kroks=new JLabel("Krok Symulacji=");
kroks.setBounds(280, 260, 100, 30);
add(kroks);

wyb=new JLabel("Wybór sterownika:");
wyb.setBounds(80,300,120,30);
add(wyb);


///////////////////////////////////// TextFieldy

a00=new JTextField("");
a00.setBounds(90, 80, 50, 30);	
add(a00);

a11=new JTextField("");
a11.setBounds(90, 110, 50, 30);	
add(a11);

b00=new JTextField("");
b00.setBounds(190, 80, 50, 30);	
add(b00);

b11=new JTextField("");
b11.setBounds(190, 110, 50, 30);	
add(b11);

b22=new JTextField("");
b22.setBounds(290, 80, 50, 30);	
add(b22);


c11=new JTextField("");
c11.setBounds(390, 80, 50, 30);	
add(c11);
c11.setToolTipText("c1 musi być większe od c2");

c22=new JTextField("");
c22.setBounds(390, 110, 50, 30);	
add(c22);
c22.setToolTipText("c2 musi być mniejsze od c1");

d11=new JTextField("");
d11.setBounds(490, 80, 50, 30);	
add(d11);

d22=new JTextField("");
d22.setBounds(490, 110, 50, 30);	
add(d22);

ampl=new JTextField("");
ampl.setBounds(200, 210, 50, 30);	
add(ampl);
ampl.setToolTipText("Amplituda musi być większa od 0");

czest=new JTextField("");
czest.setBounds(440, 210, 50, 30);	
add(czest);
czest.setToolTipText("Częstotliwość musi być większa od 0");

czassym=new JTextField("");
czassym.setBounds(160, 260, 50, 30);	
add(czassym);
czassym.setToolTipText("Czas musi być większy od 0");

kroksym=new JTextField("");
kroksym.setBounds(380, 260, 50, 30);	
add(kroksym);
kroksym.setToolTipText("Krok musi być większy od 0");



//////////////////////////////////// Rodzaj sygnału // Radio Button
bg=new ButtonGroup();

kwad= new JRadioButton("Prostokątny",true);
kwad.setBounds(160, 160, 100, 30);
bg.add(kwad);
add(kwad);
kwad.addActionListener(this);

harm= new JRadioButton("Harmoniczny");
harm.setBounds(280,160,100,30);
bg.add(harm);
add(harm);
harm.addActionListener(this);

troj= new JRadioButton("Trójkątny");
troj.setBounds(400,160,100,30);
bg.add(troj);
add(troj);
troj.addActionListener(this);

bg2=new ButtonGroup();

sym= new JRadioButton("Lead + Lag",true);
sym.setBounds(100,320,100,30);
bg2.add(sym);
add(sym);
sym.addActionListener(this);

ld= new JRadioButton("Lead");
ld.setBounds(200,320,60,30);
bg2.add(ld);
add(ld);
ld.addActionListener(this);

lg= new JRadioButton("Lag");
lg.setBounds(280,320,60,30);
bg2.add(lg);
add(lg);
lg.addActionListener(this);

tran= new JRadioButton("Transmitancja");
tran.setBounds(360,320,130,30);
bg2.add(tran);
add(tran);
tran.addActionListener(this);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Okno okno=new Okno();
okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
okno.setVisible(true);
	}
	
@Override
public void actionPerformed(ActionEvent e) 
{  
    Object zrodlo2=e.getSource();
if(zrodlo2==sym) rodzajsterownika=0;
if(zrodlo2==ld) rodzajsterownika=1;
if(zrodlo2==lg) rodzajsterownika=2;
if(zrodlo2==tran) rodzajsterownika=3;
    Object zrodlo=e.getSource();
if(zrodlo==kwad) rodzajsygnalu=0;
if(zrodlo==harm) rodzajsygnalu=1;
if(zrodlo==troj) rodzajsygnalu=2;

 if(zrodlo==button) 

	try {
		 bledy.setVisible(false);
	 a0=Double.parseDouble(a00.getText());
	 a1=Double.parseDouble(a11.getText());
	 b0=Double.parseDouble(b00.getText());
	 b1=Double.parseDouble(b11.getText());
	 b2=Double.parseDouble(b22.getText());
	 c1=Double.parseDouble(c11.getText());
	 c2=Double.parseDouble(c22.getText());
	 d1=Double.parseDouble(d11.getText());
         d2=Double.parseDouble(d22.getText());
	 amp=Double.parseDouble(ampl.getText());
	czesto=Double.parseDouble(czest.getText());
	 czas=Double.parseDouble(czassym.getText());
	 krok=Double.parseDouble(kroksym.getText());


	 
        
      if(rodzajsterownika==1){
          if(c1<c2 || czesto<0 || amp==0 || czas<0 || krok<0) 
	 {
		 bledy.setVisible(true);
		 bledy.setText("Nie prawidłowe dane (c1 musi być większe od c2)");}
	 
		 else{
				Obliczenia modul=new Obliczenia();
				modul.symulatorlead(a0,a1,b0,b1,b2,c1,c2,d1,d2,krok,amp,czas,czesto,rodzajsygnalu);
		 }

	}
      if(rodzajsterownika==2){
          if(d1>d2 || czesto<0 || amp==0 || czas<0 || krok<0) 
	 {
		 bledy.setVisible(true);
		 bledy.setText("Nie prawidłowe dane (d1 musi być mniejsze od d2)");}
	 
		 else{
				Obliczenia modul=new Obliczenia();
				modul.symulatorlag(a0,a1,b0,b1,b2,c1,c2,d1,d2,krok,amp,czas,czesto,rodzajsygnalu);
		 }

	}
      if(rodzajsterownika==3){
          if(czesto<0 || amp==0 || czas<0 || krok<0) 
	 {
		 bledy.setVisible(true);
		 bledy.setText("Nie prawidłowe dane");}
	 
		 else{
				Obliczenia modul=new Obliczenia();
				modul.symulatortrans(a0,a1,b0,b1,b2,c1,c2,d1,d2,krok,amp,czas,czesto,rodzajsygnalu);
		 }

	}
      if(rodzajsterownika==0){
	 if(c1<c2 || d1>d2 || czesto<0 || amp==0 || czas<0 || krok<0) 
	 {
		 bledy.setVisible(true);
		 bledy.setText("Nie prawidłowe dane (c1>c2 i d1<d2)");}
	 
		 else{
				Obliczenia modul=new Obliczenia();
				modul.symulator(a0,a1,b0,b1,b2,c1,c2,d1,d2,krok,amp,czas,czesto,rodzajsygnalu);
		 }

	}
        }
	 catch(NumberFormatException n) {
		 bledy.setVisible(true);
		bledy.setText("Uzupełnij lukę/luki wartością liczbową");}
}} 




