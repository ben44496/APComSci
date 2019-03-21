import kareltherobot.*;


public class SortableRobot extends Robot implements Comparable<SortableRobot> {

    public SortableRobot(int st, int av, int beepers){
        super(st, av, North, beepers);

    }


    @Override
    public int compareTo(SortableRobot other) {
        return super.beepers()-other.beepers();
    }

    public void showAllBeeps() {
        while(super.anyBeepersInBeeperBag()){
            this.putBeeper();
            this.move();
        }
        System.out.println("Done");
    }

    public void swapLocations(SortableRobot robot){
        int st = this.street(), av = this.avenue();
        this.moveTo(robot);
        robot.moveTo(st, av);
    }

    public void moveTo(int st, int av){
        turnTo(North);
        //x coord
        System.out.println(this.avenue());
        if(this.avenue()<=av) {this.turnTo(East); System.out.println("East");}
        else if(this.avenue()>av){this.turnTo(West); System.out.println("West");}
        else System.out.println("moveTo(int st, int av) broken x value");
        this.move(Math.abs(av-avenue()));
        turnTo(North);
        //y coord
        System.out.println(this.street());
        if(this.street()<=st){this.turnTo(North); System.out.println("North");}
        else if(this.street()>st){this.turnTo(South); System.out.println("South");}
        else System.out.println("moveTo(int st, int av) broken y value");
        this.move(Math.abs(st-this.street()));

    }
    public void moveTo(SortableRobot robot){
        moveTo(robot.street(), robot.avenue());
    }
    public void Switch(SortableRobot robot){

    }
    public void turnTo(Direction dir){

        //make it turn to Direction dir
            while(!this.direction().equals(dir)){
                super.turnLeft();
            }
    }
    public void move(int steps){
        for(int i =0; i<steps; i++){
            super.move();
        }
    }

}
