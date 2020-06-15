package com.datastructure.chapter_01_array;

/**
 * @date : 2019-10-30
 */
public class Array<E> {
    private int size;
    private E[] data;
    // 构造函数，传入数组的容量capacity构造Array
    public Array(int capacity){
        if(capacity < 0){
            throw new IllegalArgumentException("数组大小不能为负数");
        }
        data = (E[]) new Object[capacity];
        size = 0;
    }

    // 无参数的构造函数，默认数组的容量capacity=10
    public Array(){
        this(10);
    }

    // 获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    // 获取数组中的元素个数
    public int getSize(){
       return size;
    }

    // 返回数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 向所有元素后添加一个新元素
    public void addLast(E e){
        add(size,e);
    }

    // 在所有元素前添加一个新元素
    public void addFirst(E e){
        add(0,e);
    }

    // 在index索引的位置插入一个新元素e
    public void add(int index,E e){
        if(size == data.length){
            //throw new IllegalArgumentException("add 失败，数组已存满");
            int add = (size >> 1) == 0 ? 1 : size >> 1;
            int newCapacity = size + add;
            this.resize(newCapacity);
        }
        if(index < 0 || index > size){
            throw new IllegalArgumentException("add 失败，索引位置非法");
        }
        for(int i = size -1;i >= index; i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size ++;
    }

    // 获取index索引位置的元素
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("get 失败，索引位置非法");
        }
        return data[index];
    }
    public E getFirst(){
        return get(0);
    }
    public E getLast(){
        return get(size - 1);
    }
    // 修改index索引位置的元素为e
    public void set(int index,E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("set 失败，索引位置非法");
        }
        data[index] = e;
    }

    // 查找数组中是否有元素e contains
    public boolean contains(E e){
        int index = this.find(e);
        if(index == -1)
            return false;

        return true;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1 find
    public int find(E e){
        for(int i = 0; i < size; i++){
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }

    // 从数组中删除index位置的元素, 返回删除的元素
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("remove 失败，索引位置非法");
        }
        E e = data[index];
        for(int i=index+1; i<size;i++){
            data[i - 1] = data[i];
        }
        size --;
        if(size <= ( data.length >> 1)){
            this.resize(data.length >> 1);
        }
        return e;
    }

    // 从数组中删除第一个元素, 返回删除的元素 removeFirst
    public E removeFirst(){
        return remove(0);
    }

    // 从数组中删除最后一个元素, 返回删除的元素 removeLast
    public E removeLast(){
        return remove(size - 1);
    }

    // 从数组中删除元素e removeElement
    public void removeElement(E e){
        int index = this.find(e);
        if(index != -1)
            remove(index);
    }

    // 将数组空间的容量变成newCapacity大小
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i=0; i<size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    public void swap(int i, int j){
        if(i < 0 || i >= size || j < 0 || j >= size)
            throw new IllegalArgumentException("Index is illegal.");

        E e = data[i];
        data[i] = data[j];
        data[j] = e;
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0 ; i < size ; i ++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

    public static void main(String[] args) {
        //System.out.println(1 >> 1);
        Array array = new Array(0);
        System.out.println(array.toString());
        for(int i=1;i<=20;i++){

            array.addLast(i);
            System.out.println(array.toString());
        }
        System.out.println(array.toString());
       // System.out.println(array.get(2));
        //array.set(2,9);
        //System.out.println(array.toString());
        //array.removeElement(9);

        //array.removeLast();


        for(int i=1;i<=20;i++){
            array.removeLast();
            System.out.println(array.toString());
        }


    }
}
