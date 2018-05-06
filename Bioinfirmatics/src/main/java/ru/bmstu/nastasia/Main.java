package ru.bmstu.nastasia;

import org.yeastrc.fasta.FASTAEntry;
import org.yeastrc.fasta.FASTAReader;
import ru.bmstu.nastasia.algorithm.*;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static ArrayList<Line> readLines(String resources) {
        File fastaSrc = new File(resources);
        if (!fastaSrc.exists() || !fastaSrc.canRead()) {
            System.out.println("Fasta source file cannot be read. Exit.");
            System.exit(1);
        }
        FASTAReader fastaReader = null;
        ArrayList<Line> lines = new ArrayList<>();
        try {
            fastaReader = FASTAReader.getInstance(fastaSrc);
            FASTAEntry entry = fastaReader.readNext();
            while (entry != null) {
                lines.add(new Line(entry.getHeaderLine(), entry.getSequence()));
//                for (FASTAHeader header: entry.getHeaders()) {
//                    lines.add(new Line(header));
//                }
                entry = fastaReader.readNext();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.exit(1);
        }
        return lines;
    }

    public static void main(String[] args) {
            String str1, str2;
            str1 = "abaa";
            str2 = "aab";

            str1 = "CCTGyCTGCAGGATGTGCCG";
            str2 = "GATGTGCAGCCTGTAGG";

            str1 = "CCTABTTXABC";
            str2 = "ABCTT";

//            str1 = "ATGAGCACTGCGGGAAAAGTGATCAAATGCAAAGCTGCGGTGCTATGGGAGCTTCACAAACCCTTCACCATCGAGGACATAGAAGTCGCACCCCCCAAGGCCCATGAAGTTCGAATTAAGATGGTGGCCACTGGTGTCTGCCGCTCAGACGATCACGTGGTTAGTGGAACCCTGGTCACACCTCTTCCTGCAGTTTTAGGCCATGAGGGAGCAGGCATTGTTGAGAGCGTTGGAGAAGGGGTGACTTGTGTGAAACCAGGTGATAAAGTCATTCCACTCTTTTCCCCTCAGTGTGGAGAATGCAGGATTTGCAAGCACCCGGAAAGCAACTTTTGTAGCCGAAGCGATCTGCTAATGCCTCGGGGGACTTTGCGCGAAGGCACCAGCAGGTTCTCCTGCAAGGGAAAGCAGATCCACAACTTTATCAGCACCAGCACCTTCTCCCAGTACACCGTGGTAGATGATATAGCAGTGGCCAAAATCGATGGAGCTTCACCACTGGACAAAGTCTGCCTCATCGGCTGTGGGTTCTCAACTGGCTATGGCTCTGCCGTCAAAGTCGCCAAGGTGACCCCAGGCTCCACATGTGCCGTGTTTGGCCTCGGAGGTGTCGGTCTGTCTGTCATCATTGGCTGTAAAGCAGCAGGAGCAGCCAGGATCATTGCTGTGGACATCAACAAGGACAAGTTTGCCAAGGCCAAAGAGTTGGGTGCAACTGAGTGCATCAACCCTCAAGACTACAGCAAACCCATCCAGGAAGTTCTCCAGGAGATGACCGACGGAGGGGTGGACTTTTCGTTTGAAGTCATCGGCCGCCTTGACACCATGACTTCTGCCCTGCTGAGCTGCCATGCAGCATGTGGTGTAAGCGTCGTCGTAGGAGTGCCTCCCAATGCCCAGAACCTCTCCATGAACCCCATGTTGCTGCTGCTGGGACGCACCTGGAAGGGAGCAATATTTGGCGGGTTTAAGAGTAAAGATTCTGTCCCTAAACTTGTGGCTGACTTCATGGCTAAGAAGTTTCCGTTGGACCCGTTAATTACCCATGTTTTACCTTTCGAGAAAATAAATGAAGCATTTGACCTGCTTCGTTCTGGAAAGAGCATCCGTACCGTCCTGACTTTCTGA";
//            str2 = "ATGAGCACAGCAGGAAAAGTAATCAAATGCAAAGCAGCTGTGCTATGGGAGTTAAAGAAACCCTTTTCCATTGAGGAGGTGGAGGTTGCACCTCCTAAGGCCCATGAAGTTCGTATTAAGATGGTGGCTGTAGGAATCTGTGGCACAGATGACCACGTGGTTAGTGGTACCATGGTGACCCCACTTCCTGTGATTTTAGGCCATGAGGCAGCCGGCATCGTGGAGAGTGTTGGAGAAGGGGTGACTACAGTCAAACCAGGTGATAAAGTCATCCCACTCGCTATTCCTCAGTGTGGAAAATGCAGAATTTGTAAAAACCCGGAGAGCAACTACTGCTTGAAAAACGATGTAAGCAATCCTCAGGGGACCCTGCAGGATGGCACCAGCAGGTTCACCTGCAGGAGGAAGCCCATCCACCACTTCCTTGGCATCAGCACCTTCTCACAGTACACAGTGGTGGATGAAAATGCAGTAGCCAAAATTGATGCAGCCTCGCCTCTAGAGAAAGTCTGTCTCATTGGCTGTGGATTTTCAACTGGTTATGGGTCTGCAGTCAATGTTGCCAAGGTCACCCCAGGCTCTACCTGTGCTGTGTTTGGCCTGGGAGGGGTCGGCCTATCTGCTATTATGGGCTGTAAAGCAGCTGGGGCAGCCAGAATCATTGCGGTGGACATCAACAAGGACAAATTTGCAAAGGCCAAAGAGTTGGGTGCCACTGAATGCATCAACCCTCAAGACTACAAGAAACCCATCCAGGAGGTGCTAAAGGAAATGACTGATGGAGGTGTGGATTTTTCATTTGAAGTCATCGGTCGGCTTGACACCATGATGGCTTCCCTGTTATGTTGTCATGAGGCATGTGGCACAAGTGTCATCGTAGGGGTACCTCCTGATTCCCAAAACCTCTCAATGAACCCTATGCTGCTACTGACTGGACGTACCTGGAAGGGAGCTATTCTTGGTGGCTTTAAAAGTAAAGAATGTGTCCCAAAACTTGTGGCTGATTTTATGGCTAAGAAGTTTTCATTGGATGCATTAATAACCCATGTTTTACCTTTTGAAAAAATAAATGAAGGATTTGACCTGCTTCACTCTGGGAAAAGTATCCGTACCATTCTGATGTTTTGA";

//            str1 = "ATGAGCACTGCGGGAAAAGTGATCAAATGCAAAGCTGCGGTGCTATGGGAGCTTCACAAACCCTTCACCATCGAGGACATAGAAGTCGCACCCCCCAAGGCCCATGAAGTTCGAATTAAGATGGTGGCCACTGGTGTCTGCCGCTCAGACGATCACGTGGTTAGTGGAACCCTGGTCACACCTCTTCCTGCAGTTTTAGGCCATGAGGGAGCAGGCATTGTTGAGAGCGTTGGAGAAGGGGTGACTTGTGTGAAACCAGGTGATAAAGTCATTCCACTCTTTTCCCCTCAGTGTGGAGAATGCAGGATTTGCAAGCACCCGGAAAGCAACTTTTGTAGCCGAAGCGATCTGCTAATGCCTCGGGGGACTTTGCGCGAAGGCACCAGCAGGTTCTCCTGCAAGGGAAAGCAGATCCACAACTTTATCAGCACCAGCACCTTCTCCCAGTACACCGTGGTAGATGATATAGCAGTGGCCAAAATCGATGGAGCTTCACCACTGGACAAAGTCTGCCTCATCGGCTGTGGGTTCTCAACTGGCTATGGCTCTGCCGTCAAAGTCGCCAAGGTGACCCCAGGCTCCACATGTGCCGTGTTTGGCCTCGGAGGTGTCGGTCTGTCTGTCATCATTGGCTGTAAAGCAGCAGGAGCAGCCAGGATCATTGCTGTGGACATCAACAAGGACAAGTTTGCCAAGGCCAAAGAGTTGGGTGCAACTGAGTGCATCAACCCTCAAGACTACAGCAAACCCATCCAGGAAGTTCTCCAGGAGATGACCGACGGAGGGGTGGACTTTTCGTTTGAAGTCATCGGCCGCCTTGACACCATGACTTCTGCCCTGCTGAGCTGCCATGCAGCATGTGGTGTAAGCGTCGTCGTAGGAGTGCCTCCCAATGCCCAGAACCTCTCCATGAACCCCATGTTGCTGCTGCTGGGACGCACCTGGAAGGGAGCAATATTTGGCGGGTTTAAGAGTAAAGATTCTGTCCCTAAACTTGTGGCTGACTTCATGGCTAAGAAGTTTCCGTTGGACCCGTTAATTACCCATGTTTTACCTTTCGAGAAAATAAATGAAGCATTTGACCTGCTTCGTTCTGGAAAGAGCATCCGTACCGTCCTGACTTTCTGA";
//            str2 = "ATGAGCACAGCAGGAAAAGTAATCAAATGCAAAGCAGCTGTGCTATGGGAGTTAAAGAAACCCTTTTCCATTGAGGAGGTGGAGGTTGCACCTCCTAAGGCCCATGAAGTTCGTATTAAGATGGTGGCTGTAGGAATCTGTGGCACAGATGACCACGTGGTTAGTGGTACCATGGTGACCCCACTTCCTGTGATTTTAGGCCATGAGGCAGCCGGCATCGTGGAGAGTGTTGGAGAAGGGGTGACTACAGTCAAACCAGGTGATAAAGTCATCCCACTCGCTATTCCTCAGTGTGGAAAATGCAGAATTTGTAAAAACCCGGAGAGCAACTACTGCTTGAAAAACGATGTAAGCAATCCTCAGGGGACCCTGCAGGATGGCACCAGCAGGTTCACCTGCAGGAGGAAGCCCATCCACCACTTCCTTGGCATCAGCACCTTCTCACAGTACACAGTGGTGGATGAAAATGCAGTAGCCAAAATTGATGCAGCCTCGCCTCTAGAGAAAGTCTGTCTCATTGGCTGTGGATTTTCAACTGGTTATGGGTCTGCAGTCAATGTTGCCAAGGTCACCCCAGGCTCTACCTGTGCTGTGTTTGGCCTGGGAGGGGTCGGCCTATCTGCTATTATGGGCTGTAAAGCAGCTGGGGCAGCCAGAATCATTGCGGTGGACATCAACAAGGACAAATTTGCAAAGGCCAAAGAGTTGGGTGCCACTGAATGCATCAACCCTCAAGACTACAAGAAACCCATCCAGGAGGTGCTAAAGGAAATGACTGATGGAGGTGTGGATTTTTCATTTGAAGTCATCGGTCGGCTTGACACCATGATGGCTTCCCTGTTATGTTGTCATGAGGCATGTGGCACAAGTGTCATCGTAGGGGTACCTCCTGATTCCCAAAACCTCTCAATGAACCCTATGCTGCTACTGACTGGACGTACCTGGAAGGGAGCTATTCTTGGTGGCTTTAAAAGTAAAGAATGTGTCCCAAAACTTGTGGCTGATTTTATGGCTAAGAAGTTTTCATTGGATGCATTAATAACCCATGTTTTACCTTTTGAAAAAATAAATGAAGGATTTGACCTGCTTCACTCTGGGAAAAGTATCCGTACCATTCTGATGTTTTGA";
//            str1 = "abc";
//            str2 = "a";

//            str1 = "AABCDDDD";
//            str2 = "AAABCD";

//            str1 = "AGTA";
//            str2 = "ATA";
//            str1 = "AGACTAGTTAC";
//            str2 = "CGAGACGT";

            str1 = "xxxATxxA";
            str2 = "AyTyy";

            str1 = "xxxATxxA";
            str2 = "AyTyy";

        Parameters parameters = Parameters.parseParams(args);
//        System.out.println(parameters);
        ArrayList<Line> lines = readLines(parameters.getFastaSource());
        // Раскомментировать следующую строку, если хочется потестить маленькие строки из кода
//        lines.clear(); lines.add(new Line("1", str1)); lines.add(new Line("2", str2));

        if (lines.size() < 2) {
            System.out.println("Nothing to countScore: " + lines.size() + " strings found. Expected 2 or more.");
            System.exit(1);
        }
        Line A = lines.get(0);
        Line B = lines.get(1);

//        System.out.println(A.getLine() + "\n" +B.getLine());

        Aligner aligner;
        // Пытаемся понять, какой алгоритм использовать, если не понятно - выбрать алгоритм Нидлмана-Вунша
        String algorithm = parameters.getAlgorithm().toUpperCase();
        if (algorithm.equals("NW")) {
            aligner = new NWClassic(A, B, parameters);
        } else if (algorithm.equals("NWA")) {
            aligner = new NWAffinePenalty(A, B, parameters);
        } else if (algorithm.equals("MSA")) {
            aligner = new MultipleSequences(lines, parameters);
        } else if (algorithm.equals("SW")) {
            aligner = new SmithWaterman(A, B, parameters);
        } else if (algorithm.equals("NAIVE")) {
                aligner = new Naive(A, B, parameters);
        }else {
            System.out.println("Unexpected algorithm \"" + parameters.getAlgorithm() + "\"\n" +
                    "Arguments \"NW\", \"NWA\", \"MSA\", \"SW\" expected. Used default \"NW\"");
            aligner = new NWClassic(A, B, parameters);
        }
        //
        NWClassic alignerClassic = new NWClassic(A, B, parameters);

        System.out.println(algorithm + " score:" + aligner.getScore());
        Line.prettyPrint(aligner.getAlignment(), parameters.getOutputLineLength());
        if (aligner instanceof NWAffinePenalty) {
            System.out.println(((NWAffinePenalty) aligner).getMatrix());
        }
        System.out.println(String.format("%."+ parameters.getOutputLineLength() + "s",
                "**********************************************************************"));
        System.out.println("NW affine score: " + alignerClassic.getScore());
        Line.prettyPrint(alignerClassic.getAlignment(), parameters.getOutputLineLength());
        System.out.println(alignerClassic.getMatrix());


    }
}