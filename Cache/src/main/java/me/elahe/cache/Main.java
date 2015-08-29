/*
 * In The Name Of God
 * ========================================
 * [] File Name : main.java
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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("data.txt"));
			int c = Integer.parseInt(sc.next());
			int b = Integer.parseInt(sc.next());
			int k = Integer.parseInt(sc.next());
			int ac = Integer.parseInt(sc.next());
			int way = Integer.parseInt(sc.next());
			Cache cache = new Cache(k, b, c, way);
			int a[] = new int[ac];
			for (int i = 0; i < ac; i++) {
				a[i] = Integer.parseInt(sc.next());
			}
			for (int i = 0; i < ac; i++) {
				cache.check(a[i]);
			}
			System.out.println("number of access : " + ac);
			System.out.println("hits : " + cache.getHit());
			int aaa = ac - cache.getHit();
			System.out.println("misses : " + aaa);
			System.out.println("hit radio :" + (double) cache.getHit() * 100 / (double) ac);
		} catch (FileNotFoundException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}


	}
}
