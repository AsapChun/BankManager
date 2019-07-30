package BankPackage;

import java.util.Iterator;

public class Report {
	//I should have the ability to get a fully daily report or a report that just gives
    //me an update from the last time I ran the repo
  StringBuilder dailyReport = new StringBuilder();
  public Report() {
    dailyReport.append("Full Daily Report: "+ "\n");
  }
  
  public void resetReport() {
    dailyReport = new StringBuilder();
  }
  public String getString() {
    return dailyReport.toString();
  }
  
}
