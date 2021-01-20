
import java.io.*;
import java.util.*;
import java.util.HashMap;
public class Solution {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int numOfCandidates = sc.nextInt();
		HashMap<String, Soldier> mapOfSoldiers = new HashMap<String, Soldier>();
		minHeap heapOfSoldiers = new minHeap(100);

		for(int i=0; i< numOfCandidates; i++)
		{
			String nameOfSoldier = sc.next();
			long scoreOfSoldier = sc.nextLong();
			int startPos = i+1;
			Soldier newSoldier = new Soldier(nameOfSoldier,scoreOfSoldier,startPos);
			mapOfSoldiers.put(nameOfSoldier, newSoldier);
			heapOfSoldiers.insert(newSoldier);
		}
		heapOfSoldiers.buildHeap();
		//heapOfSoldiers.printHeap();
		//System.out.println(mapOfSoldiers.get("g").score);

		int numOfInquiries = sc.nextInt();
		int typeOfInquiry;

		for(int i=0; i< numOfInquiries; i++)
		{		
			typeOfInquiry = sc.nextInt();
			if(typeOfInquiry == 1)
			{
				String soldierName = sc.next();
				long improvement = sc.nextLong();
				Soldier improved = mapOfSoldiers.get(soldierName);
				improved.score = improved.score+improvement;
				heapOfSoldiers.heapify(improved.pos);
			}
			if(typeOfInquiry == 2)
			{			
				long standard = sc.nextLong();
				int compare = Long.compare(heapOfSoldiers.peak().score, standard);
				while(compare<0)
				{
					heapOfSoldiers.removeMin();
					if(heapOfSoldiers.peak()!=null)
						compare = Long.compare(heapOfSoldiers.peak().score, standard);
					else
						compare =0;
				}
				System.out.println(heapOfSoldiers.currentSize);
			}

		}

	}
}

