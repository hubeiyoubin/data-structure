package com.datastructure.chapter_01_array;

/**
 * @date : 2019-10-30
 */
public class Array01 {

    private int size;
    private int[] data;
    // 构造函数，传入数组的容量capacity构造Array
    public Array01(int capacity){
        data = new int[capacity];
        size = 0;
    }

    // 无参数的构造函数，默认数组的容量capacity=10
    public Array01(){
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
    public void addLast(int e){
        this.add(size,e);
    }

    // 在所有元素前添加一个新元素
    public void addFirst(int e){
        this.add(0,e);
    }

    // 在index索引的位置插入一个新元素e
    public void add(int index,int e){
        if(size == data.length){
            throw new IllegalArgumentException("添加失败，数组已存满");
        }
        if(index < 0 || index > size){
            throw new IllegalArgumentException("添加失败，索引位置不能小于0，不能大于数组大小");
        }
        for(int i = size -1; i >=index; i--){
            data[i + 1] = data[i];
        }
        data[index] = e;
        size ++;
    }

    // 获取index索引位置的元素
    public int get(int index){
        if(index < 0 || index >=size){
            throw new IllegalArgumentException("获取失败，索引非法");
        }
        return data[index];
    }
    // 修改index索引位置的元素为e
    public void set(int index,int e){
        if(index < 0 || index >=size){
            throw new IllegalArgumentException("设置失败，索引非法");
        }
        data[index] = e;
    }

    // 查找数组中是否有元素e contains
    public boolean contains(int e){
      int index = this.find(e);
      if(index == -1){
          return false;
      }
      return true;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1 find
    public int find(int e){
        for(int i = 0;i < size;i++){
            if(data[i] == e){
                return i;
            }
        }
        return -1;
    }

    // 从数组中删除index位置的元素, 返回删除的元素
    public int remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("删除失败，索引位置非法");
        }
        int e = data[index];
        for(int i = index+1;i<size;i++){
            data[i - 1] = data[i];
        }
        size --;
        return e;
    }

    // 从数组中删除第一个元素, 返回删除的元素 removeFirst
    public int removeFirst(){
        return this.remove(0);
    }

    // 从数组中删除最后一个元素, 返回删除的元素 removeLast
    public int removeLast(){
        return this.remove(size-1);
    }

    // 从数组中删除元素e removeElement
    public void removeElement(int e){
        int index = this.find(e);
        if(index != -1){
            this.remove(index);
        }
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
        Array01 array01 = new Array01();
        for(int i=1;i<=3;i++){
            array01.addLast(i);
        }
        //System.out.println(array01.toString());
        //System.out.println(array01.get(2));
        array01.set(2,9);
        System.out.println(array01.toString());
        array01.removeElement(9);
        System.out.println(array01.toString());
        array01.removeLast();
        System.out.println(array01.toString());
    }
}
