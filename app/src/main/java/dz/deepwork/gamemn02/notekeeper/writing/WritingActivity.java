package dz.deepwork.gamemn02.notekeeper.writing;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import dz.deepwork.gamemn02.notekeeper.R;
import dz.deepwork.gamemn02.notekeeper.data.Note;
import dz.deepwork.gamemn02.notekeeper.data.NoteRepository;

public class WritingActivity extends AppCompatActivity {

    public static final String EXTRA_NOTE_INDEX = "dz.deepwork.gamemn02.notekeeper.noteindex";
    public static final int NOTE_INDEX_NEW_NOTE = -1;

    private boolean mNewNote;
    private int mNoteIndex;

    public static Intent createIntent(Context context, int noteIndex) {
        Intent intent = new Intent(
                context,
                WritingActivity.class);
        intent.putExtra(
                EXTRA_NOTE_INDEX,
                noteIndex);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mNoteIndex = getIntent().getIntExtra(EXTRA_NOTE_INDEX, NOTE_INDEX_NEW_NOTE);
        mNewNote = mNoteIndex == NOTE_INDEX_NEW_NOTE;

        if (!mNewNote) {
            TextView titleTextView = (TextView) findViewById(R.id.et_title);
            TextView bodyTextView = (TextView) findViewById(R.id.et_body);
            Note note = NoteRepository.getInstance().getNotes().get(mNoteIndex);
            titleTextView.setText(note.getTitle());
            bodyTextView.setText(note.getBody());
        }
    }

}
