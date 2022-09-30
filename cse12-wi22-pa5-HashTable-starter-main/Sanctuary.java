/**
 * TODO: Complete the solution for Sanctuary
 */
import java.util.HashMap;
import java.util.Set;

/**
 * This class creates a sanctuary which contains information about the a
 * species and the amount of that species that are in the sanctuary
 */
public class Sanctuary {
    
    HashMap<String, Integer> sanctuary;
    int maxAnimals;
    int maxSpecies;

    /**
     * A constructor that creates a sanctuary given some information
     * @param maxAnimals - the maximum amount of animals the sanctuary can 
     * store
     * @param maxSpecies - the maximum amount of species the sanctuary can 
     * store
     */
    public Sanctuary(int maxAnimals, int maxSpecies) {
        if (maxAnimals < 0 || maxSpecies < 0) {
            throw new IllegalArgumentException();
        }
        sanctuary = new HashMap();
        this.maxAnimals = maxAnimals;
        this.maxSpecies = maxSpecies;
    }

    /**
     * A method that gets the number of animals of a species in the sanctuary
     * @param species - The species being queried
     * @return - the amount of that species that are in the sanctuary
     */
    public int getNum(String species) {
        if (species == null) {
            throw new IllegalArgumentException();
        }
        return sanctuary.get(species);
    }

    /**
     * A method that gets the total amount of animals in the sanctuary
     * @return - the number of animals in the sanctuary
     */
    public int getTotalAnimals() {
        int totalAnimals = 0;
        Object[] keys = sanctuary.values().toArray();
        for (int i = 0; i < sanctuary.size(); i++) {
            totalAnimals = totalAnimals + (int)keys[i];
        }
        return totalAnimals;
    }

    /**
     * A method that gets the total amount of species in the sanctuary
     * @return - the number of species in the sanctuary
     */
    public int getTotalSpecies() {
        return sanctuary.size();
    }

    /**
     * A method that rescues a certain amount of animals of a species
     * into the sanctuary
     * @param species - the species being rescued
     * @param num - the amount of that species being rescued
     * @return - the number of aminals that did not fit in the sanctuary
     */
    public int rescue(String species, int num) {
        if (species == null || num <= 0) {
            throw new IllegalArgumentException();
        }
        // if statement for if the number of species being rescued goes over
        // the max capacity of animals that can be stored in the sanctuary
        if (num + getTotalAnimals() > maxAnimals) {
            int toReturn = num + getTotalAnimals() - maxAnimals;
            if (sanctuary.containsKey(species)) {
                sanctuary.put(species, maxAnimals - getTotalAnimals() +
                    sanctuary.get(species));
            } else {
                sanctuary.put(species, maxAnimals - getTotalAnimals());
            }
            return toReturn;
        }
        // this runs only if all the animals trying to be rescued fit into
        // the sanctuary
        if (sanctuary.containsKey(species)) {
            sanctuary.put(species, num + sanctuary.get(species));
        } else {
            sanctuary.put(species, num);
        }
        return 0;
    }

    /**
     * A method that releases animals from the sanctuary
     * @param species - the species being released
     * @param num - the amount of that species being released
     */
    public void release(String species, int num) {
        if (num <= 0 || species == null || !sanctuary.containsKey(species) ||
            num > sanctuary.get(species)) {
                throw new IllegalArgumentException();
        }
        sanctuary.put(species, sanctuary.get(species) - num);
        if (sanctuary.get(species) == 0) {
            sanctuary.remove(species);
        }
    }
}
