package br.com.davividal.churrascometro;

import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by davi_000 on 29/03/2016.
 */
public class PeopleBarListener implements SeekBar.OnSeekBarChangeListener {
    private final TextView textView;

    public PeopleBarListener(TextView textView) {
        this.textView = textView;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        //this.textView.setText(Integer.toString(progress));
        this.textView.setText(Integer.toString(seekBar.getProgress()));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
