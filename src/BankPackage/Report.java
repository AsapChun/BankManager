package BankPackage;

public class Report {
	//I should have the ability to get a fully daily report or a report that just gives
    //me an update from the last time I ran the repo
  StringBuilder report = new StringBuilder();
  public Report() {
    report.append("Report: "+ "\n");
  }
  public void updateReport(String add) {
    
    
  }
  public void resetReport() {
    report = new StringBuilder();
  }
  
}
