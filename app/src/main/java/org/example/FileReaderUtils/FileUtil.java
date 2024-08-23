package org.example.FileReaderUtils;

import org.checkerframework.common.value.qual.StringVal;
import org.example.Entity.Bogie;
import org.example.Entity.Train;
import org.example.Repo.RoutePath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//import static org.example.Service.RoutePath.getRoute;

public class FileUtil {
    private static final String TRAIN_A = "TRAIN_A";
    private static final String TRAIN_B = "TRAIN_B";

    public static List<Train> readTrainsFromFile(String filePath) {
        List<Train> trains = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            trains.add(parseTrain(lines.get(0)));
            trains.add(parseTrain(lines.get(1)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return trains;
    }

    private static Train parseTrain(String line) {
        String[] parts = line.split(" ");
        String name = parts[0];
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 2; i < parts.length; i++) {

            String destination = parts[i];
            int distance;
            if(name.equals(TRAIN_A)){
                distance = RoutePath.getDistanceForTrainA(destination);
            }else if(name.equals(TRAIN_B)){
                distance = RoutePath.getDistanceForTrainB(destination);
            }
            else{
                throw new RuntimeException("Unknown train name : " + name);
            }
            bogies.add(new Bogie(destination, distance));
        }
        return new Train(name, bogies);
        }

    }
