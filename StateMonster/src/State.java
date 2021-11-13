abstract class State {
    private Monster monster;

    State (Monster monster){
        this.monster = monster;
    }
}

class IdleState extends State {

    IdleState(Monster monster){
        super(monster);
    }
}

class ActiveState extends State {

    ActiveState(Monster monster){
        super(monster);
    }
}

class AggressiveState extends State {

    AggressiveState(Monster monster){
        super(monster);
    }
}

class DeadState extends State {

    DeadState(Monster monster){
        super(monster);
    }
}