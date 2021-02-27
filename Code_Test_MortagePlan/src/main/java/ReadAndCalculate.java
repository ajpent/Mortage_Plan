import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileReader;
import java.sql.SQLOutput;


public class ReadAndCalculate {

    public void readfileAndCalculate(){

        int wronglines=0;
        int exportedlines=0;
        //reading file
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("prospects.txt").getFile());
        CSVReader reader ;
        try
        {
            //parsing a CSV file into CSVReader class constructor
            reader = new CSVReader(new FileReader(file));
            String[] nextLine;

            //goes through all the lines and keeps trac of exported lines and errors
            while ((nextLine = reader.readNext()) != null)
            {
                    boolean ok=doCalculations(nextLine);
                    if(ok){
                        exportedlines++;
                    }else{
                        wronglines++;
                    }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        //prints the amount of empty/wrong lines
        System.out.println("We succesfully imported "+exportedlines+" lines.");
        System.out.println("We had "+wronglines+" lines with errors or empty lines");
    }


    //returns true if the calculations are ok and false if there is a error
    //checks that the format is ok there needs to be 4 datas on each line in order String, double, double, int

    public boolean doCalculations(String[] data){

        Maths math=new Maths();
        if(data.length==4) {
            try {
                math.maths(Double.parseDouble(data[1]), Double.parseDouble(data[2]), Integer.valueOf(data[3]));
                System.out.print(data[0] + " pays ");
                System.out.print(math.calculatePayement());
                System.out.println(" per month.");
                return true;
            } catch (Exception e) {
                return false;
            }
        }else {
            return false;
        }
    }


}
