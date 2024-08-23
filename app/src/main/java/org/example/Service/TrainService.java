package org.example.Service;

import org.example.Entity.Bogie;
import org.example.Entity.Train;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class TrainService implements ITrainService {
    
    public List<Bogie> mergeSortTrains(List<Bogie> trainA, List<Bogie> trainB) {
        List<Bogie> mergedList = new ArrayList<>();
        mergedList.addAll(trainA);
        mergedList.addAll(trainB);

        mergedList.sort(Comparator
            .comparingInt(Bogie::getDistance).reversed()
            .thenComparing(Comparator.comparing(Bogie::getDestination)));
        return mergedList;
    }
    public void ArrivalAndDeparture(Train trainA, Train trainB) {
        List<Bogie> arrivingBogiesA = filterBogiesToHyderabad(trainA);
        List<Bogie> arrivingBogiesB = filterBogiesToHyderabad(trainB);

        List<Bogie> mergedBogies = mergeSortTrains(arrivingBogiesA, arrivingBogiesB);

        printArrivalAndDeparture(trainA, arrivingBogiesA, trainB, arrivingBogiesB, mergedBogies);
    }
    public List<Bogie> filterBogiesToHyderabad(Train train) {
        List<Bogie> bogies = new ArrayList<>();
        for (Bogie bogie : train.getBogies()) {
            if (bogie.getDistance() >= 1200 && !bogie.getDestination().equals("PNE")) { 
                bogies.add(bogie);
            }
        }
        return bogies;
    }
    public void printArrivalAndDeparture(Train trainA, List<Bogie> arrivingBogiesA, Train trainB, List<Bogie> arrivingBogiesB, List<Bogie> mergedBogies) {
        if(mergedBogies.isEmpty()){
            System.out.println("JOURNEY_ENDED");
        }else{
            for(Bogie hydarrivalBogie : arrivingBogiesA){
                if(hydarrivalBogie.getDestination().equals("HYB")){
                    mergedBogies.remove(hydarrivalBogie);
                }
            }
            System.out.println("ARRIVAL TRAIN_A ENGINE " + formatBogies(arrivingBogiesA));
            System.out.println("ARRIVAL TRAIN_B ENGINE " + formatBogies(arrivingBogiesB));
            System.out.println("DEPARTURE TRAIN_AB ENGINE ENGINE " + formatBogies(mergedBogies));
        }
    }
    public String formatBogies(List<Bogie> bogies) {
        StringBuilder sb = new StringBuilder();
        for (Bogie bogie : bogies) {
            sb.append(bogie.getDestination()).append(" ");
        }
        return sb.toString().trim();
    }
}


