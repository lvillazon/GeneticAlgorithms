package allones;

public class AllOnesGA {

    public static void main(String[] args) {
        System.out.println("Running All Ones GA...");
        // Create the GA
        GeneticAlgorithm ga = new GeneticAlgorithm(5, 0.01, 0.95, 0);
        // Initialise the population
        Population population = ga.initPopulation(50);

        // check our work so far
        for (Individual member: population.getEveryone()) {
            member.setFitness(ga.calculateFitness(member));
            System.out.println(member.toString() + "  " + member.getFitness());
        }
        population.shuffle();
        System.out.println("After shuffling...");
        for (Individual member: population.getEveryone()) {
            System.out.println(member.toString() + "  " + member.getFitness());
        }
        System.out.println("After sorting...");
        for (int i=0; i<population.size(); i++) {
            Individual member = population.getFittest(i);
            System.out.println(member.toString() + "  " + member.getFitness());
        }
        ga.evaluatePopulation(population);
        System.out.println("Pop fitness = " + population.getPopulationFitness());
    }
}
