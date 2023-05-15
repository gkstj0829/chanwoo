import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class database {
    //read and write to database(txt file) using file stream
    //employee names are stored line by line at database.txt

    private BufferedReader br;
    private BufferedWriter bw;

    public int find_name(String name) throws IOException {
        //if name exist, return line number. if not, return 0
        br = new BufferedReader(new FileReader("./database.txt"));
        String str;
        while ((str = br.readLine()) != null) {
            String[] line = str.split(" ");
            if (line[0] == name) {
                //if the name matched.
                return 1;
            }
        }
        return 0;
    }

    public int work_hour(String name) throws IOException {
        //return work hour. if error occurs, return 0
        br = new BufferedReader(new FileReader("./database.txt"));
        String str;
        int workhour;
        while ((str = br.readLine()) != null) {
            String[] line = str.split(" ");
            workhour = Integer.parseInt(line[1]);
            return workhour;
        }
        return 0;
    }

    public void add_employee(String name) throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter("./database"));
        if(find_name(name) != 0) {
            System.out.println(name + "is already registered");
            return;
        }
        bw.write(name);
        bw.write(" ");
        bw.write("0");
        bw.newLine();

    }
}

