// This should work for memory

public class memory {
    // memmory = instance variable
    private memInfo memory;

    // Initialises the memory instance variable. This allows the memory class to use memInfo
    public memory() {
        memory = new memInfo();
    }
    public void readMemory() {
        memory.read();
    }

    // Methods to call if needed
    public double getTotalMemory() {
        readMemory();
        return (double) memory.getTotal()/ 1048576;
    }

    public double getUsedMemory() {
        readMemory();
        return (double) memory.getUsed()/ 1048576;
    }

    public double getFreeMemory() {
        readMemory();
        return ( (double) getTotalMemory() - getUsedMemory());
    }

    public double getMemoryAsAPercentage() {
        readMemory();
        return (double) ((getUsedMemory() / (double) getTotalMemory()) * 100);
    }

    // 2d array
    // String[][] specifies the return type of the method getMemoryInfoAs2DArray i.e 2D array
    public String[][] getMemoryInfoAs2DArray() {
        readMemory();
        // this creates a 4x1 array that holds a string value
        String[][] memoryInfo = new String[4][1];

        // Gives the array data
        memoryInfo[0][0] = String.valueOf(getTotalMemory());
        memoryInfo[1][0] = String.valueOf(getUsedMemory());
        memoryInfo[2][0] = String.valueOf(getFreeMemory());
        memoryInfo[3][0] = String.valueOf(getMemoryAsAPercentage());

        return memoryInfo;
    }


}

