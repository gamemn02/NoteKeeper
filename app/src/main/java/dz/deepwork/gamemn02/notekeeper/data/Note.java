package dz.deepwork.gamemn02.notekeeper.data;

public class Note {

    private String title;
    private String body;

    public Note(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return title + "\n\t" + body;
    }
}
