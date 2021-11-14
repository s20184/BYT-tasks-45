public class CatWikiPageBuilder implements Builder {
    private Species species;
    private double weight;
    private double height;
    private double headBodyLength;
    private double tailLength;
    private Fur fur;
    private Habitat habitat;
    private CircadianRhythm rhythm;

    @Override
    public void setSpecies(Species species) {
        this.species = species;
    }

    @Override
    public void setCircadianRhythm(CircadianRhythm circadianRhythm) {
        this.rhythm = circadianRhythm;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void setHeadBodyLength(double headBodyLength) {
        this.headBodyLength = headBodyLength;
    }

    @Override
    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }

    @Override
    public void setFur(Fur fur) {
        this.fur = fur;
    }

    @Override
    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    public CatWikiPage getResult(){
        return new CatWikiPage(species, rhythm, weight, height, headBodyLength, tailLength, fur, habitat);
    }
}