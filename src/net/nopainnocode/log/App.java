package net.nopainnocode.log;

/**
 * Created by no_pain_no_code on 2015. 11. 29..
 */
public class App {
    public static void main(String[] args) {
        //String path = "/Users/no_pain_no_code/Documents/dkTechinLog/";
        String path = "";
        LogAnalyzer logAnalyzer = new LogAnalyzer(path);
        logAnalyzer.analyze();
    }
}
