/**
 * This class represents the state machine diagram of the lunar explorer
 *
 *
 * @author manuelhernandez
 * @version 1.0 October 13, 2017
 */
public class Rover {

    public enum Status {
        IDLE,
        MOVEFORWARD_A,
        MOVEFORWARD_C,
        MOVEBACKWARD_A,
        MOVEBACKWARD_C,
        DEACCELERATES
    }

    public void interactRover(){
        Status status = Status.IDLE;
        int speed = 0;
        switch (status){
            case IDLE:
                if(rp_5sec() == true || (rp_once() == true)) {
                    System.out.println("Current state: IDLE");
                    System.out.println("--Right Pedal 5 sec-- OR --Right Pedal Once--");
                    System.out.print("Next state -> MOVEFORWARD_A");
                }
                else if(lp_once() == true){
                    System.out.println("Current state: IDLE");
                    System.out.println("--Left Pedal Once--");
                    System.out.print("Next state -> MOVEBACKWARD_A");
                }

            case MOVEFORWARD_A:
                if(rp_5sec() == true || (lp_once() == true)){
                    System.out.println("Current state: MOVEFORWARD_A");
                    System.out.println("--Right Pedal 5 sec-- OR --Left Pedal Once--");
                    System.out.print("Next state -> MOVEFORWARD_C");
                }
                if(rp_twice() == true){
                    System.out.println("Current state: MOVEFORWARD_A");
                    System.out.println("--Right Pedal Twice--");
                    System.out.print("Next state -> DEACCELERATE");
                }

            case MOVEFORWARD_C:
                if(rp_twice() == true){
                    System.out.println("Current state: MOVEFORWARD_C");
                    System.out.println("--Right Pedal Twice--");
                    System.out.print("Next state -> DEACCELERATE");
                }
            case MOVEBACKWARD_A:
                if(lp_once() == true){
                    System.out.println("Current state: MOVEBACKWARD_A");
                    System.out.println("--Left Pedal Once--");
                    System.out.print("Next state -> MOVEBACKWARD_C");
                }
            case MOVEBACKWARD_C:
                if(rp_once() == true){
                    System.out.println("Current state: MOVEBACKWARD_C");
                    System.out.println("--Right Pedal Once--");
                    System.out.print("Next state -> MOVEFORWARD_A");
                }
            case DEACCELERATES:
                if(getSpeed(speed) == 0){
                    System.out.println("Current state: DEACCELERATE");
                    System.out.println("--Speed Slow Down to Zero--");
                    System.out.print("Next state -> IDLE");
                }

        }
    }

    /**
     *
     * @return boolean
     */
    public boolean rp_once(){
        return true;
    }
    /**

     * @return boolean
     */
    public boolean rp_twice(){
        return true;
    }
    /**

     * @return boolean
     */
    public boolean rp_5sec(){
        return true;
    }
    /**
     *
     * @return boolean
     */
    public boolean lp_once(){
        return true;
    }
    /**
     *
     * @return boolean
     */
    public boolean lp_twice(){
        return true;
    }
    /**
     *
     * @return boolean
     */
    public boolean lp_5sec(){
        return true;
    }

}