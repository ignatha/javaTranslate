import java.util.*;

import java.io.*;
import java.net.*;
import com.google.gson.Gson;

public class coba{

static class Page {
    String[] text;
}
	public static void main(String []args) throws Exception {
		String input="";
        int awal, tujuan;
        String from="", to="";
		Scanner in = new Scanner(System.in);
		System.out.print(" Masukkan Kata : ");
        input = in.nextLine();

        System.out.print(" Pilihan Bahasa \n 1. Indonesia\n 2. Jawa \n 3. Inggris\n\n Pilih Bahasa Awal : ");
        awal = in.nextInt();
		 System.out.print(" --------------- \n\n");
        System.out.print("\n Pilihan Bahasa \n 1. Indonesia\n 2. Jawa \n 3. Inggris\n\n Pilih Bahasa Tujuan : ");
        tujuan = in.nextInt();

        switch(awal){
            case 1:
            from+="id";
            break;
            case 2:
            from+="jv";
            break;
            case 3:
            from+="en";
            break;
        }

        switch(tujuan){
            case 1:
            to+="id";
            break;
            case 2:
            to+="jv";
            break;
            case 3:
            to+="en";
            break;
        }

        String url="https://translate.yandex.net/api/v1.5/tr.json/translate?key=trnsl.1.1.20161130T025328Z.94c34e2471ef7ac5.88d321b8a8a4fd93111fde884332e6d514c0c993&text="+input+"&lang="+from+"-"+to;
        
       String json = readUrl(url);
	   Gson gson = new Gson();
	   Page page = gson.fromJson(json, Page.class);
	    System.out.print(" --------------- \n\n");
		System.out.println(" Kata = "+input);
        System.out.println(" hasil Translate = "+page.text[0]);
		
}

private static String readUrl(String urlString) throws Exception {
    BufferedReader reader = null;
    try {
        URL url = new URL(urlString);
        reader = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuffer buffer = new StringBuffer();
        int read;
        char[] chars = new char[1024];
        while ((read = reader.read(chars)) != -1)
            buffer.append(chars, 0, read); 

        return buffer.toString();
    } finally {
        if (reader != null)
            reader.close();
    }
}


}
