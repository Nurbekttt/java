import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class WritingIO {
        String[][] nlist = new String[6][3];
        String[][] list = new String[5][3];
        long[] forsc = new long[6];
        long[] sc = new long[5];
        private int count = 0;
        ArrayList<String> arrayList = new ArrayList<>(  );
        public WritingIO(String level)throws IOException{
            Scanner in =new Scanner( new File( level+".txt" ) );
            while(in.hasNext()){
                String a = in.next();
                String b = in.next();
                String c = in.next();
                System.out.println(a+b+c);
                sc[count]=Long.parseLong( a );
                list[count][0]=a;
                list[count][1]=b;
                list[count][2]=c;
                count++;
            }

        }

    public String[][] getList() {
        return list;
    }

    public long[] getSc() {
        return sc;
    }

    public WritingIO(String time, String level, String name, String ttt) throws IOException{
            Scanner in =new Scanner( new File( level+".txt" ) );
            while(in.hasNext()){
                String a = in.next();
                String b = in.next();
                String c = in.next();
                System.out.println(a+b+c);
                forsc[count]=Long.parseLong( a );
                nlist[count][0]=a;
                nlist[count][1]=b;
                nlist[count][2]=c;
                count++;
            }
            forsc[5]=Long.parseLong( time );
            nlist[5][0]=time;
            nlist[5][1]=name;
            nlist[5][2]=ttt;
            Arrays.sort( forsc );
            for (int i = 0; i <5 ; i++) {
                for (int j = 0; j <6 ; j++) {
                    if(forsc[i]==Long.parseLong(nlist[j][0])){
                        arrayList.add( nlist[j][0]) ;
                        arrayList.add( nlist[j][1]);
                        arrayList.add( nlist[j][2]);
                    }
                }
            }
            /*PrintWriter printWriter = new PrintWriter( new File(level+".txt" ) );
            for (int i = 0; i <5 ; i++) {
                printWriter.print( arrayList.get( i*3 )+" "+arrayList.get( i*3+1 )+" "+arrayList.get( i*3+2)  );
                printWriter.println();
            }

            printWriter.close();
            System.out.println("qqq");*/
        }



    public static void main(String[] args) {
        try {
            WritingIO w = new WritingIO( "10000","hard","Beka" ,"00:00:10");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
