package projekt7;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;

import static java.lang.Math.*;


 
public class Obliczenia {

public void symulator(double a0,double a1,double b0,double b1,double b2,double c1,double c2,double d1,double d2,double krok,double amp,double czas,double czesto,int rodzajsygnalu)
{ double T;
double	dx1=0,dx2=0,dx3=0,dx4,x1=0,x2=0,x3=0,x4=0;
double u=0;
double zmienna;
	T=1/czesto;
XYSeries sym = new XYSeries("Odpowiedź");
XYSeries pobudz = new XYSeries("Pobudzenie");

for(double t=0;t<czas;t=t+krok)
{	if(rodzajsygnalu==0) if(t%T>=T/2) u=0; else u=amp;
if(rodzajsygnalu==1) u=amp*sin((2*PI/T)*t);
if(rodzajsygnalu==2) 
{
	int calkowita=(int)(t/T);
    zmienna = t-calkowita*T;
if(zmienna<T/2)
u=2*amp*zmienna*czesto; 
else  u=amp*(1-2*czesto*(zmienna-1/(2*czesto)));
}



dx1=(((-b2*c2-b2*d2-b1*c2*d2-a1*c1*d1)/(b2*c2*d2))*x1+x2+((a1*c1*d1)/(b2*c2*d2))*u)*krok;
dx2=(((-b0*c2*d2-b1*d2-b1*c2-b2)/(b2*c2*d2))*x1+x3+((a0*c1*d1+a1*c1+a0*d1)/(b2*c2*d2))*u)*krok;
dx3=(((-b0*c2-b0*d2-b1-a0*c1-a0*d1-a1)/(b2*c2*d2))*x1+x4+((a0*c1+a0*d1+a1)/(b2*c2*d2))*u)*krok;
dx4=(((-b0-a0)/(b2*c2*d2))*x1+(a0/(b2*c2*d2))*u)*krok;
x1=x1+dx1;
x2=x2+dx2;
x3=x3+dx3;
x4=x4+dx4; 

sym.add(t,x1);
pobudz.add(t,u);

}

XYSeriesCollection punktysym = new XYSeriesCollection();
punktysym.addSeries(sym);
punktysym.addSeries(pobudz);

JFreeChart symulacjasygnalu = ChartFactory.createXYLineChart(
"Odpowiedz na pobudzenie", // Title
"t", // x-axis Label
"Y", // y-axis Label
punktysym, // Dataset
PlotOrientation.VERTICAL, // Plot Orientation
true, // Show Legend
true, // Use tooltips
false // Configure chart to generate
);
ChartFrame symul = new ChartFrame("Odpowiedź układu", symulacjasygnalu); 
symul.pack(); 
symul.setVisible(true); 
symul.setBounds(0,0, 650, 550);	
}


public void symulatorlead(double a0,double a1,double b0,double b1,double b2,double c1,double c2,double d1,double d2,double krok,double amp,double czas,double czesto,int rodzajsygnalu)
{ double T;
double	dx1=0,dx2=0,dx3=0,x1=0,x2=0,x3=0;
double u=0;
double zmienna;
	T=1/czesto;
XYSeries sym = new XYSeries("Odpowiedź");
XYSeries pobudz = new XYSeries("Pobudzenie");

for(double t=0;t<czas;t=t+krok)
{	if(rodzajsygnalu==0) if(t%T>=T/2) u=0; else u=amp;
if(rodzajsygnalu==1) u=amp*sin((2*PI/T)*t);
if(rodzajsygnalu==2) 
{
	int calkowita=(int)(t/T);
    zmienna = t-calkowita*T;
if(zmienna<T/2)
u=2*amp*zmienna*czesto; 
else  u=amp*(1-2*czesto*(zmienna-1/(2*czesto)));
}



dx1=(((-b1*c2-b2-a0*c1)/(b2*c2))*x1+x2+((a1*c2)/(b2*c2))*u)*krok;
dx2=(((-b0*c2-b1-a0*c1-a1)/(b2*c2))*x1+x3+((a0*c1+a1)/(b2*c2))*u)*krok;
dx3=(((-b0-a0)/(b2*c2))*x1+((a0/(b2*c2))*u))*krok;
x1=x1+dx1;
x2=x2+dx2;
x3=x3+dx3;


sym.add(t,x1);
pobudz.add(t,u);

}

XYSeriesCollection punktysym = new XYSeriesCollection();
punktysym.addSeries(sym);
punktysym.addSeries(pobudz);

JFreeChart symulacjasygnalu = ChartFactory.createXYLineChart(
"Odpowiedz na pobudzenie", // Title
"t", // x-axis Label
"Y", // y-axis Label
punktysym, // Dataset
PlotOrientation.VERTICAL, // Plot Orientation
true, // Show Legend
true, // Use tooltips
false // Configure chart to generate
);
ChartFrame symul = new ChartFrame("Odpowiedź układu", symulacjasygnalu); 
symul.pack(); 
symul.setVisible(true); 
symul.setBounds(0,0, 650, 550);	
}



public void symulatorlag(double a0,double a1,double b0,double b1,double b2,double c1,double c2,double d1,double d2,double krok,double amp,double czas,double czesto,int rodzajsygnalu)
{ double T;
double	dx1=0,dx2=0,dx3=0,x1=0,x2=0,x3=0;
double u=0;
double zmienna;
	T=1/czesto;
XYSeries sym = new XYSeries("Odpowiedź");
XYSeries pobudz = new XYSeries("Pobudzenie");

for(double t=0;t<czas;t=t+krok)
{	if(rodzajsygnalu==0) if(t%T>=T/2) u=0; else u=amp;
if(rodzajsygnalu==1) u=amp*sin((2*PI/T)*t);
if(rodzajsygnalu==2) 
{
	int calkowita=(int)(t/T);
    zmienna = t-calkowita*T;
if(zmienna<T/2)
u=2*amp*zmienna*czesto; 
else  u=amp*(1-2*czesto*(zmienna-1/(2*czesto)));
}



dx1=(((-b1*d2-b2-a0*d1)/(b2*d2))*x1+x2+((a1*d2)/(b2*d2))*u)*krok;
dx2=(((-b0*d2-b1-a0*d1-a1)/(b2*d2))*x1+x3+((a0*d1+a1)/(b2*d2))*u)*krok;
dx3=(((-b0-a0)/(b2*d2))*x1+((a0/(b2*d2))*u))*krok;
x1=x1+dx1;
x2=x2+dx2;
x3=x3+dx3;


sym.add(t,x1);
pobudz.add(t,u);

}

XYSeriesCollection punktysym = new XYSeriesCollection();
punktysym.addSeries(sym);
punktysym.addSeries(pobudz);

JFreeChart symulacjasygnalu = ChartFactory.createXYLineChart(
"Odpowiedz na pobudzenie", // Title
"t", // x-axis Label
"Y", // y-axis Label
punktysym, // Dataset
PlotOrientation.VERTICAL, // Plot Orientation
true, // Show Legend
true, // Use tooltips
false // Configure chart to generate
);
ChartFrame symul = new ChartFrame("Odpowiedź układu", symulacjasygnalu); 
symul.pack(); 
symul.setVisible(true); 
symul.setBounds(0,0, 650, 550);	
}

public void symulatortrans(double a0,double a1,double b0,double b1,double b2,double c1,double c2,double d1,double d2,double krok,double amp,double czas,double czesto,int rodzajsygnalu)
{ double T;
double	dx1=0,dx2=0,dx3=0,x1=0,x2=0,x3=0;
double u=0;
double zmienna;
	T=1/czesto;
XYSeries sym = new XYSeries("Odpowiedź");
XYSeries pobudz = new XYSeries("Pobudzenie");

for(double t=0;t<czas;t=t+krok)
{	if(rodzajsygnalu==0) if(t%T>=T/2) u=0; else u=amp;
if(rodzajsygnalu==1) u=amp*sin((2*PI/T)*t);
if(rodzajsygnalu==2) 
{
	int calkowita=(int)(t/T);
    zmienna = t-calkowita*T;
if(zmienna<T/2)
u=2*amp*zmienna*czesto; 
else  u=amp*(1-2*czesto*(zmienna-1/(2*czesto)));
}



dx1=(((-b1-a1)/b2)*x1+x2+(a1/b2)*u)*krok;
dx2=(((-b0-a0)/b2)*x1+(a0/b2)*u)*krok;
x1=x1+dx1;
x2=x2+dx2;


sym.add(t,x1);
pobudz.add(t,u);

}

XYSeriesCollection punktysym = new XYSeriesCollection();
punktysym.addSeries(sym);
punktysym.addSeries(pobudz);

JFreeChart symulacjasygnalu = ChartFactory.createXYLineChart(
"Odpowiedz na pobudzenie", // Title
"t", // x-axis Label
"Y", // y-axis Label
punktysym, // Dataset
PlotOrientation.VERTICAL, // Plot Orientation
true, // Show Legend
true, // Use tooltips
false // Configure chart to generate
);
ChartFrame symul = new ChartFrame("Odpowiedź układu", symulacjasygnalu); 
symul.pack(); 
symul.setVisible(true); 
symul.setBounds(0,0, 650, 550);	
}

}
