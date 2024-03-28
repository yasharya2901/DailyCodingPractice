public class CatAndMouse {
    /*
     * https://www.hackerrank.com/challenges/cats-and-a-mouse/problem
     */


    static String catAndMouse(int x, int y, int z) {
        int dist_from_catA = Math.abs(z - x);
        int dist_from_catB = Math.abs(z - y);
        
        if (dist_from_catA > dist_from_catB) {
            return "Cat B";
        } else if (dist_from_catA < dist_from_catB) {
            return "Cat A";
        }
        return "Mouse C";
    }
}