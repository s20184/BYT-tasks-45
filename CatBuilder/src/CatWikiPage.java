import java.util.Locale;

public class CatWikiPage {
    private final String text;

    public CatWikiPage(Species sp, CircadianRhythm cr, double w, double h,
               double hbLength, double tLength, Fur fur, Habitat habitat) {
        this.text = "The cat species " + sp.toString().toLowerCase(Locale.ROOT).replaceAll("_"," ")
                + " lives in a " + habitat.toString().toLowerCase(Locale.ROOT) + " habitat "
                + "and leads a " + cr.toString().toLowerCase(Locale.ROOT) + " lifestyle. "
                + "The cat has an average weight of " + Math.floor(w) + " kilograms,"
                + " average shoulder height of " + Math.floor(h) + " centimetres, "
                + "and a total body length (head+body+tail) of " + Math.floor(hbLength+tLength) + " centimetres. "
                + "Their fur is normally " + fur.getColor() + " with a "
                + fur.getPattern() + " pattern.";
    }

    public String toString(){
        return this.text;
    }
}
