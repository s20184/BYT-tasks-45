public class Director {
    public void buildSnowLeopard (Builder builder) {
        builder.setSpecies(Species.SNOW_LEOPARD);
        builder.setCircadianRhythm(CircadianRhythm.CREPUSCULAR);
        builder.setWeight(Math.random()*33+22);
        builder.setHeight(Math.random()*10+56);
        builder.setHeadBodyLength(Math.random()*75+75);
        builder.setTailLength(Math.random()*25+80);
        builder.setFur(new Fur(Math.random()*7+5, "white", Pattern.ROSETTE));
        builder.setHabitat(Habitat.MOUNTAINOUS);
    }

    public void buildLion(Builder builder){
        builder.setSpecies(Species.LION);
        builder.setCircadianRhythm(CircadianRhythm.DIURNAL);
        builder.setWeight(Math.random()*100+110);
        builder.setHeight(Math.random()*10+110);
        builder.setHeadBodyLength(Math.random()*40+160);
        builder.setTailLength(Math.random()*20+70);
        builder.setFur(new Fur(10,"yellow", Pattern.SMOOTH));
        builder.setHabitat(Habitat.SAVANNAH);
    }
}
