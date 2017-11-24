package domain;

public class Pokemon {
    private int number;
    private String name;
    private String johto;
    private String hoenn;
    private String sinnoh;
    private String teselia;
    private String kalos;
    private String alola;
    private String specie;
    private String type1; 
    private String type2;
    private float weight;
    private float height;    
    private String generation;   
    private String egg1;
    private String egg2;
    private int nextEvolution;

    public Pokemon(int number, String name, String johto, String hoenn, String sinnoh, String teselia, String kalos, 
            String alola, String specie, String type1, String type2, float weight, float height, String generation, String egg1, String egg2, int nextEvolution) {
        this.number = number;
        this.name = name;
        this.johto = johto;
        this.hoenn = hoenn;
        this.sinnoh = sinnoh;
        this.teselia = teselia;
        this.kalos = kalos;
        this.alola = alola;
        this.specie = specie;
        this.type1 = type1;
        this.type2 = type2;
        this.weight = weight;
        this.height = height;
        this.generation = generation;
        this.egg1 = egg1;
        this.egg2 = egg2;
        this.nextEvolution = nextEvolution;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJohto() {
        return johto;
    }

    public void setJohto(String johto) {
        this.johto = johto;
    }

    public String getHoenn() {
        return hoenn;
    }

    public void setHoenn(String hoenn) {
        this.hoenn = hoenn;
    }

    public String getSinnoh() {
        return sinnoh;
    }

    public void setSinnoh(String sinnoh) {
        this.sinnoh = sinnoh;
    }

    public String getTeselia() {
        return teselia;
    }

    public void setTeselia(String teselia) {
        this.teselia = teselia;
    }

    public String getKalos() {
        return kalos;
    }

    public void setKalos(String kalos) {
        this.kalos = kalos;
    }

    public String getAlola() {
        return alola;
    }

    public void setAlola(String alola) {
        this.alola = alola;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public String getEgg1() {
        return egg1;
    }

    public void setEgg1(String egg1) {
        this.egg1 = egg1;
    }

    public String getEgg2() {
        return egg2;
    }

    public void setEgg2(String egg2) {
        this.egg2 = egg2;
    }

    public int getNextEvolution() {
        return nextEvolution;
    }

    public void setNextEvolution(int nextEvolution) {
        this.nextEvolution = nextEvolution;
    }
    
    @Override
    public String toString() {
        return "Pokemon{" + "number=" + number + ", name=" + name + ", johto=" + johto + ", hoenn=" + hoenn + ", sinnoh=" + sinnoh + ", teselia=" + teselia + ", kalos=" + kalos + ", alola=" + alola + ", specie=" + specie + ", type1=" + type1 + ", type2=" + type2 + ", weight=" + weight + ", height=" + height + ", generation=" + generation + ", egg1=" + egg1 + ", egg2=" + egg2 + ", nextEvolution=" + nextEvolution + '}';
    }
}
