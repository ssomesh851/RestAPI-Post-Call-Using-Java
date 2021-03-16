package com.example.prgms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;

public class HWS {

    public static void main(String[] args) throws IOException {
        
    	URL url = new URL("http://10.3.102.10:8080/FIGW/api/fi/upstream_sst");
        //Insert your JSON query request
        String query = "{\r\n" + 
        		"	\"token\":\"\",\r\n" + 
        		"	\"sourceId\":\"CBS\",\r\n" + 
        		"	\"terminalId\":\"-\",\r\n" + 
        		"	\"type\":\"\",\r\n" + 
        		"	\"userId\":\"TEST01\",\r\n" + 
        		"	\"messageFormatId\":\"M_DVP010_sese023EI\",\r\n" + 
        		"	\"sese023List\":[\r\n" + 
        		"		{\r\n" + 
        		"			\"transactionId\":\"MCIZMMMYYGN210211R123456792\",\r\n" + 
        		"			\"securitiesMovementType\":\"DELI\",\r\n" + 
        		"			\"payment\":\"APMT\",\r\n" + 
        		"			\"reconciliationNo\":\"0000000001\",\r\n" + 
        		"			\"settlementDate\":\"2021-01-19\",\r\n" + 
        		"			\"lateDeliveryDate\":\"2021-01-20\",\r\n" + 
        		"			\"openCloseLoanId\":\"\",\r\n" + 
        		"			\"eventTBondBillCode\":\"1101\",\r\n" + 
        		"			\"eventFundCode\":\"1301\",\r\n" + 
        		"			\"eventCollateralCode\":\"\",\r\n" + 
        		"			\"transactionNote\":\"DVP settlement (normal case) Loan day 1\",\r\n" + 
        		"			\"tBondBillCode\":\"MMGVTB220522\",\r\n" + 
        		"			\"tradePhase\":\"1\",\r\n" + 
        		"			\"settlementFaceAmount\":\"100000000\",\r\n" + 
        		"			\"securitiesTransactionType\":\"04\",\r\n" + 
        		"			\"settlemtDateInstruction\":\"2\",\r\n" + 
        		"			\"dvpInstructionOmitCategory\":\"3\",\r\n" + 
        		"			\"dvpDvpcUseCategory\":\"1\",\r\n" + 
        		"			\"tBondBillSenderFICode\":\"MCIZMMMY\",\r\n" + 
        		"			\"tBondBillSenderAccountCategory\":\"92\",\r\n" + 
        		"			\"tBondBillReceiverFICode\":\"YCBBMMMY\",\r\n" + 
        		"			\"tBondBillReceiverAccountCategory\":\"92\",\r\n" + 
        		"			\"debtFIBranchCode\":\"MCIZMMMYYGN\",\r\n" + 
        		"			\"credtFIBranchCode\":\"YCBBMMMYNPT\",\r\n" + 
        		"			\"settlementAmt\":\"100000000\",\r\n" + 
        		"			\"creditDebitIndicator\":\"DBIT\",\r\n" + 
        		"			\"otherAmt\":\"0.0\",\r\n" + 
        		"			\"interestRatePercent\":\"1.025\"\r\n" + 
        		"		}\r\n" + 
        		"	]\r\n" + 
        		"	\r\n" + 
        		"}";
        //It change the apostrophe char to double quote char, to form a correct JSON string
        query=query.replace("'", "\"");

        try{
            //make connection
            URLConnection urlc = url.openConnection();
            //It Content Type is so important to support JSON call
            urlc.setRequestProperty("Content-Type", "application/json");
            Msj("Conectando: " + url.toString());
            //use post mode
            urlc.setDoOutput(true);
            urlc.setAllowUserInteraction(false);
    
            //send query
            PrintStream ps = new PrintStream(urlc.getOutputStream());
            ps.print(query);
            Msj("Consulta: " + query);
            ps.close();
    
            //get result
            BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
            String l = null;
            while ((l=br.readLine())!=null) {
                Msj(l);
            }
            
            br.close();
        } catch (Exception e){
            Msj("Error ocurrido");
            Msj(e.toString());
        }
    }
    
    private static void Msj(String texto){
        System.out.println(texto);
    }
}