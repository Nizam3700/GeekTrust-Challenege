package org.example.Service;

import java.util.List;

import org.example.Entity.Bogie;
import org.example.Entity.Train;

public interface ITrainService {

    List<Bogie> mergeSortTrains(List<Bogie> trainA, List<Bogie> trainB);

    void ArrivalAndDeparture(Train trainA, Train trainB);

    List<Bogie> filterBogiesToHyderabad(Train train);

    void printArrivalAndDeparture(Train trainA, List<Bogie> arrivingBogiesA, Train trainB, List<Bogie> arrivingBogiesB, List<Bogie> mergedBogies);

    String formatBogies(List<Bogie> bogies);
}
