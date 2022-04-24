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

    private static void  seedFDIOutFlowspercent(Context context, DBHandler dbHandler)
    {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(context.getAssets().
                            open("macroeconomics/fdi_outflows.csv"), "UTF-8"));

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

                dbHandler.addNewFDIOutFlows(strArray );


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

    private static void  seedGDPAgri(Context context, DBHandler dbHandler)
    {

        Log.e("SeedGDPAgri" , "");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(context.getAssets().
                            open("agriculture/GDPCount.csv"), "UTF-8"));

            String line ="";
            line = reader.readLine();
            Log.e("SeedGDPAgri" , line);
            while ((line = reader.readLine()) != null) {
                Log.e("SeedGDPAgri" , line);
                String[] str = line.split(",");
                String[] strArray = { "","","",""};
                int index  = 0;
                for (String s : str
                ) {
                    Log.e("SeedGDPAgri" , s);
                    strArray[index++] = s;

                }

                dbHandler.addNewGDPAgri(strArray );


            }
        } catch (IOException e) {
            Log.e("SeedGDPAgriErr" , e.getMessage());
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

    private static void  seedFertilizerConsump(Context context, DBHandler dbHandler)
    {

        Log.e("FertilizerCons" , "");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(context.getAssets().
                            open("agriculture/FertilizerCons.csv"), "UTF-8"));

            String line ="";
            line = reader.readLine();
            Log.e("SeedGDPAgri" , line);
            while ((line = reader.readLine()) != null) {
                Log.e("SeedGDPAgri" , line);
                String[] str = line.split(",");
                String[] strArray = { "","","",""};
                int index  = 0;
                for (String s : str
                ) {
                    Log.e("FertilizerCons" , s);
                    strArray[index++] = s;

                }

                dbHandler.addFertilizerConsum(strArray );


            }
        } catch (IOException e) {
            Log.e("FertilizerCons" , e.getMessage());
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
        seedFDIOutFlowspercent(context, dbHandler);
        seedGDPAgri(context, dbHandler);
        seedFertilizerConsump(context, dbHandler);
    }
}
