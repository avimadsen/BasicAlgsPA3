public class minHeap {
	int currentSize;
	Soldier[] Heap;

	public minHeap(int heapSize)
	{
		Heap = new Soldier[heapSize];
		currentSize=0;
		Heap[0] = null;
	}
	int parent(int p)
	{
		return p/2;
	}
	int left(int p)
	{
		return 2*p;
	}
	int right(int p)
	{
		return((2*p)+1);
	}
	void swap(int x, int y)
	{
		Soldier temp = Heap[x];
		Heap[x] = Heap[y];
		Heap[x].pos =x;
		Heap[y] = temp;
		Heap[y].pos = y;
	}
	void heapify(int p)
	{
		/*if(p <= currentSize/2 && p >= currentSize)
		{

		 */
		int compare1;
		 int compare2;
		 if(Heap[left(p)]!= null)
			 compare1 = Long.compare(Heap[p].score, Heap[(left(p))].score);
		 else
			 compare1=0;
		 if(Heap[right(p)] != null)
			 compare2 = Long.compare(Heap[p].score, Heap[(right(p))].score);
		 else
			 compare2 = 0;

		 if(compare1>0 || compare2>0)
		 {
			 if(Heap[right(p)] != null && Heap[left(p)] != null)
			 {
				 int compare3 = 	Long.compare(Heap[left(p)].score, Heap[(right(p))].score);

				 if(compare3<0)
				 {
					 swap(p,left(p));
					 heapify(left(p));
				 }
				 else
				 {
					 swap(p,right(p));
					 heapify(right(p));
				 }
			 }
			 else if(Heap[right(p)] == null && Heap[left(p)] != null )
			 {
				 swap(p,left(p));
				 heapify(left(p));
			 }
			 else if(Heap[right(p)] != null && Heap[left(p)] == null )
			 {
				 swap(p,right(p));
				 heapify(right(p));
			 }
		 }
		 //}

	}
	void insert(Soldier insertSoldier)
	{
		Heap[currentSize+1] = insertSoldier;
		currentSize++;
		Heap[currentSize].pos = currentSize;
		int justInserted = currentSize;
		if(Heap[justInserted]!= null && Heap[parent(justInserted)] != null)
		{
			int compare = Long.compare(Heap[justInserted].score, Heap[parent(justInserted)].score);
			while(compare <0)
			{
				swap(justInserted, parent(justInserted));
				justInserted = parent(justInserted);
				if(Heap[justInserted]!= null && Heap[parent(justInserted)] != null)
				{
					compare = Long.compare(Heap[justInserted].score, Heap[parent(justInserted)].score);
				}
				else
					compare =0;
			}
		}
	}
	void buildHeap()
	{
		for(int i=currentSize/2; i>=1;i--)
		{
			heapify(i);
		}
	}
	public void printHeap()
	{
		for(int i=1; i<currentSize+1; i++)
		{
			System.out.println(Heap[i].name +" " +  Heap[i].score);
		}
	}
	Soldier removeMin()
	{
		Soldier min = Heap[1];
		Heap[1] = Heap[currentSize];
		Heap[currentSize] = null;
		currentSize--;
		heapify(1);
		return min;
	}
	Soldier peak()
	{
		return Heap[1];
	}
}
