package com.cs.guava;

import com.google.common.collect.*;

import java.util.ArrayList;

/**
 * Created by chensheng350 on 2017/7/13.
 */
public class GuavaDemo {



	    public static void main(String[] args){

			Multiset<Integer> multiset = HashMultiset.create();
			multiset.add(1);
			multiset.add(2);
			multiset.add(3);
			multiset.add(1);


			multiset.elementSet()
					.forEach(integer -> System.out.println(String.format("%s-->%s", integer, multiset.count(integer))));


			RangeSet<Integer> rs = TreeRangeSet.create();


			rs.add(Range.closed(1,3));
			rs.add(Range.open(10, 15));

			System.out.println(rs.contains(2));
			System.out.println(rs.contains(7));
			System.out.println(rs.contains(10));
			System.out.println(rs.contains(12));
			System.out.println(rs.contains(18));

			ArrayList<String> list = Lists.newArrayList();


		}
}
