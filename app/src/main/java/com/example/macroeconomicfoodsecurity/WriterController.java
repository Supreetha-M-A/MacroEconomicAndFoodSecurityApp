package com.example.macroeconomicfoodsecurity;
import android.content.Context;
import android.util.Log;

import java.io.*;

public class WriterController {

    public static void seedData(Context context, DBHandler dbHandler) throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(context.getAssets().
                            open("macroeconomics/gdpgrowthpercent.csv"), "UTF-8"));

            String line ="";
            reader.readLine();
            while ((line = reader.readLine()) != null) {

                String[] str = line.split(",");
                String[] strArray = { "","","",""};
                int index  = 0;
                for (String s : str
                     ) {
                    strArray[index++] = s;

                }

                dbHandler.addNewGDPPercent(strArray );


            }
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }

    }
}
