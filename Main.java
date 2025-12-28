// Adhuna Devineni
// AP Comp Sci Period 3


import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> wordlist = new ArrayList<>();

        Collections.addAll(wordlist,
                "abbey", "abbot", "abhor",
                "abide", "abled", "abler",
                "abode", "abort", "about",
                "above", "abuse", "abyss",
                "ached", "aches", "acids",
                "acing", "acorn", "acres",
                "acted", "actor", "acute",
                "adage", "adapt", "added",
                "adder", "adieu",
                "wrack", "wrath", "wreak",
                "wreck", "wrist", "write",
                "wrote", "wryly", "xenon",
                "xylem", "yacht", "yanks",
                "yards", "years", "yeast",
                "yells", "yodel", "young",
                "yours", "youth", "yucca",
                "zebra", "zeros", "zests",
                "zonal", "zoned", "zooms"
        );

        Collections.sort(wordlist);

        System.out.println("-----");
        for (String x : wordlist) {
            System.out.println(x);
        }
    }
}
