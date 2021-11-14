public class Cat {
    private final Species species;
    private final CircadianRhythm rhythm;
    private double weight;
    private double height;
    private double headBodyLength;
    private double tailLength;
    private Fur fur;
    private final Habitat habitat;

    public Cat(Species sp, CircadianRhythm cr, double w, double h,
               double hbLength, double tLength, Fur fur, Habitat habitat) {
        this.species = sp;
        this.rhythm = cr;
        this.weight = w;
        this.height = h;
        this.headBodyLength = hbLength;
        this.tailLength = tLength;
        this.fur = fur;
        this.habitat = habitat;
    }

    public void shedFur() {
        this.fur.setLength(this.fur.getLength()/2);
    }

    public void getWinterCoat() {
        this.fur.setLength(this.fur.getLength()*2);
    }

    public String toString(){
        return "Cat: " + species.toString() + " weighing around " + Math.round(weight) + " kilograms.";
    }
}
