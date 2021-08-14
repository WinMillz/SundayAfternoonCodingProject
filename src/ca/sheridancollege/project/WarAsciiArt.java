package ca.sheridancollege.project;

/**
 * This class contains methods that print ASCII art.
 *
 * @author Jinyoung (Kayla) Jeon August 2021
 * @author Juyoung (Jenny) Jung August 2021
 * @author Tamara Dang August 2021
 * @author Winston Martinez August 2021
 */
public class WarAsciiArt {

    public static void displayGameStart() {
        System.out.println(
                "  WELCOME TO WAR CARD GAME !   _____\n"
                + "   _____                _____ |6    |\n"
                + "  |2    | _____        |5    || v v | \n"
                + "  |  v  ||3    | _____ | v v || v v | _____\n"
                + "  |     || v v ||4    ||  v  || v v ||7    |\n"
                + "  |  v  ||     || v v || v v ||____9|| v v |\n"
                + "  |____Z||  v  ||     ||____S|       |v v v|\n"
                + "         |____E|| v v |              | v v |\n"
                + "                |____h|              |____L|\n");

    }

    public static void displayGameEnd() {
        System.out.println("\n\n(∗ ･‿･)ﾉ゛ Thanks for Playing, Bye!! ");

    }

    public static void displayWar() {
        System.out.println(
                "==========THIS IS WAR!==========\n"
                + "      |_O            O_\\\n"
                + "        |`-)--- ---(-'\\\n"
                + "        |\\           / |\n"
                + "       /  |          |  \\\n"
                + "================================"
        );

    }

}
