package cz.engeto.L08_HW.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

@RestController
@RequestMapping("documents")
public class Controller {

    @GetMapping("historic")
    public String historic() throws Exception{
        String line = "";
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(
                "src/resources/historic")))) {
            while (scanner.hasNextLine()){
                line = scanner.nextLine();
            }
        } catch(FileNotFoundException e){
            System.err.println("Error při náčítání souboru");
        }
        return line;
    }

    @GetMapping("romatic")
    public String romatic(){
        String line = null;
        try (BufferedReader reader = new BufferedReader(new FileReader("src/resources/romatic"))) {
            line = reader.readLine();
        } catch (Exception e ){
            System.err.println("Chyba při načítání ze souboru");
        }
        return line;
    }

    @GetMapping("scifi")
    public String scifi(){
        String line = "";
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("src/resources/scifi")))) {
            while (scanner.hasNextLine()){
                line = scanner.nextLine();
            }
        } catch (IOException e){
            System.err.println("Nastala chyba při načítání ze souboru");
        }
        return line;
    }
}
