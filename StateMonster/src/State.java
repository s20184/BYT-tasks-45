public abstract class State {
    Monster monster;

    State (Monster monster){
        this.monster = monster;
    }

    public abstract String playerEnteredSight();
    public abstract String playerLeftSight();
    public abstract String monsterKilled();
    public abstract String monsterRevived();
}

class IdleState extends State {

    IdleState(Monster monster){
        super(monster);
    }

    @Override
    public String playerEnteredSight() {
        return "Monster can't attack when idle!";
    }

    @Override
    public String playerLeftSight(){
        return "Monster likely never saw a player to begin with.";
    }

    @Override
    public String monsterKilled() {
        monster.changeState(new DeadState(monster));
        return "Monster now dead (due to natural causes).";
    }

    @Override
    public String monsterRevived() {
        return null;
    }
}

class ActiveState extends State {

    ActiveState(Monster monster){
        super(monster);
    }

    @Override
    public String playerEnteredSight() {
        monster.changeState(new AggressiveState(monster));
        return "Monster now attacking!";
    }

    @Override
    public String playerLeftSight() {
        return "Monster likely never saw a player to begin with";
    }

    @Override
    public String monsterKilled() {
        monster.changeState(new DeadState(monster));
        return "Monster now dead (due to natural causes).";
    }

    @Override
    public String monsterRevived() {
        return null;
    }
}

class AggressiveState extends State {

    AggressiveState(Monster monster){
        super(monster);
    }

    @Override
    public String playerEnteredSight() {
        monster.addPlayer();
        return "Monster is hunting more players!";
    }

    @Override
    public String playerLeftSight(){
        monster.removePlayer();
        if(monster.hasPlayersInRange()) {
            return "Monster lost sight of one player, but more remain!";
        } else {
            monster.changeState(new IdleState(monster));
            return "Monster has lost sight of all players and is now idle.";
        }
    }

    @Override
    public String monsterKilled() {
        monster.kill();
        monster.changeState(new DeadState(monster));
        return "Monster has died.";
    }

    @Override
    public String monsterRevived() {
        return "Monster can't be revived when alive!";
    }
}

class DeadState extends State {

    DeadState(Monster monster){
        super(monster);
    }

    @Override
    public String playerEnteredSight() {
        monster.addPlayer();
        return "Monster can't do anything because it's dead...";
    }

    @Override
    public String playerLeftSight(){
        monster.removePlayer();
        return "Monster can't do anything because it's dead...";
    }

    @Override
    public String monsterKilled() {
        monster.kill();
        return "Monster now killed more than once?";
    }

    @Override
    public String monsterRevived() {
        monster.revive();
        if(monster.hasPlayersInRange()) {
            this.monster.changeState(new AggressiveState(monster));
            return "Monster has been revived and is hunting!";
        } else {
            this.monster.changeState(new IdleState(monster));
            return "Monster has been revived and is idle.";
        }
    }
}