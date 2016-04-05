package br.com.davividal.churrascometro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView menTxt = (TextView)findViewById(R.id.menQty);
        TextView womenTxt = (TextView)findViewById(R.id.womenQty);
        TextView childrenTxt = (TextView)findViewById(R.id.childrenQty);

        SeekBar menBar = (SeekBar)findViewById(R.id.men_bar);
        SeekBar womenBar = (SeekBar)findViewById(R.id.women_bar);
        SeekBar childrenBar = (SeekBar)findViewById(R.id.children_bar);

        menBar.setOnSeekBarChangeListener(new PeopleBarListener(menTxt));
        womenBar.setOnSeekBarChangeListener(new PeopleBarListener(womenTxt));
        childrenBar.setOnSeekBarChangeListener(new PeopleBarListener(childrenTxt));
    }

    public void calculate(View view) {
        TextView menTxt = (TextView)findViewById(R.id.menQty);
        TextView womenTxt = (TextView)findViewById(R.id.womenQty);
        TextView childrenTxt = (TextView)findViewById(R.id.childrenQty);

        Intent it = new Intent(this, CalcResult.class);
        Bundle params = new Bundle();
        params.putInt("men", Integer.parseInt(menTxt.getText().toString()));
        params.putInt("women", Integer.parseInt(womenTxt.getText().toString()));
        params.putInt("children", Integer.parseInt(childrenTxt.getText().toString()));

        it.putExtras(params);
        startActivity(it);
    }
}
