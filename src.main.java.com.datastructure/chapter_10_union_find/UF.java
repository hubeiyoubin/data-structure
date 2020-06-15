package com.datastructure.chapter_10_union_find;

/**
 * @date : 2019-12-31
 */
public interface UF {
    int getSize();
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);
}
