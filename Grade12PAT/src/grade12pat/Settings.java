/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grade12pat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yaseen
 */
public class Settings {
    private String[] doctors;
    private String practiceNumber;
    private String practiceAddress;
    private String bankNumber;
    private String branchCode;
    private String bankName;

    public static Settings loadSettingsFromFile() {
        try {
            HashMap<String, String> config = new HashMap<String, String>();
            BufferedReader br = new BufferedReader(new FileReader("settings.txt"));
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                String[] keyval = line.split(":");
                // ERROR key occurs twice;
                if (keyval.length != 2 || config.containsKey(keyval[0])) {
                    return null;
                } else {
                    config.put(keyval[0], keyval[1]);
                }
            }
            // Make sure we have all the keys
            String[] keys = {"Doctors", "PracticeNumber", "PracticeAddress", "BankNumber", "BranchCode", "BankName"};
            for (String k : keys) {
                if(!config.containsKey(br)) {
                          return null;    
                }
            }
            Settings settings = new Settings(
                    config.get("Doctors").split("#"),
                    config.get("PracticeNumber"),
                    config.get("PracticeAddress"),
                    config.get("BankNumber"),
                    config.get("BranchCode"),
                    config.get("BankName")
            );
            return settings;
        } catch (FileNotFoundException ex) {
            return null;
        } catch (IOException ex) {
            // TODO Catch Error Properly
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
     
    public Settings(String[] doctors, String practiceNumber,
            String practiceAddress, String bankNumber, String branchCode,
            String bankName) {
        this.doctors = doctors;
        this.practiceNumber = practiceNumber;
        this.practiceAddress = practiceAddress;
        this.bankNumber = bankNumber;
        this.branchCode = branchCode;
        this.bankName = bankName;
    }
    
    public String[] getDoctors() {
        return doctors;
    }

    public void setDoctors(String[] doctors) {
        this.doctors = doctors;
    }

    public String getPracticeNumber() {
        return practiceNumber;
    }

    public void setPracticeNumber(String practiceNumber) {
        this.practiceNumber = practiceNumber;
    }

    public String getPracticeAddress() {
        return practiceAddress;
    }

    public void setPracticeAddress(String practiceAddress) {
        this.practiceAddress = practiceAddress;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
