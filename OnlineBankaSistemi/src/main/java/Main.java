import Model.Bank;
import Model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        String result = new String(Files.readAllBytes(Paths.get("C:\\Users\\Deniz\\Desktop\\OnlineBankaSistemi.json")));
        User[] userArray = gson.fromJson(result, User[].class);


        System.out.println("******************************************************************************************");
        Bank.moneyTransfer(userArray[0], userArray[1], 500);

        Bank.payCreditCardStatement(userArray[0], 5000);

        Bank.payLoan(userArray[userArray.length - 1], 2500);


        try (Writer writer = new FileWriter("Output.json")) {
            gson = new GsonBuilder().create();
            gson.toJson(userArray, writer);
        }
    }
}
