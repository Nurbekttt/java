import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class writingRecords {
    String[][] nlistrec = new String[6][3];
    String[][] listrec = new String[5][3];
    long[] forsc = new long[6];
    long[] sc = new long[5];
    private int count = 0;
    ArrayList<String> arrayList = new ArrayList<>(  );
    public writingRecords(String time, String level, String name, String ttt) throws IOException {
        Scanner in =new Scanner( new File( level+".txt" ) );
        while(in.hasNext()){
            String a = in.next();
            String b = in.next();
            String c = in.next();
            System.out.println(a+b+c);
            forsc[count]=Long.parseLong( a );
            nlistrec[count][0]=a;
            nlistrec[count][1]=b;
            nlistrec[count][2]=c;
            count++;
        }
        forsc[5]=Long.parseLong( time );
        nlistrec[5][0]=time;
        nlistrec[5][1]=name;
        nlistrec[5][2]=ttt;
        Arrays.sort( forsc );
        for (int i = 0; i <5 ; i++) {
            for (int j = 0; j <6 ; j++) {
                if(forsc[i]==Long.parseLong(nlistrec[j][0])){
                    arrayList.add( nlistrec[j][0]) ;
                    arrayList.add( nlistrec[j][1]);
                    arrayList.add( nlistrec[j][2]);
                }
            }
        }
            PrintWriter printWriter = new PrintWriter( new File(level+".txt" ) );
            for (int i = 0; i <5 ; i++) {
                printWriter.print( arrayList.get( i*3 )+" "+arrayList.get( i*3+1 )+" "+arrayList.get( i*3+2)  );
                printWriter.println();
            }printWriter.close();
        System.out.println("saved");

            printWriter.close();
}

    public static void main(String[] args) throws  IOException{
        writingRecords wr = new writingRecords( "330000","easy","Nurbek","00:55:00" );
    }
}
