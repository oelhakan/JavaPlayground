enum Planet{
    MERCURY(1),
    VENUS(2),
    EARTH(3),
    MARS(4),
    JUPITER(5),
    SATURN(6),
    URANUS(7),
    NEPTUNE(8),
    PLUTO(9);

    int numberOfPlanet;

    Planet(int number){
        this.numberOfPlanet = number;
    }
}

public class Enums {
    public static void main(String[] args) {

        //enum = enumerated(ordered listing of items in a collection)
        //enums are a grouping of  constants, but they behave similarly to objects

        Planet myPlanet = Planet.EARTH;

        canILiveHere(myPlanet);
    }

    static void canILiveHere(Planet aPlanet){
        if(aPlanet.equals(Planet.EARTH)){
            System.out.println("You Can Live Here");
        }else{
            System.out.println("You Can Not Live Here Yet");
        }
        System.out.println("This Is Planet Number : " + aPlanet.numberOfPlanet);
    }
}
