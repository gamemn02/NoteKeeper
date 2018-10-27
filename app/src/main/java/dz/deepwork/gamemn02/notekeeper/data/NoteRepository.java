package dz.deepwork.gamemn02.notekeeper.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NoteRepository {
    private static final Object LOCK = new Object();

    private static NoteRepository sInstance;
    private static ArrayList<Note> sNotes;

    public static NoteRepository getInstance() {
        if (sInstance == null) {
            synchronized (LOCK) {
                if (sInstance == null) {
                    sInstance = new NoteRepository();
                }
            }
        }
        return sInstance;
    }

    private NoteRepository() {
        sNotes = new ArrayList<Note>(Arrays.asList(
                new Note("title1", "body1"),
                new Note("title2", "body2"),
                new Note("title3", "body3")));
    }

    public List<Note> getNotes() {
        return sNotes;
    }

    public void addNote(Note note) {
        sNotes.add(note);
    }

    public void editNote(int index, Note note) {
        sNotes.set(index, note);
    }
}
