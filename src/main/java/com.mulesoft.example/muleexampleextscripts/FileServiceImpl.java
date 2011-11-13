package com.mulesoft.example.muleexampleextscripts;

import javax.jws.WebService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: davideason
 * Date: 11/12/11
 * Time: 2:17 PM
 * Description: Simple application to illustrate how to invoke Unix style commands using ProcessBuilder (java).
 */
@WebService(endpointInterface = "com.mulesoft.example.muleexampleextscripts", serviceName = "FileService")
public class FileServiceImpl implements FileService {

    private String dateString;
    private Process process;

    public String listDate() {

        try {
            // Alternative-1 to invoke Unix (type) commands using Java and ProcessBuilder
            process = new ProcessBuilder("date").start();
            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            dateString = br.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return dateString;
    }
}
