package dz.deepwork.gamemn02.notekeeper.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NoteRepository {
    private static final Object LOCK = new Object();

    private static NoteRepository sInstance;
    private static ArrayList<Note> sNotes;

    public static NoteRepository getsInstance() {
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
