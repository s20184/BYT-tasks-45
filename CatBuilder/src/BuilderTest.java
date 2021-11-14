public class BuilderTest {
    public static void main(String[] args){
        Director director = new Director();
        CatBuilder catBuilder = new CatBuilder();
        CatWikiPageBuilder catWikiPageBuilder = new CatWikiPageBuilder();

        director.buildLion(catBuilder);
        director.buildLion(catWikiPageBuilder);

        Cat lion = catBuilder.getResult();
        CatWikiPage lionWikiPage = catWikiPageBuilder.getResult();

        director.buildSnowLeopard(catBuilder);
        director.buildSnowLeopard(catWikiPageBuilder);

        Cat snowLeopard = catBuilder.getResult();
        CatWikiPage snowLeopardWikiPage = catWikiPageBuilder.getResult();

        System.out.println(lion);
        System.out.println(lionWikiPage);
        System.out.println(snowLeopard);
        System.out.println(snowLeopardWikiPage);
    }
}
