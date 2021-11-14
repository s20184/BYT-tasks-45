public class Monster {
    private State state;
    private int playersInRange;
    boolean alive = true;

    public Monster(){
        this.state = new IdleState(this);
        this.playersInRange = 0;
    }

    public void changeState(State state){
        this.state = state;
    }

    public State getState(){
        return this.state;
    }

    public void addPlayer(){
        this.playersInRange++;
    }

    public void removePlayer(){
        this.playersInRange--;
    }

    public void kill() { this.alive = false; }

    public void revive() { this.alive = true; }

    public boolean isAlive() { return this.alive; }

    public boolean hasPlayersInRange(){
        return playersInRange > 0;
    }
}
