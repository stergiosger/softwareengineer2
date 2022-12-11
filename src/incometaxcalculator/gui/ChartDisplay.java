package incometaxcalculator.gui;

import java.awt.BorderLayout;
import java.text.DecimalFormat;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RefineryUtilities;

class ChartDisplay {

  static JFrame createPieChart(double entertainment, double basic, double travel, double health,
      double other) {

    JFrame pieChartFrame = new JFrame("Analysis of receipts");
    pieChartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    pieChartFrame.setLayout(new BorderLayout(0, 5));
    pieChartFrame.add(createPieChartPanel(entertainment, basic, travel, health, other),
        BorderLayout.CENTER);
    pieChartFrame.pack();
    RefineryUtilities.centerFrameOnScreen(pieChartFrame);
    pieChartFrame.setVisible(true);
    return pieChartFrame;
  }

  private static ChartPanel createPieChartPanel(double entertainment, double basic, double travel,
      double health, double other) {
    JFreeChart pieChart = ChartFactory.createPieChart(
        "Percentage of the total amount of each kind of receipt.",
        createDefaultPieDataset(entertainment, basic, travel, health, other), true, true, false);
    ChartPanel barChartPanel = new ChartPanel(pieChart);
    barChartPanel.setPreferredSize(new java.awt.Dimension(450, 550));
    return barChartPanel;
  }
  private static String createPercentages(double sumOfValues, double value) {
    double percentage=(value/sumOfValues)*100;
    DecimalFormat f = new DecimalFormat("##.00");
    if(percentage==0) return "0";
    return String.valueOf(f.format(percentage));
  }
  private static DefaultPieDataset createDefaultPieDataset(double entertainment, double basic,
      double travel, double health, double other) {
    double sumOfValues=entertainment+basic+health+travel+other;
    DefaultPieDataset pieChartDataset = new DefaultPieDataset();
    pieChartDataset.setValue("Entertainment "+createPercentages(sumOfValues,entertainment)+"%", entertainment);
    pieChartDataset.setValue("Basic "+createPercentages(sumOfValues,basic)+"%",basic);
    pieChartDataset.setValue("Travel "+createPercentages(sumOfValues,travel)+"%",travel);
    pieChartDataset.setValue("Health "+createPercentages(sumOfValues,health)+"%",health);
    pieChartDataset.setValue("Other "+createPercentages(sumOfValues,other)+"%",other);
    return pieChartDataset;
  }

  static JFrame createBarChart(double basicTax, double taxVariation, double totalTax) {
    JFrame barChartFrame = new JFrame("Bar Chart");
    barChartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    barChartFrame.setLayout(new BorderLayout(0, 5));
    barChartFrame.add(createBarChartPanel(basicTax, taxVariation, totalTax), BorderLayout.CENTER);
    barChartFrame.pack();
    RefineryUtilities.centerFrameOnScreen(barChartFrame);
    barChartFrame.setVisible(true);
    return barChartFrame;
  }

  private static ChartPanel createBarChartPanel(double basicTax, double taxVariation,
      double totalTax) {
    JFreeChart barChart = ChartFactory.createBarChart("", "", "Tax analysis in $",
        createDefaultCategoryDataset(basicTax, taxVariation, totalTax), PlotOrientation.VERTICAL,
        true, true, false);
    ChartPanel barChartPanel = new ChartPanel(barChart);
    barChartPanel.setPreferredSize(new java.awt.Dimension(450, 550));
    return barChartPanel;
  }

  private static DefaultCategoryDataset createDefaultCategoryDataset(double basicTax,
      double taxVariation, double totalTax) {
    DefaultCategoryDataset barChartDataset = new DefaultCategoryDataset();
    barChartDataset.addValue(basicTax, "Tax", "Basic");
    if (taxVariation > 0) {
      barChartDataset.addValue(taxVariation, "Tax", "Increase");
    } else {
      barChartDataset.addValue(-taxVariation, "Tax", "Decrease");
    }
    barChartDataset.addValue(totalTax, "Tax", "Total");
    return barChartDataset;
  }
}