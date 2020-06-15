package com.datastructure.chapter_09_trie;

import org.junit.Test;

/**
 * @date : 2019-12-27
 */
public class RandomizedSetTest {

    @Test
    public void testRandomizedSet_HashMap(){
//[,"","","","insert","remove","getRandom"]
//[,[,[],[],[2],[1],[]]
        //RandomizedSet_HashMap rs = new RandomizedSet_HashMap();
        RandomizedSet_Trie rs = new RandomizedSet_Trie();
        System.out.println(rs.insert(0));
        System.out.println(rs.insert(1));

        System.out.println(rs.remove(0));

        System.out.println(rs.insert(2));

        System.out.println(rs.remove(1));

        System.out.println(rs.getRandom());
    }
}
