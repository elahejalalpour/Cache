/*
 * In The Name Of God
 * ========================================
 * [] File Name : Cache.java
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

public class Cache {
    private int hit=0;
    private int k;
    private int b;
    private int c;
    int m;
    int size;
    int way;
    private block [][] array;
    int col;
    int max;
    public Cache(int k,int b,int c,int way)
    {
        this.k=k;
        this.b=b;
        this.c=c;
        size=c/b/k;
        array=new block[c/b/k][k];
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<k;j++)
            {
                array[i][j] = new block();
                array[i][j].setSize(b);
            }
        }
        this.way=way;
    }
   void check(int data)
   {
       int ad=(data/b)%(c/(k*b));
       int tag=(data/b)/(c/(k*b));
       int inB=data%b;
       int check=0;
       int check2=0;
       for(int i=0;i<k;i++)
       {
           if(array[ad][i].getTag()==tag )
           {
               System.out.println("hit");
               hit++;
               check++;
               col=i;
               for(int e=0;e<size;e++){
                   for(int u=0;u<k;u++){
                       array[e][u].setCounter(array[e][u].getCounter()+1);
                   }
               }
               array[ad][i].setCounter(0);
               break;
           }
           else
           {
                System.out.println("miss");
                break;
           }
           
       }
       for(int i=0;i<k;i++){
           if(array[ad][i].getTag()==-1)
           {
               array[ad][i].setTag(tag);
               check2++;
               break;
           }
       }
       if(check==0 && check2==0)
       {
               switch(way)
                {
                    case 1:
                        int rand=((int)(Math.random()*k*10)/10);
                        for(int s=0;s<b;s++)
                        {
                        array[ad][rand].getBlock()[s]=1;
                        array[ad][rand].setTag(tag);
                        }
                        
                        for(int e=0;e<size;e++){
                            for(int u=0;u<k;u++){
                       array[e][u].setCounter(array[e][u].getCounter()+1);
                                                }
                                                }
                        array[ad][rand].setCounter(0);
                    case 2:
                        for(int s=k-1;s>0;s--)
                        {
                            array[ad][s].setTag(array[ad][s-1].getTag());
                        }
                        array[ad][0].setTag(tag);
                        for(int e=0;e<size;e++){
                            for(int u=0;u<k;u++){
                                array[e][u].setCounter(array[e][u].getCounter()+1);
                                                }
                                                }
                        array[ad][0].setCounter(0);
                    case 3:
                    max=-1;
                    int maxcol=0,maxrow=0;
                    for(int e=0;e<size;e++){
                        for(int u=0;u<k;u++){
                            if(array[e][u].getCounter()>=max)
                            {
                                maxcol=u;
                                maxrow=e;
                                max=array[e][u].getCounter();
                            }
                                            }
                                            }
                        
                        array[maxrow][maxcol].setTag(tag);
                        
                        for(int e=0;e<size;e++){
                            for(int u=0;u<k;u++){
                                array[e][u].setCounter(array[e][u].getCounter()+1);
                                                }
                                                }
                        array[maxrow][maxcol].setCounter(0);
                        
                }
       }
   }
    /**
     * @return the k
     */
    public int getK() {
        return k;
    }

    /**
     * @param k the k to set
     */
    public void setK(int k) {
        this.k = k;
    }

    /**
     * @return the b
     */
    public int getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(int b) {
        this.b = b;
    }

    /**
     * @return the c
     */
    public int getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(int c) {
        this.c = c;
    }

    /**
     * @return the array
     */
    public block[][] getArray() {
        return array;
    }

    /**
     * @param array the array to set
     */
    public void setArray(block[][] array) {
        this.array = array;
    }

    /**
     * @return the hit
     */
    public int getHit() {
        return hit;
    }

    /**
     * @param hit the hit to set
     */
    public void setHit(int hit) {
        this.hit = hit;
    }
    
    
}
