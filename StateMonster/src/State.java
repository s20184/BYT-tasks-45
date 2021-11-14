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
        monster.addPlayer();
        monster.changeState(new AggressiveState(monster));
        return "Monster is now hunting a player!";
    }

    @Override
    public String playerLeftSight() {
        return "Monster has likely never seen players...";
    }

    @Override
    public String monsterKilled() {
        monster.changeState(new DeadState(monster));
        return "Monster now dead (due to natural causes).";
    }

    @Override
    public String monsterRevived() {
        return "Revival was ineffective due to the monster being alive.";
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
        return "Revival was ineffective due to the monster being alive.";
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