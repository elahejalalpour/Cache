/*
 * In The Name Of God
 * ========================================
 * [] File Name : block.java
 *
 * [] Creation Date : 28-08-2015
 *
 * [] Created By : Elahe Jalalpour (el.jalalpour@gmail.com)
 * =======================================
*/
/**
 * @author Elahe Jalalpour
 */
package me.elahe.cache;

public class Block {
    private int[] block;
    private int size;
    private int tag;
    private int counter;
    public Block(){
        tag=-1; 
    }

    /**
     * @return the block
     */
    public int[] getBlock() {
        return block;
    }

    /**
     * @param block the block to set
     */
    public void setBlock(int[] block) {
        this.block = block;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
        block=new int[size];
    }

    /**
     * @return the tag
     */
    public int getTag() {
        return tag;
    }

    /**
     * @param tag the tag to set
     */
    public void setTag(int tag) {
        this.tag = tag;
    }

    /**
     * @return the counter
     */
    public int getCounter() {
        return counter;
    }

    /**
     * @param counter the counter to set
     */
    public void setCounter(int counter) {
        this.counter = counter;
    }
    
    
}
