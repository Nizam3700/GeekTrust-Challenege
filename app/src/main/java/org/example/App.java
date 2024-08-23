package org.example;

import java.util.List;

import org.example.Entity.Train;
import org.example.FileReaderUtils.FileUtil;
import org.example.Service.TrainService;

public class App {

    public static void main(String[] args) {
        // System.out.println("Welcome to Geektrust Backend Challenge!");

        String filePath1 = "app\\InputFiles\\inputfile1.txt";
        // String filePath2 = "app\\InputFiles\\inputfile2.txt";
        // String filePath3 = "app\\InputFiles\\inputfile3.txt";

        List<Train> trains = FileUtil.readTrainsFromFile(filePath1);


        if (trains == null || trains.size() < 2) {
            System.out.println("Invalid input file");
            return;
        }

        Train trainA = trains.get(0);
        Train trainB = trains.get(1);

        if(trainA == null || trainB == null){
            System.out.println("JOURNEY_ENDED");
            return;
        }

        TrainService service = new TrainService();
        service.ArrivalAndDeparture(trainA, trainB);
    }
}