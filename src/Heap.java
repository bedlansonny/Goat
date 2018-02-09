public class Heap
{
    Goat[] arr;
    int size;
    int nextInd;

    public Heap(int capacity)
    {
        arr = new Goat[capacity];
        size = 0;
        nextInd = 0;
    }

    public int killGoat()
    {
        if(arr[0].output() == arr[1].output() || arr[0].output() == arr[2].output())
            return -1;


        int output = arr[0].output();

        size--;
        swap(0, nextInd-1);
        nextInd--;
        int currentInd = 0;

        while(arr[currentInd].output() > arr[2*currentInd+1].output() ||
                arr[currentInd].output() > arr[2*currentInd+2].output())
        {
            int smallInd = 2*currentInd+1;
            if(arr[smallInd].output() > arr[2*currentInd+2].output())
                smallInd = 2*currentInd+2;
            swap(currentInd, smallInd);
            currentInd = smallInd;
        }

        return output;
    }

    public void nextDay()
    {
        //store goats in temp arr
        Goat[] tempArr = arr;           //deep copy???

        //reset heap
        arr = new Goat[arr.length];
        size = 0;
        nextInd = 0;

        //nextDay() each goat
        //add each goat w add()
        for(Goat goat : tempArr)
        {
            goat.nextDay();
            add(goat);
        }
    }

    public void add(Goat obj)
    {
        size++;

        int currentInd = nextInd;
        nextInd++;
        arr[currentInd] = obj;

        while(arr[currentInd].compareTo(arr[(currentInd-1)/2]) < 0)
        {
            swap(currentInd, (currentInd-1)/2);
            currentInd = (currentInd-1)/2;
        }
    }

    private void swap(int i1, int i2)
    {
        Goat temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }


}
