package dz.deepwork.gamemn02.notekeeper.writing;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import dz.deepwork.gamemn02.notekeeper.R;

public class WritingActivity extends AppCompatActivity {

    public static final String BUNDLE_NOTE_INDEX = "dz.deepwork.gamemn02.notekeeper.noteindex";
    public static final int NOTE_INDEX_NEW_NOTE = -1;

    private boolean mNewNote;
    private int mNoteIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mNoteIndex = getIntent().getIntExtra(BUNDLE_NOTE_INDEX, NOTE_INDEX_NEW_NOTE);
        mNewNote = mNoteIndex == NOTE_INDEX_NEW_NOTE;

    }

}
