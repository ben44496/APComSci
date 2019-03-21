import kareltherobot.*;

public class RunClass {

    public static void main(String args[]){
        World.setVisible(true);
        World.setDelay(10);
        World.setSize(30,10);

        SortableRobot array[] = new SortableRobot[5];

        makeRobots(array, 10);
        //findMax(array);// find the SR with most beeps and have
                        // that bot showAllBeeps
        //findMin(array);
        //array[0].moveTo(6,3);
        //bubbleSort(array);
        System.out.println(scrambleWord("STAR"));

    }
    /**
     * Takes input array and max beepers possible to generate an array of
     * SortableRobots as specified by the array and lining them up on the bottom.
     * @param robots,
     * @param maxBeepers
     */
    public static void makeRobots(SortableRobot robots[], int maxBeepers){
        int random;
        for (int i=0;i<robots.length; i++){
            random = (int)(Math.random()*maxBeepers);
            robots[i] = new SortableRobot(1,i+1,random);
        }
    }

    /**
     * Bubble sorts all the bots in the specified array.  It should
     * move the bots around the World as they are being swapped in the
     * array.  After sorting, tell all SortableRobots to showAllBeeps
     * @param bots
     */

    private static void bubbleSort(SortableRobot[] bots) {

        SortableRobot robot;
        boolean didISwitch = true;
        /*
        int i =0;
        bots[i].swapLocations(bots[i+1]);
        robot = bots[i];
        bots[i] = bots[i+1];
        bots[i+1] = robot;

        */
        //int a = bots.length;
        int counter = 0;
        while(didISwitch) {
            for (int i = 0; i + 1 < bots.length; i++) {
                counter=0;
                if (bots[i].compareTo(bots[i + 1]) >= 0) {
                    bots[i].swapLocations(bots[i + 1]);
                    robot = bots[i];
                    bots[i] = bots[i + 1];
                    bots[i + 1] = robot;
                    counter++;
                } else {
                    System.out.println("same");
                }
                if (counter > 0){
                    didISwitch = true;
                }else if (counter==0) didISwitch = false;
                else System.out.println("Sum ting wong");
            }


        }
        everybodyShowBeeps(bots);

    }
    /**
     * Takes input array of SortableRobots and finds the Robot with
     * min num of beeps and tells it to showAllBeeps (first instance of min)
     * @param bots
     */
    private static void findMin(SortableRobot[] bots) {
        SortableRobot smallest = bots[0];
        for (SortableRobot robot : bots){
            if (robot!=null && robot.compareTo(smallest)<=0){
            smallest = robot;

            }
        }
        smallest.showAllBeeps();
        System.out.println(smallest);
    }
    /**
     * Takes input array of SortableRobots and finds the Robot with
     * max num of beeps and tells it to showAllBeeps
     * @param bots
     */
    private static void findMax(SortableRobot[] bots) {
        int largest=0;
        SortableRobot robot = bots[0];
        for(int i = 0; i+1<bots.length; i++){
            //the below thing was to see if there were two both with same number as minimums
            /*if (bots[i].compareTo(bots[i+1]) == 0){

            }*/
            if(bots[i].compareTo(bots[i+1])>=0){
                robot = bots[i];
                largest = i;
            }
        }
        robot.showAllBeeps();
        System.out.println(largest);
    }
    private static void everybodyShowBeeps(SortableRobot[] array){
        for(int i=0; i<array.length; i++){
            array[i].showAllBeeps();
        }
    }
    public static String scrambleWord(String word){
        String finale="";
        
        for(int i=0; i+2<word.length(); i++){
            if(word.substring(word.length()-2,word.length()-1).equals("A")){
                String begin = word.substring(0,word.length()-2);
                String one = word.substring(word.length()-2,word.length()-1);
                String two = word.substring(word.length()-1);
                finale = begin+two+one;
            }/*
            if(word.substring(i,i+1).equals("A")){
                String rest = word.substring(i+2);
                String one = word.substring(i,i+1);
                String two = word.substring(i+1,i+2);
                finale=two+one+rest;
            }*/
        }return finale;

    }

}
