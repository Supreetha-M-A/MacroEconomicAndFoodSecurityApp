package com.example.macroeconomicfoodsecurity;
import android.content.Context;
import android.util.Log;

import java.io.*;

public class WriterController {

    private static void  seedGDPpercent(Context context, DBHandler dbHandler)
    {
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

    private static void  seedFDIInFlowspercent(Context context, DBHandler dbHandler)
    {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(context.getAssets().
                            open("macroeconomics/fdi_inflows_percent.csv"), "UTF-8"));

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

                dbHandler.addNewFDIInFlows(strArray );


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
    public static void seedData(Context context, DBHandler dbHandler) throws IOException {
        seedGDPpercent(context, dbHandler);
        seedFDIInFlowspercent(context, dbHandler);
    }
}
