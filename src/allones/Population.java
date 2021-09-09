package allones;

import java.util.Random;

public class Population {
    private  Individual[] everyone;
    private double populationFitness = -1;

    public Population(int size) {
        // create an empty population
        everyone = new Individual[size];
    }

    public Population(int size, int chromosomeLength) {
        // create a population of random individuals
        everyone = new Individual[size];
        for (int i = 0; i < size; i++) {
            Individual member = new Individual(chromosomeLength);
            everyone[i] = member;
        }
    }

    public Individual[] getEveryone() {
        return everyone;
    }

    public Individual getIndividual(int offset) {
        return everyone[offset];
    }

    public void setIndividual(int offset, Individual member) {
        everyone[offset] = member;
    }

    public void setPopulationFitness(double fitness) {
        populationFitness = fitness;
    }

    public double getPopulationFitness() {
        return populationFitness;
    }

    public int size() {
        return everyone.length;
    }


    public void shuffle() {
        // randomise the order of individuals in the population array
        Random r = new Random();
        for (int i = everyone.length-1; i > 0; i--) {
            // swap each element with a random one chosen from the unswapped elements
            int randomPosition = r.nextInt(i + 1); // nextInt is exclusive on upper bound
            Individual temp = everyone[randomPosition];
            everyone[randomPosition] = everyone[i];
            everyone[i] = temp;
        }
    }

    private void sortByFitness() {
        // bubble sort with fittest individuals first
        boolean swapped = true;
        int sorted = 0;
        while (swapped) {
            swapped = false;
            for (int i=0; i<everyone.length-sorted-1; i++) {
                if (everyone[i].getFitness() < everyone[i+1].getFitness()) {
                    Individual temp = everyone[i];
                    everyone[i] = everyone[i+1];
                    everyone[i+1] = temp;
                    swapped = true;
                }
            }
            sorted++;
        }
    }

    public Individual getFittest(int offset) {
        sortByFitness();
        return everyone[offset];
    }

}
