package org.example;

import org.example.Entity.Bogie;
import org.example.Entity.Train;
import org.example.Service.TrainService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

@DisplayName("TrainService Test")
class TrainServiceTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    

    @Test
    public void testArrivalAndDeparture3() {
        TrainService trainService = new TrainService();
        Train trainA = new Train("TRAIN_A", new ArrayList<>());
        Train trainB = new Train("TRAIN_B", new ArrayList<>());

        trainService.ArrivalAndDeparture(trainA, trainB);

        String expectedOutput = "JOURNEY_ENDED";

        assertEquals(expectedOutput.trim(), outputStreamCaptor.toString().trim());
    }

    @BeforeEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}