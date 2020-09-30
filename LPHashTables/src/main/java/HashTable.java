/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author barry
 */
public class HashTable {
    DataItem[] hashArray;
    int arraySize;
    DataItem nonItem;
    
    public HashTable(int size) {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);
    }
    
    public void displayTable() {
        System.out.print("Table: ");
        for(int j=0; j<arraySize; j++) {
            if(hashArray[j] != null) {
                System.out.print(hashArray[j].iData + " ");
            }else{
                System.out.print("** ");
            }
            System.out.println(" ");
        }
    }
    
    
    public int hashFunc(int key) {
        return key % arraySize;
    }
    
    public void insert(DataItem item) {
        int key = item.iData;
        int hashVal = hashFunc(key);
        
        while(hashArray[hashVal] != null && hashArray[hashVal].iData != -1) {
            ++hashVal;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
    }
    
    public DataItem delete(int key) {
        int hashVal = hashFunc(key);
        
        while(hashArray[hashVal] != null) {
            if(hashArray[hashVal].iData == key) {
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }
    
    
    public DataItem find(int key) {
        int hashVal = hashFunc(key);
        
        while(hashArray[hashVal] != null) {
            if(hashArray[hashVal].iData == key){
                return hashArray[hashVal];
            }
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }
    
}
