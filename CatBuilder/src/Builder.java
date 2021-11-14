import java.util.Locale;

// example of builder method pattern
// (provide at least 2 concrete implementations)
public interface Builder {
    void setSpecies (Species species);
    void setCircadianRhythm(CircadianRhythm circadianRhythm);
    void setWeight(double weight);
    void setHeight(double height);
    void setHeadBodyLength(double headBodyLength);
    void setTailLength(double tailLength);
    void setFur(Fur fur);
    void setHabitat(Habitat habitat);
}

enum Species {
    SNOW_LEOPARD, CLOUD_LEOPARD, LION, PUMA, LYNX, JAGUAR, TIGER
}

enum CircadianRhythm {
    DIURNAL, NOCTURNAL, CREPUSCULAR
}

enum Habitat {
    JUNGLE, SAVANNAH, WETLANDS, MOUNTAINOUS, OPEN_PLAIN, SWAMP, DESERT
}

class Fur {
    private double length;
    private final String color;
    private final Pattern pattern;

    public Fur(double length, String color, Pattern pattern){
        this.length = length;
        this.color = color;
        this.pattern = pattern;
    }

    public double getLength() {
        return this.length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getColor() {
        return this.color;
    }

    public String getPattern() {
        return this.pattern.toString().toLowerCase(Locale.ROOT);
    }
}

enum Pattern {
    ROSETTE, STRIPED, SPOTTED, DOTTED, SMOOTH
}