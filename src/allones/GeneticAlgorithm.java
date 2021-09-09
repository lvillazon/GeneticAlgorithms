package allones;

public class GeneticAlgorithm {
    private int populationSize;
    private double mutationRate;
    private double crossoverRate;
    private int elitismCount;

    public GeneticAlgorithm(int populationSize, double mutationRate, double crossoverRate, int elitismCount) {
        this.populationSize = populationSize;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
        this.elitismCount = elitismCount;
    }

    public Population initPopulation(int chromosomeLength) {
        return new Population(populationSize, chromosomeLength);
    }

    public double calculateFitness(Individual member) {
        // keep track of the number of "correct" genes
        int correct = 0;
        for (int i=0; i<member.getChromosomeLength(); i++) {
            // score 1 for each 1!
            if (member.getGene(i) == 1) {
                correct++;
            }
        }
        // normalise for chromosome length
        double fitness = (double) correct / member.getChromosomeLength();
        return fitness;
    }

    public void evaluatePopulation(Population p) {
        double totalFitness = 0.0;
        for (Individual member: p.getEveryone()) {
            double fitness = calculateFitness(member);
            member.setFitness(fitness);
            totalFitness += fitness;
        }
        // normalise fitness for the population
        p.setPopulationFitness((double) totalFitness / p.size());
    }
}
