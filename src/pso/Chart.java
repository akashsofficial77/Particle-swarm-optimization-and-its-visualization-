/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pso;



import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;

public class Chart extends JFrame {

	/**
	 * 
	 */

	private JPanel contentPane;


	public Chart( String applicationTitle , String chartTitle, XYSeriesCollection dataset) {
	      super(applicationTitle);
	      JFreeChart lineChart = ChartFactory.createXYLineChart(
	         chartTitle,
	         "Element No","Time Required",
	         dataset,
	         PlotOrientation.VERTICAL,
	         true,true,false);
	      
	         
	      //boolean linechartDC;
		  ChartPanel chartPanel = new ChartPanel( lineChart );
	      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
	      setContentPane( chartPanel );
	   }

	 /* public static void main( String[] args ) {
	      Chart chart = new Chart(
	         "School Vs Years" ,
	         "Numer of Schools vs years");

	      chart.pack( );
	     // RefineryUtilities.centerFrameOnScreen( chart );
	      chart.setVisible( true );
	   
	
	  }*/
	
	 /*  private DefaultCategoryDataset createDataset( ) {
		     DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
		      dataset.addValue( 15 , "Size of N" , "1970" );
		      dataset.addValue( 30 , "Size of N" , "1980" );
		      dataset.addValue( 60 , "Size of N" ,  "1990" );
		      dataset.addValue( 120 , "Size of N" , "2000" );
		      dataset.addValue( 240 , "Size of N" , "2010" );
		      dataset.addValue( 300 , "Size of N" , "2014" );
		      return dataset;
		   }*/

}