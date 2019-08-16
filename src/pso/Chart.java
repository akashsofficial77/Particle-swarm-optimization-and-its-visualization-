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

	private JPanel contentPane;


	public Chart( String applicationTitle , String chartTitle, XYSeriesCollection dataset) {
	      super(applicationTitle);
	      JFreeChart lineChart = ChartFactory.createXYLineChart(
	         chartTitle,
	         "No of Iterations/Cost","Budget/Views",
	         dataset,
	         PlotOrientation.VERTICAL,
	         true,true,false);

		  ChartPanel chartPanel = new ChartPanel( lineChart );
	      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
	      setContentPane( chartPanel );
	   }

}