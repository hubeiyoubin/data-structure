package com.datastructure.chapter_06_set_map;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @date : 2019-12-18
 */
public class FileWordCount {

    @Test
    public void testBSTreeSet(){
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();

        if(FileOperation.readFile("src\\main\\java\\datastructure\\chapter_06_set_map\\book\\pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            BSTreeSet<String> set1 = new BSTreeSet<>();
            for (String word : words1)
                set1.add(word);
            System.out.println("Total different words: " + set1.size());
        }

        System.out.println();


        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if(FileOperation.readFile("src\\main\\java\\datastructure\\chapter_06_set_map\\book\\a-tale-of-two-cities.txt", words2)){
            System.out.println("Total words: " + words2.size());

            BSTreeSet<String> set2 = new BSTreeSet<>();
            for(String word: words2)
                set2.add(word);
            System.out.println("Total different words: " + set2.size());
        }
    }

    @Test
    public void testLinkedListSet(){
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();

        if(FileOperation.readFile("src\\main\\java\\datastructure\\chapter_06_set_map\\book\\pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            LinkedListSet<String> set1 = new LinkedListSet<>();
            for (String word : words1)
                set1.add(word);
            System.out.println("Total different words: " + set1.size());
        }

        System.out.println();


        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if(FileOperation.readFile("src\\main\\java\\datastructure\\chapter_06_set_map\\book\\a-tale-of-two-cities.txt", words2)){
            System.out.println("Total words: " + words2.size());

            LinkedListSet<String> set2 = new LinkedListSet<>();
            for(String word: words2)
                set2.add(word);
            System.out.println("Total different words: " + set2.size());
        }
    }


    public double testTimeSet(Set<String> set, String filename){
        long start = System.nanoTime();
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename,words)){
            System.out.println("Total words: " + words.size());
        }
        for(String word: words){
            set.add(word);
        }
        System.out.println("Total different words: " + set.size());
        long end = System.nanoTime();
        return (end - start) / 1000000000.0;
    }
    public static void main(String[] args) {
        FileWordCount fwc = new FileWordCount();
        BSTreeSet<String> bsTreeSet = new BSTreeSet<>();
        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        String filename = FilePath.pride_and_prejudice;
        double time1 = fwc.testTimeSet(bsTreeSet,filename);
        double time2 = fwc.testTimeSet(linkedListSet,filename);
        System.out.println("bsTreeSet: " + time1);
        System.out.println("linkedListSet: " + time2);
    }
}
