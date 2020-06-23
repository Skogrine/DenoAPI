package fr.denoria.api.gameapi;


public enum GameState {
    WAITING(1), RUNNING(2), FINISHED(3), STOPPING(4);

    public static GameState getStatus(int id) {
        for (final GameState status : values()) {
            if (status.getId() == id)
                return status;
        }

        return null;
    }

    private final int id;

    private GameState(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
